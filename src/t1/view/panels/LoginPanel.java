package t1.view.panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField loginField;

	private JPasswordField passwordField;

	public LoginPanel() {
		this.setLayout(null);
		this.loginField = new JTextField("Login");
		this.loginField.setBounds(10, 36, 130, 20);

		this.add(this.loginField);
		this.passwordField = new JPasswordField("Senha");
		this.passwordField.setBounds(10, 93, 130, 20);
		this.add(this.passwordField);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 11, 97, 14);
		this.add(lblLogin);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 68, 97, 14);
		this.add(lblPassword);

	}
}
