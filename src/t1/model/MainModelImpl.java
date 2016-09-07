package t1.model;

import t1.view.dados.ListaLivrosEmprestados;
import t1.view.objects.DadosLogin;

public class MainModelImpl implements Model {

	private DadosLogin dadosLogin;

	private ListaLivrosEmprestados livros;

	public ListaLivrosEmprestados getLivros() {
		return this.livros;
	}

	public void setLivros(ListaLivrosEmprestados livros) {
		this.livros = livros;
	}

	public DadosLogin getDadosLogin() {
		return this.dadosLogin;
	}

	public void setDadosLogin(DadosLogin dadosLogin) {
		this.dadosLogin = dadosLogin;
	}

}
