package br.ufscar.dc.dsw.domain;

public class Medico extends Usuario {

	String CRM;
	String especialidade;
	
	public Medico(String CRM, String email, String especialidade, String login, String nome, String papel, String senha) {
		super(email, login, nome, papel, senha);
		this.CRM = CRM;
		this.especialidade = especialidade;
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

}