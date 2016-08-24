package t1.view;

import t1.controller.Controller;
import t1.model.Model;

@SuppressWarnings("rawtypes")
public class MainViewImpl<CONTROLLER extends Controller<Model, View>> implements View<CONTROLLER> {

	private CONTROLLER controller;

	public MainViewImpl(CONTROLLER controller) {
		this.controller = controller;
	}

	@Override
	public void showMessage(String string) {
		System.out.println(string);
	}

	@Override
	public void createScreen() {
		// TODO Auto-generated method stub

	}

}
