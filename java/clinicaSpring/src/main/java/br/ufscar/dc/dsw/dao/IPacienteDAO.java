package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Paciente;

@SuppressWarnings("unchecked")
public interface IPacienteDAO extends CrudRepository<Paciente, Long> {
	
	Paciente findById(long id);
	
	Paciente findByCPF(String CPF);

	List<Paciente> findAll();
	
	Paciente save(Paciente paciente);

	void deleteById(Long id);
	
    @Query("SELECT p FROM Paciente p WHERE p.username = :username")
    public Paciente getUserByUsername(@Param("username") String username);

}
