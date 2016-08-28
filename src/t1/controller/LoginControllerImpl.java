package t1.controller;

import t1.model.MainModelImpl;
import t1.model.Model;
import t1.view.MainViewImpl;
import t1.view.View;

public class LoginControllerImpl<MODEL extends Model, VIEW extends View> implements Controller<MODEL, VIEW> {

	private VIEW view;

	private MODEL model;

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
		mainController.init();
	}

}
