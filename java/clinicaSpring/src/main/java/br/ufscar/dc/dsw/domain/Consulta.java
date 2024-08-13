package br.ufscar.dc.dsw.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Consulta")
@SuppressWarnings("serial")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Consulta extends AbstractEntity<Long> {
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@NotBlank
	@Column(nullable = false, length = 16)
	private String data;
	
	@NotBlank
	@Column(nullable = false, length = 16)
	private String hora;
	
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}

}
