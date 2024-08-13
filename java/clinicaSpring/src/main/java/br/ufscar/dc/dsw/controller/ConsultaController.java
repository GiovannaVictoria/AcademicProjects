package br.ufscar.dc.dsw.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Hora;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Ordenacao;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IConsultaService;
import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IPacienteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaService consultaService;

	@Autowired
	private IMedicoService medicoService;

	@Autowired
	private IPacienteService pacienteService;

	@GetMapping("/cadastrar")
	public String cadastrar(Consulta consulta, ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Paciente paciente = pacienteService.buscarPorLogin(username);

		consulta.setData(LocalDateTime.now().toLocalDate().toString());

		List<Medico> medicos = medicoService.buscarTodos();
		Collections.sort(medicos, Ordenacao.MEDICO_POR_ESPECIALIDADE_NOME_CRM.getComparator());
		model.addAttribute("medicos", medicos);
		model.addAttribute("paciente", paciente);
		model.addAttribute("horas", Hora.values());
		model.addAttribute("consulta", consulta);
		return "consulta/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Paciente paciente = pacienteService.buscarPorLogin(username);
		Medico medico = medicoService.buscarPorLogin(username);
		List<Consulta> consultas = new ArrayList<>();
		if (medico != null) {
			consultas = consultaService.buscarPorMedico(medico);
		} else if (paciente != null) {
			consultas = consultaService.buscarPorPaciente(paciente);
		}
		Collections.sort(consultas, Ordenacao.CONSULTA_POR_DATA_HORA_MEDICO_PACIENTE.getComparator());
		model.addAttribute("consultas", consultas);
		return "consulta/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Consulta consulta, BindingResult result, RedirectAttributes attr, ModelMap model) {

		boolean retornar = false;

		model.addAttribute("medicos", medicoService.buscarTodos());
		model.addAttribute("horas", Hora.values());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Paciente paciente = pacienteService.buscarPorLogin(username);
		consulta.setPaciente(paciente);

		List<Consulta> consultas = new ArrayList<>();
		for (Consulta c : consultaService.buscarPorData(consulta.getData())) {
			if (consulta.getHora().equals(c.getHora())) {
				consultas.add(c);
			}
		}

		for (Consulta c : consultas) {
			if (consulta.getPaciente().getCPF().equals(c.getPaciente().getCPF())) {
				result.rejectValue("data", "error.consulta",
						"Você já tem outra consulta agendada na mesma data e hora.");
				result.rejectValue("hora", "error.consulta",
						"Você já tem outra consulta agendada na mesma data e hora.");
				retornar = true;
			}
			if (consulta.getMedico().getCRM().equals(c.getMedico().getCRM())) {
				result.rejectValue("medico", "error.consulta",
						"Este médico já possui outra consulta agendada na mesma data e hora.");
				retornar = true;
			}
		}

		if (result.hasErrors() || retornar) {
			return "consulta/cadastro";
		}

		consultaService.salvar(consulta);

		attr.addFlashAttribute("sucess", "consulta.create.sucess");
		return "redirect:/consultas/listar";
	}

}
