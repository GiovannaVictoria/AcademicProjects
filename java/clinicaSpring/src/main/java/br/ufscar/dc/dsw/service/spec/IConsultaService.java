package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Consulta;
import br.ufscar.dc.dsw.domain.Medico;
import br.ufscar.dc.dsw.domain.Paciente;

public interface IConsultaService {
	
	Consulta buscarPorId(long id);
	
	List<Consulta> buscarPorMedico(Medico medico);
	
	List<Consulta> buscarPorPaciente(Paciente paciente);
	
	List<Consulta> buscarPorData(String data);

	List<Consulta> buscarTodos();

	void salvar(Consulta consulta);

}
