package t1.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import t1.controller.Controller;
import t1.controller.LoginControllerImpl;
import t1.model.LoginModelImpl;
import t1.model.Model;
import t1.view.LoginViewImpl;
import t1.view.View;

public class MainApp {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		Model loginModel = new LoginModelImpl();
		Controller loginController = new LoginControllerImpl<LoginModelImpl, LoginViewImpl>();
		View loginView = new LoginViewImpl(loginController);
		loginController.setModel(loginModel);
		loginController.setView(loginView);
		loginController.init();

	}

}
