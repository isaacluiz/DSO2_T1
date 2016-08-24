package t1.main;

import t1.controller.Controller;
import t1.controller.MainControllerImpl;
import t1.model.MainModelImpl;
import t1.model.Model;
import t1.view.MainViewImpl;
import t1.view.View;

public class MainApp {

	public static void main(String[] args) {
		Model mainModel = new MainModelImpl();
		Controller mainController = new MainControllerImpl<MainModelImpl, MainViewImpl>();
		View mainView = new MainViewImpl<>(mainController);
		mainController.setModel(mainModel);
		mainController.setView(mainView);
		mainController.init();
	}

}
