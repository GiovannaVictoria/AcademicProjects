package br.ufscar.dc.dsw.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufscar.dc.dsw.domain.Especialidade;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Ordenacao;
import br.ufscar.dc.dsw.service.spec.IMedicoService;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private IMedicoService medicoService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("especialidades", Especialidade.values());
		return "index";
	}
	
	@GetMapping("/listagemGeral")
	public String listagemGeral(Model model) {
		List<Medico> medicos = medicoService.buscarTodos();
		Collections.sort(medicos, Ordenacao.MEDICO_POR_ESPECIALIDADE_NOME_CRM.getComparator());
		model.addAttribute("medicos", medicos);
		return "listagemGeral";
	}
	
	@GetMapping("/listagemEspecialidade")
	public String listagemEspecialidade(@RequestParam("especialidade") String especialidade, Model model) {
		List<Medico> medicos = medicoService.buscarPorEspecialidade(especialidade);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(especialidade);
		Collections.sort(medicos, Ordenacao.MEDICO_POR_ESPECIALIDADE_NOME_CRM.getComparator());
		model.addAttribute("medicos", medicos);
		return "listagemEspecialidade";
	}

}
