package t1.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import t1.controller.Controller;
import t1.model.Model;
import t1.view.dados.Dados;

public class PegarLivroViewImpl<CONTROLLER extends Controller<Model, View>> implements View<CONTROLLER> {

	private JFrame frame;
	private JTextField textField;

	public PegarLivroViewImpl(CONTROLLER pegarLivroController) {
		// TODO Auto-generated constructor stub
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
		this.frame = new JFrame("titulo");
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().setLayout(null);

		JLabel lblDigiteOCdigo = new JLabel("Digite o c\u00F3digo do Livro");
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDigiteOCdigo.setBounds(10, 26, 364, 59);
		this.frame.getContentPane().add(lblDigiteOCdigo);

		this.textField = new JTextField();
		this.textField.setBounds(10, 96, 250, 20);
		this.frame.getContentPane().add(this.textField);
		this.textField.setColumns(10);

		JLabel lblTtulo = new JLabel("T\u00EDtulo");
		lblTtulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTtulo.setBounds(10, 127, 123, 20);
		this.frame.getContentPane().add(lblTtulo);

		JLabel lblTitulovalue = new JLabel("");
		lblTitulovalue.setBounds(10, 158, 46, 14);
		this.frame.getContentPane().add(lblTitulovalue);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAutor.setBounds(10, 183, 123, 20);
		this.frame.getContentPane().add(lblAutor);

		JLabel labelAutorValue = new JLabel("");
		labelAutorValue.setBounds(10, 214, 46, 14);
		this.frame.getContentPane().add(labelAutorValue);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> this.frame.dispose());
		btnCancelar.setBounds(175, 273, 89, 23);
		this.frame.getContentPane().add(btnCancelar);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(43, 273, 89, 23);
		this.frame.getContentPane().add(btnOk);

		this.frame.setSize(324, 352);
		this.frame.setLocationRelativeTo(null);
	}

	@Override
	public void setDados(Dados dados) {
		// TODO Auto-generated method stub

	}
}
