package t1.view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import t1.constants.ViewConstants;
import t1.controller.Controller;
import t1.controller.MainControllerImpl;
import t1.model.MainModelImpl;
import t1.model.Model;

public class LoginViewImpl<CONTROLLER extends Controller<Model, View>> implements View<CONTROLLER> {

	private CONTROLLER controller;

	private JFrame frame;

	private JTextField loginField;

	private JPasswordField passwordField;

	public LoginViewImpl(CONTROLLER loginController) {
		this.controller = loginController;
	}

	@Override
	public void showMessage(String string) {
		// TODO Auto-generated method stub

	}

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createScreen() {
		this.frame = new JFrame();
		this.frame.setTitle("Login");
		this.frame.getContentPane().setLayout(null);
		this.loginField = new JTextField("Login");
		this.loginField.setBounds(127, 107, 130, 20);

		this.frame.getContentPane().add(this.loginField);
		this.passwordField = new JPasswordField("Senha");
		this.passwordField.setBounds(127, 164, 130, 20);
		this.frame.getContentPane().add(this.passwordField);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(127, 83, 97, 14);
		this.frame.getContentPane().add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(127, 139, 97, 14);
		this.frame.getContentPane().add(lblPassword);

		JLabel lblFaaLoginNo = new JLabel("Fa\u00E7a Login No Sistema");
		lblFaaLoginNo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblFaaLoginNo.setBounds(58, 24, 268, 48);
		this.frame.getContentPane().add(lblFaaLoginNo);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(225, 210, 89, 23);
		this.frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(event -> this.onLoginClicked(lblLogin.getText(), lblPassword.getText()));

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(68, 210, 89, 23);
		this.frame.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(event -> this.onCancelarClicked());

		this.frame.setVisible(true);
		this.frame.setSize(new Dimension(ViewConstants.LOGIN_WIDTH, ViewConstants.LOGIN_HEIGHT));
	}

	private void onCancelarClicked() {
		System.exit(0);
	}

	private void onLoginClicked(String login, String senha) {
		this.frame.dispose();
		Model mainModel = new MainModelImpl();
		Controller mainController = new MainControllerImpl<MainModelImpl, MainViewImpl>();
		View mainView = new MainViewImpl<>(mainController);
		mainController.setModel(mainModel);
		mainController.setView(mainView);
		mainController.init();
	}

}