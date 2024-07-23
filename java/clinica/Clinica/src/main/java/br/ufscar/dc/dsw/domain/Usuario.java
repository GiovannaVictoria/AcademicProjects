package br.ufscar.dc.dsw.domain;

public class Usuario {

	private String email;
	private String login;
	private String nome;
	private String papel;
	private String senha;

	public Usuario(String email, String login, String nome, String papel, String senha) {
		this.email = email;
		this.login = login;
		this.nome = nome;
		this.papel = papel;
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String password) {
		this.senha = password;
	}

}