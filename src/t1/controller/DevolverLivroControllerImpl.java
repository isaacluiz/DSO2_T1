package t1.controller;

import java.io.IOException;

import t1.bd.CSVReader;
import t1.exceptions.BookNotFoundException;
import t1.exceptions.UserNotHaveBookException;
import t1.listeners.PegarLivroListener;
import t1.model.DevolverLivroModelImpl;
import t1.model.Model;
import t1.view.View;
import t1.view.objects.Livro;

public class DevolverLivroControllerImpl<MODEL extends Model, VIEW extends View> implements Controller<MODEL, VIEW> {

	private VIEW view;

	private MODEL model;

	private PegarLivroListener pegarLivroListener;

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
		try {
			Livro livro = CSVReader.loadDadosLivrosById(text);
			((DevolverLivroModelImpl) this.model).verificaUsuarioPossuiLivro(livro);
			this.view.setDados(livro);
		} catch (IOException | BookNotFoundException | UserNotHaveBookException e) {
			this.view.showMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	public void devolverLivro() {
		this.pegarLivroListener.devolverLivro((Livro) this.view.getDados());

	}

	public void setPegarLivroListener(PegarLivroListener pegarLivroListener) {
		this.pegarLivroListener = pegarLivroListener;
	}
}
