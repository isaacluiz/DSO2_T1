package t1.model;

import t1.exceptions.UserNotHaveBookException;
import t1.view.dados.ListaLivrosEmprestados;
import t1.view.objects.DadosLogin;
import t1.view.objects.Livro;

public class DevolverLivroModelImpl implements Model {

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

	public void verificaUsuarioPossuiLivro(Livro livro) throws UserNotHaveBookException {
		for (String user : this.livros.getLivrosEmprestados().keySet()) {
			if (user.equals(this.dadosLogin.getLogin())) {
				for (Livro l : this.livros.getLivrosEmprestados().get(user)) {
					if (l.getID().equals(livro.getID()) && (l.getDataDevolucao() == null)) {
						livro.setDataRetirada(l.getDataRetirada());
						return;
					}
				}
				throw new UserNotHaveBookException();
			}
		}
	}

}
