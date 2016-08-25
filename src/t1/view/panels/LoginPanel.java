package t1.view.panels;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import t1.constants.ViewConstants;
import t1.listeners.LoginListener;

public class LoginPanel extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField loginField;

	private JPasswordField passwordField;

	private LoginListener listener;

	public LoginPanel() {
		this.setTitle("Login");
		this.getContentPane().setLayout(null);
		this.loginField = new JTextField("Login");
		this.loginField.setBounds(127, 107, 130, 20);

		this.getContentPane().add(this.loginField);
		this.passwordField = new JPasswordField("Senha");
		this.passwordField.setBounds(127, 164, 130, 20);
		this.getContentPane().add(this.passwordField);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(127, 83, 97, 14);
		this.getContentPane().add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(127, 139, 97, 14);
		this.getContentPane().add(lblPassword);

		JLabel lblFaaLoginNo = new JLabel("Fa\u00E7a Login No Sistema");
		lblFaaLoginNo.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblFaaLoginNo.setBounds(58, 24, 268, 48);
		this.getContentPane().add(lblFaaLoginNo);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(225, 210, 89, 23);
		this.getContentPane().add(btnLogin);
		btnLogin.addActionListener(event -> this.onLoginClicked(lblLogin.getText(), lblPassword.getText()));

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(68, 210, 89, 23);
		this.getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(event -> this.onCancelarClicked());

		this.setSize(new Dimension(ViewConstants.LOGIN_WIDTH, ViewConstants.LOGIN_HEIGHT));
	}

	private void onCancelarClicked() {
		System.exit(0);
	}

	private void onLoginClicked(String login, String senha) {
		if (this.listener.onLoginClicked(login, senha)) {
			this.dispose();
		}
	}

	public void setLoginListener(LoginListener listener) {
		this.listener = listener;
	}
}
