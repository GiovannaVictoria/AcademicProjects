package br.ufscar.dc.dsw.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Medico")
@SuppressWarnings("serial")
public class Medico extends Usuario {
	
	@NotBlank
	@Column(nullable = false, length = 32, unique = true)
	private String CRM;
	
	@NotBlank
	@Column(nullable = false, length = 64)
	private String especialidade;
	
//	@OneToMany(mappedBy = "medico")
//	private ArrayList<Consulta> consultas;
//	
//	public void adicionarConsulta(Consulta consulta) {
//		this.consultas.add(consulta);
//	}
//	
//	public ArrayList<Consulta> getConsultas() {
//		return consultas;
//	}
//	
//	public void setConsultas(ArrayList<Consulta> consultas) {
//		this.consultas = consultas;
//	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String CRM) {
		this.CRM = CRM;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}