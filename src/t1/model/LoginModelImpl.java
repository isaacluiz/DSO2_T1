package t1.model;

import t1.view.objects.DadosLogin;

public class LoginModelImpl implements Model {

	public boolean verificaLogin(String senha, DadosLogin loadDadosLogin) {
		return senha.equals(loadDadosLogin.getSenha());
	}

}
