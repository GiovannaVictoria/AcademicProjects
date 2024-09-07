package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IConsultaService;
import br.ufscar.dc.dsw.service.spec.IMedicoService;
import br.ufscar.dc.dsw.service.spec.IPacienteService;

@RestController
public class ConsultaRestController {
	
	@Autowired
	private IConsultaService consultaService;

	@Autowired
	private IMedicoService medicoService;

	@Autowired
	private IPacienteService pacienteService;
	
	private boolean isJSONValid(String jsonInString) {
		try {
			return new ObjectMapper().readTree(jsonInString) != null;
		} catch (IOException e) {
			return false;
		}
	}
	
	private void parse(Consulta consulta, JSONObject json) {
		Map<String, Object> map = (Map<String, Object>) json.get("consulta");

		Object id = json.get("id");
		if (id != null) {
			if (id instanceof Integer) {
				consulta.setId(((Integer) id).longValue());
			} else {
				consulta.setId(((Long) id));
			}
		}
		
		consulta.setMedico((Medico) map.get("medico"));
		consulta.setPaciente((Paciente) map.get("paciente"));
		consulta.setData((String) map.get("data"));
		consulta.setHora((String) map.get("hora"));
	}
	
	@GetMapping(path = "/consultas")
	public ResponseEntity<List<Consulta>> lista() {
		List<Consulta> lista = consultaService.buscarTodos();
		if (lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(path = "/consultas/{id}")
	public ResponseEntity<Consulta> lista(@PathVariable("id") long id) {
		Consulta consulta = consultaService.buscarPorId(id);
		if (consulta == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(consulta);
	}
	
	@GetMapping(path = "/consultas/pacientes/{id}")
	public ResponseEntity<List<Consulta>> listaPaciente(@PathVariable("id") long id) {
		List<Consulta> lista = consultaService.buscarPorPaciente(pacienteService.buscarPorId(id));
		if (lista == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping(path = "/consultas/medicos/{id}")
	public ResponseEntity<List<Consulta>> listaMedico(@PathVariable("id") long id) {
		List<Consulta> lista = consultaService.buscarPorMedico(medicoService.buscarPorId(id));
		if (lista == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lista);
	}

}
