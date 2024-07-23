package br.ufscar.dc.dsw.domain;

public class Consulta {

	long protocolo;
	String CPF;
	String CRM;
	String especialidade;
	String nomeMedico;
	String nomePaciente;
	String horario;
	
	public Consulta(long protocolo) {
		this.protocolo = protocolo;
	}

	public Consulta(String CPF, String CRM, String especialidade, String nomeMedico, String nomePaciente, String horario) {
		this.CPF = CPF;
		this.CRM = CRM;
		this.especialidade = especialidade;
		this.nomeMedico = nomeMedico;
		this.nomePaciente = nomePaciente;
		this.horario = horario;
	}
	
	public Consulta(long protocolo, String CPF, String CRM, String especialidade, String nomeMedico, String nomePaciente, String horario) {
		this.protocolo = protocolo;
		this.CPF = CPF;
		this.CRM = CRM;
		this.especialidade = especialidade;
		this.nomeMedico = nomeMedico;
		this.nomePaciente = nomePaciente;
		this.horario = horario;
	}
	
	public long getProtocolo() {
		return protocolo;
	}
	
	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}
	
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getCRM() {
		return CRM;
	}

	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}

}