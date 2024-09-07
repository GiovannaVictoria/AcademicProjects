package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Medico;

@SuppressWarnings("unchecked")
public interface IMedicoDAO extends CrudRepository<Medico, Long> {
	
	Medico findById(long id);
	
	Medico findByCRM(String CRM);
	
	List<Medico> findByEspecialidade(String especialidade);

	List<Medico> findAll();
	
	Medico save(Medico medico);

	void deleteById(Long id);
	
    @Query("SELECT m FROM Medico m WHERE m.username = :username")
    public Medico getUserByUsername(@Param("username") String username);

}
