package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Medico;

public interface IMedicoService {
	
	Medico buscarPorId(Long id);
	
	Medico buscarPorLogin(String username);
	
	List<Medico> buscarPorEspecialidade(String especialidade);

	List<Medico> buscarTodos();

	void salvar(Medico medico);

	void excluir(Long id);

}
