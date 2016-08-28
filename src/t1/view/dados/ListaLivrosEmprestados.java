package t1.view.dados;

import java.util.List;

import t1.view.objects.Livro;

public class ListaLivrosEmprestados implements Dados {

	private List<Livro> livrosEmprestados;

	public List<Livro> getLivrosEmprestados() {
		return this.livrosEmprestados;
	}

	public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
		this.livrosEmprestados = livrosEmprestados;
	}

	public void addLivros(List<Livro> livros) {
		this.livrosEmprestados.addAll(livros);
	}

}
