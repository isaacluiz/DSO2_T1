package t1.controller;

import java.util.Arrays;
import java.util.Date;

import t1.model.Model;
import t1.model.PegarLivroModelImpl;
import t1.view.PegarLivroViewImpl;
import t1.view.View;
import t1.view.dados.ListaLivrosEmprestados;
import t1.view.objects.Livro;

public class MainControllerImpl<MODEL extends Model, VIEW extends View> implements Controller<MODEL, VIEW> {

	private MODEL model;

	private VIEW view;

	public MainControllerImpl() {

	}

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
		ListaLivrosEmprestados livros = new ListaLivrosEmprestados();

		Livro livro = new Livro();
		livro.setID(1L);
		livro.setTituloLivro("Programação Orientada a Objetos");
		livro.setNomeAutor("John Smith");
		livro.setDataRetirada(new Date());

		livros.setLivrosEmprestados(Arrays.asList(livro, livro, livro));

		this.view.setDados(livros);
	}

	public void showPegarLivro() {
		Model pegarLivroModel = new PegarLivroModelImpl();
		Controller pegarLivroController = new PegarLivroControllerImpl<PegarLivroModelImpl, PegarLivroViewImpl>();
		View pegarLivroView = new PegarLivroViewImpl(pegarLivroController);
		pegarLivroController.setModel(pegarLivroModel);
		pegarLivroController.setView(pegarLivroView);
		pegarLivroController.init();
	}

}
