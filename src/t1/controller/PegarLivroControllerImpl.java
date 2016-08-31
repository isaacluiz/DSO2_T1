package t1.controller;

import t1.model.Model;
import t1.view.View;
import t1.view.objects.Livro;

public class PegarLivroControllerImpl<MODEL extends Model, VIEW extends View> implements Controller<MODEL, VIEW> {

	private VIEW view;

	private MODEL model;

	@Override
	public void setView(VIEW view) {
		this.view = view;
	}

	@Override
	public void setModel(MODEL model) {
		this.model = model;
	}

	@Override
	public void init() {
		this.view.createScreen();
	}

	public void buscarLivroPorId(String text) {
		Livro livro = new Livro();
		livro.setID(1L);
		livro.setTituloLivro("Programação Orientada a Objetos");
		livro.setNomeAutor("John Smith");

		this.view.setDados(livro);
	}

	public void pegarLivro(Livro livro) {

	}

}
