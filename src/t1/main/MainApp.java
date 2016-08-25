package t1.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import t1.controller.Controller;
import t1.controller.MainControllerImpl;
import t1.model.MainModelImpl;
import t1.model.Model;
import t1.view.MainViewImpl;
import t1.view.View;

public class MainApp {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Model mainModel = new MainModelImpl();
		Controller mainController = new MainControllerImpl<MainModelImpl, MainViewImpl>();
		View mainView = new MainViewImpl<>(mainController);
		mainController.setModel(mainModel);
		mainController.setView(mainView);
		mainController.init();
	}

}
