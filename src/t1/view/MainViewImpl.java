package t1.view;

import t1.controller.Controller;

public class MainViewImpl<CONTROLLER extends Controller> implements View<CONTROLLER> {

	private CONTROLLER controller;

	public MainViewImpl(CONTROLLER controller) {
		this.controller = controller;
	}

}
