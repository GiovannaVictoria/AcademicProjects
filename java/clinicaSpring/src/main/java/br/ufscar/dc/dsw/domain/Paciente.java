package br.ufscar.dc.dsw.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Paciente")
@SuppressWarnings("serial")
public class Paciente extends Usuario {
	
	@NotBlank
	@Column(nullable = false, length = 32)
	private String dataNascimento;
	
	@NotBlank
	@Column(nullable = false, length = 32, unique = true)
	private String CPF;
	
	@NotBlank
	@Column(nullable = false, length = 32)
	private String genero;
	
	@NotBlank
	@Column(nullable = false, length = 64)
	private String telefone;
	
//	@OneToMany(mappedBy = "paciente")
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
