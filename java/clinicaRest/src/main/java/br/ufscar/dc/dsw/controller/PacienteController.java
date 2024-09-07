package br.ufscar.dc.dsw.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Genero;
import br.ufscar.dc.dsw.domain.Ordenacao;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.domain.Papel;
import br.ufscar.dc.dsw.service.spec.IPacienteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Paciente paciente, ModelMap model) {
		model.addAttribute("generos", Genero.values());
		model.addAttribute("papeis", Papel.values());
		return "paciente/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Paciente> pacientes = service.buscarTodos();
		Collections.sort(pacientes, Ordenacao.PACIENTE_POR_NOME_EMAIL_CPF_TELEFONE_DATANASCIMENTO_GENERO.getComparator());
		model.addAttribute("pacientes", pacientes);
		return "paciente/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Paciente paciente, BindingResult result, RedirectAttributes attr, ModelMap model) {
		
		boolean retorno = false;
		
		model.addAttribute("generos", Genero.values());
		model.addAttribute("papeis", Papel.values());
		
		for (Paciente p : service.buscarTodos()) {
			if (paciente.getCPF().equals(p.getCPF())) {
				result.rejectValue("CPF", "paciente.cadastro.error", "Já existe um paciente cadastrado com esse CPF.");
				retorno = true;
			}
			if (paciente.getUsername().equals(p.getUsername())) {
				result.rejectValue("username", "usuario.cadastro.error", "Já existe um usuário cadastrado com esse login.");
				retorno = true;
			}
		}

		if (result.hasErrors() || retorno) {
			return "paciente/cadastro";
		}

		System.out.println("password = " + paciente.getPassword());
		paciente.setPassword(encoder.encode(paciente.getPassword()));
		service.salvar(paciente);
		attr.addFlashAttribute("sucess", "paciente.create.sucess");
		return "redirect:/pacientes/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("generos", Genero.values());
		model.addAttribute("papeis", Papel.values());
		model.addAttribute("paciente", service.buscarPorId(id));
		return "paciente/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Paciente paciente, String novoPassword, BindingResult result, RedirectAttributes attr, ModelMap model) {
		
		model.addAttribute("generos", Genero.values());
		model.addAttribute("papeis", Papel.values());

		if (result.hasErrors()) {
			return "paciente/cadastro";
		}

		if (novoPassword != null && !novoPassword.trim().isEmpty()) {
			paciente.setPassword(encoder.encode(novoPassword));
		} else {
			System.out.println("Senha não foi editada");
		}
		service.salvar(paciente);
		attr.addFlashAttribute("sucess", "paciente.edit.sucess");
		return "redirect:/pacientes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("sucess", "paciente.delete.sucess");
		return listar(model);
	}

}
