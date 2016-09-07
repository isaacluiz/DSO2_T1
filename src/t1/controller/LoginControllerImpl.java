package t1.controller;

import java.io.IOException;

import t1.bd.CSVReader;
import t1.exceptions.UserNotFoundException;
import t1.model.LoginModelImpl;
import t1.model.MainModelImpl;
import t1.model.Model;
import t1.view.MainViewImpl;
import t1.view.View;
import t1.view.objects.DadosLogin;

public class LoginControllerImpl<MODEL extends Model, VIEW extends View> implements Controller<MODEL, VIEW> {

	private VIEW view;

	private MODEL model;

	private DadosLogin dadosLogin;

	@Override
	public void init() {
		this.view.createScreen();
	}

	@Override
	public void setView(VIEW view) {
		this.view = view;
	}

	@Override
	public void setModel(MODEL model) {
		this.model = model;
	}

	public void showMainView() {
		Model mainModel = new MainModelImpl();
		Controller mainController = new MainControllerImpl<MainModelImpl, MainViewImpl>();
		View mainView = new MainViewImpl<>(mainController);
		mainController.setModel(mainModel);
		mainController.setView(mainView);
		((MainModelImpl) mainModel).setDadosLogin(this.dadosLogin);
		mainController.init();
	}

	public boolean onLoginClicked(String login, String senha) {
		boolean senhaOk;
		try {
			this.dadosLogin = CSVReader.loadDadosLogin(login);
			senhaOk = ((LoginModelImpl) this.model).verificaLogin(senha, this.dadosLogin);
			if (!senhaOk) {
				this.view.showMessage("Senha incorreta!");
			}
			return senhaOk;
		} catch (UserNotFoundException | IOException e) {
			this.view.showMessage(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

}
