package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;

@SuppressWarnings("unchecked")
public interface IConsultaDAO extends CrudRepository<Consulta, Long> {
	
	Consulta findById(long id);

	List<Consulta> findAll();
	
	List<Consulta> findByMedico(Medico medico);
	
	List<Consulta> findByPaciente(Paciente paciente);
	
	List<Consulta> findByData(String data);
	
	Consulta save(Consulta consulta);
	
}
