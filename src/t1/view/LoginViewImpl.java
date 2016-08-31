package t1.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import t1.constants.ViewConstants;
import t1.controller.Controller;
import t1.controller.LoginControllerImpl;
import t1.model.Model;
import t1.view.dados.Dados;
import t1.view.objects.DadosLogin;

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
		this.frame.setSize(ViewConstants.LOGIN_WIDTH, ViewConstants.LOGIN_HEIGHT);
		this.frame.setLocationRelativeTo(null);
	}

	private void onCancelarClicked() {
		System.exit(0);
	}

	private void onLoginClicked(String login, String senha) {
		this.frame.dispose();
		((LoginControllerImpl) this.controller).showMainView();
	}

	@Override
	public void setDados(Dados dados) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dados getDados() {
		DadosLogin dados = new DadosLogin();
		dados.setLogin(this.loginField.getText());
		dados.setSenha(this.passwordField.getSelectedText());
		return dados;
	}

}
