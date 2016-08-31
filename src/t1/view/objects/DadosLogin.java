package t1.view.objects;

import t1.view.dados.Dados;

public class DadosLogin implements Dados {

	private String login;

	private String senha;

	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
