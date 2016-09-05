package t1.view;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import t1.controller.Controller;
import t1.model.Model;
import t1.view.dados.Dados;

public class DevolverLivroViewImpl<CONTROLLER extends Controller<Model, View>> implements View<CONTROLLER> {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField emprestimo;
	private JTextField expiracao;

	private JFrame frame;

	private CONTROLLER controller;

	public DevolverLivroViewImpl(CONTROLLER devolverLivroController) {
		this.controller = devolverLivroController;
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
		this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.frame.setContentPane(this.contentPane);
		this.contentPane.setLayout(null);

		JLabel digite_o_codigo = new JLabel("Digite o c\u00F3digo do livro");
		digite_o_codigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		digite_o_codigo.setBounds(10, 26, 247, 40);
		this.contentPane.add(digite_o_codigo);

		this.codigo = new JTextField();
		this.codigo.setBounds(10, 96, 202, 20);
		this.contentPane.add(this.codigo);
		this.codigo.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(218, 95, 79, 23);
		this.contentPane.add(btnNewButton);

		JLabel label_expiracao = new JLabel("Data de expira\u00E7\u00E3o do empr\u00EAstimo");
		label_expiracao.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_expiracao.setBounds(10, 185, 224, 14);
		this.contentPane.add(label_expiracao);

		JLabel label_data = new JLabel("Data de emprestimo");
		label_data.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_data.setBounds(10, 129, 138, 14);
		this.contentPane.add(label_data);

		this.emprestimo = new JTextField();
		this.emprestimo.setForeground(UIManager.getColor("Button.light"));
		this.emprestimo.setEditable(false);
		this.emprestimo.setEnabled(false);
		this.emprestimo.setBounds(10, 154, 287, 20);
		this.contentPane.add(this.emprestimo);
		this.emprestimo.setColumns(10);

		this.expiracao = new JTextField();
		this.expiracao.setForeground(SystemColor.controlHighlight);
		this.expiracao.setEnabled(false);
		this.expiracao.setEditable(false);
		this.expiracao.setColumns(10);
		this.expiracao.setBounds(10, 210, 287, 20);
		this.contentPane.add(this.expiracao);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(arg0 -> {
		});
		btnOk.setBounds(40, 265, 89, 23);
		this.contentPane.add(btnOk);

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(e -> {
		});
		cancelar.setBounds(180, 265, 89, 23);
		this.contentPane.add(cancelar);

		this.frame.setVisible(true);
		this.frame.setBounds(100, 100, 326, 354);
	}

	@Override
	public void setDados(Dados dados) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dados getDados() {
		// TODO Auto-generated method stub
		return null;
	}
}
