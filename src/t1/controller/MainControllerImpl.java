package t1.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import t1.bd.CSVReader;
import t1.bd.CSVWriter;
import t1.exceptions.UserNotFoundException;
import t1.listeners.PegarLivroListener;
import t1.model.DevolverLivroModelImpl;
import t1.model.MainModelImpl;
import t1.model.Model;
import t1.model.PegarLivroModelImpl;
import t1.view.DevolverLivroViewImpl;
import t1.view.MainViewImpl;
import t1.view.PegarLivroViewImpl;
import t1.view.View;
import t1.view.dados.ListaLivrosEmprestados;
import t1.view.objects.Livro;

public class MainControllerImpl<MODEL extends Model, VIEW extends View>
		implements Controller<MODEL, VIEW>, PegarLivroListener {

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
		this.view.setDados(((MainModelImpl) this.model).getDadosLogin());
		this.view.createScreen();
		try {
			((MainModelImpl) this.model).setLivros(
					CSVReader.loadAllLivrosByUserId(((MainModelImpl) this.model).getDadosLogin().getLogin()));
		} catch (UserNotFoundException | IOException e) {
			this.view.showMessage(e.getMessage());
			e.printStackTrace();
		}

		this.view.setDados(((MainModelImpl) this.model).getLivros());
	}

	public void showPegarLivro() {
		Model pegarLivroModel = new PegarLivroModelImpl();
		Controller pegarLivroController = new PegarLivroControllerImpl<PegarLivroModelImpl, PegarLivroViewImpl>();
		View pegarLivroView = new PegarLivroViewImpl(pegarLivroController);
		pegarLivroController.setModel(pegarLivroModel);
		pegarLivroController.setView(pegarLivroView);
		((PegarLivroControllerImpl) pegarLivroController).setPegarLivroListener(this);
		pegarLivroController.init();
	}

	public void showDevolverLivro() {
		Model devolverLivroModel = new DevolverLivroModelImpl();
		Controller devolverLivroController = new DevolverLivroControllerImpl<DevolverLivroModelImpl, DevolverLivroViewImpl>();
		View devolverLivroView = new DevolverLivroViewImpl(devolverLivroController);
		devolverLivroController.setModel(devolverLivroModel);
		devolverLivroController.setView(devolverLivroView);
		((DevolverLivroControllerImpl) devolverLivroController).setPegarLivroListener(this);
		((DevolverLivroModelImpl) devolverLivroModel).setDadosLogin(((MainModelImpl) this.model).getDadosLogin());
		((DevolverLivroModelImpl) devolverLivroModel).setLivros(((MainModelImpl) this.model).getLivros());
		devolverLivroController.init();
	}

	@Override
	public void pegarLivro(Livro livro) {
		livro.setDataRetirada(new Date());
		((MainModelImpl) this.model).getLivros().addLivros(((MainModelImpl) this.model).getDadosLogin().getLogin(),
				Arrays.asList(livro));
		try {
			CSVWriter.writeLivrosEmprestados(((MainModelImpl) this.model).getLivros());
			((MainViewImpl) this.view).setDados(((MainModelImpl) this.model).getLivros());
		} catch (IOException e) {
			this.view.showMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void devolverLivro(Livro livro) {
		ListaLivrosEmprestados livros = ((MainModelImpl) this.model).getLivros();
		for (String user : livros.getLivrosEmprestados().keySet()) {
			if (user.equals(((MainModelImpl) this.model).getDadosLogin().getLogin())) {
				for (Livro l : livros.getLivrosEmprestados().get(user)) {
					if (l.getID().equals(livro.getID()) && l.getDataRetirada().equals(livro.getDataRetirada())) {
						l.setDataDevolucao(new Date());
					}
				}
			}
		}
		((MainModelImpl) this.model).setLivros(livros);
		try {
			CSVWriter.writeLivrosEmprestados(((MainModelImpl) this.model).getLivros());
			((MainViewImpl) this.view).setDados(((MainModelImpl) this.model).getLivros());
		} catch (IOException e) {
			this.view.showMessage(e.getMessage());
			e.printStackTrace();
		}
	}
}
