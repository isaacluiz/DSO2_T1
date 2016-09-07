package t1.controller;

import java.io.IOException;

import t1.bd.CSVReader;
import t1.exceptions.UserNotFoundException;
import t1.model.DevolverLivroModelImpl;
import t1.model.MainModelImpl;
import t1.model.Model;
import t1.model.PegarLivroModelImpl;
import t1.view.DevolverLivroViewImpl;
import t1.view.PegarLivroViewImpl;
import t1.view.View;

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
		pegarLivroController.init();
	}

	public void showDevolverLivro() {
		Model devolverLivroModel = new DevolverLivroModelImpl();
		Controller devolverLivroController = new DevolverLivroControllerImpl<DevolverLivroModelImpl, DevolverLivroViewImpl>();
		View devolverLivroView = new DevolverLivroViewImpl(devolverLivroController);
		devolverLivroController.setModel(devolverLivroModel);
		devolverLivroController.setView(devolverLivroView);
		devolverLivroController.init();
	}

}
