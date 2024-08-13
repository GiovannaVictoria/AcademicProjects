package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IConsultaDAO;
import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;
import br.ufscar.dc.dsw.service.spec.IConsultaService;

@Service
@Transactional(readOnly = false)
public class ConsultaService implements IConsultaService {
	
	@Autowired
	IConsultaDAO dao;
	
	public Consulta buscarPorId(long id) {
		return dao.findById(id);
	}
	
	public List<Consulta> buscarPorMedico(Medico medico) {
		return dao.findByMedico(medico);
	}
	
	public List<Consulta> buscarPorPaciente(Paciente paciente) {
		return dao.findByPaciente(paciente);
	}
	
	public List<Consulta> buscarPorData(String data) {
		return dao.findByData(data);
	}

	public void salvar(Consulta consulta) {
		dao.save(consulta);
	}

	@Transactional(readOnly = true)
	public List<Consulta> buscarTodos() {
		return dao.findAll();
	}

}
