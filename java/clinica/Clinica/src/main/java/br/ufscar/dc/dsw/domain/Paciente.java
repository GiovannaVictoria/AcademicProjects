package br.ufscar.dc.dsw.domain;

public class Paciente extends Usuario {
	
	String CPF;
	String dataNascimento;
	String genero;
	String telefone;
	
	public Paciente(String CPF, String dataNascimento, String email, String genero, String login, String nome, String papel, String senha, String telefone) {
		super(email, login, nome, papel, senha);
		this.CPF = CPF;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}