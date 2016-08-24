package t1.controller;

import t1.model.Model;
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
		this.view.showMessage("HELLO WORLD!");
	}

}
