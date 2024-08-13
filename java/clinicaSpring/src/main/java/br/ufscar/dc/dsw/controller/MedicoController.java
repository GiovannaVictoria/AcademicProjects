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

import br.ufscar.dc.dsw.domain.Especialidade;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Ordenacao;
import br.ufscar.dc.dsw.domain.Papel;
import br.ufscar.dc.dsw.service.spec.IMedicoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private IMedicoService service;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Medico medico, ModelMap model) {
		model.addAttribute("especialidades", Especialidade.values());
		model.addAttribute("papeis", Papel.values());
		return "medico/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		List<Medico> medicos = service.buscarTodos();
		Collections.sort(medicos, Ordenacao.MEDICO_POR_ESPECIALIDADE_NOME_CRM.getComparator());
		model.addAttribute("medicos", medicos);
		return "medico/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Medico medico, BindingResult result, RedirectAttributes attr, ModelMap model) {
		
		boolean retorno = false;
		
		model.addAttribute("especialidades", Especialidade.values());
		model.addAttribute("papeis", Papel.values());
		
		for (Medico m : service.buscarTodos()) {
			if (medico.getCRM().equals(m.getCRM())) {
				result.rejectValue("CRM", "medico.cadastro.error", "Já existe um médico cadastrado com esse CRM.");
				retorno = true;
			}
			if (medico.getUsername().equals(m.getUsername())) {
				result.rejectValue("username", "usuario.cadastro.error", "Já existe um usuário cadastrado com esse login.");
				retorno = true;
			}
		}

		if (result.hasErrors() || retorno) {
			return "medico/cadastro";
		}

		System.out.println("password = " + medico.getPassword());
		medico.setPassword(encoder.encode(medico.getPassword()));
		service.salvar(medico);
		attr.addFlashAttribute("sucess", "medico.create.sucess");
		return "redirect:/medicos/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("especialidades", Especialidade.values());
		model.addAttribute("papeis", Papel.values());
		model.addAttribute("medico", service.buscarPorId(id));
		return "medico/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Medico medico, String novoPassword, BindingResult result, RedirectAttributes attr, ModelMap model) {
		
		model.addAttribute("especialidade", Especialidade.values());
		model.addAttribute("papeis", Papel.values());

		if (result.hasErrors()) {
			return "medico/cadastro";
		}
		
		if (novoPassword != null && !novoPassword.trim().isEmpty()) {
			medico.setPassword(encoder.encode(novoPassword));
		} else {
			System.out.println("Senha não foi editada");
		}
		service.salvar(medico);
		attr.addFlashAttribute("sucess", "medico.edit.sucess");
		return "redirect:/medicos/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("sucess", "medico.delete.sucess");
		return listar(model);
	}

}
