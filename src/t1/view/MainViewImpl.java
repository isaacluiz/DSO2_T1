package t1.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import t1.constants.ViewConstants;
import t1.controller.Controller;
import t1.model.Model;

@SuppressWarnings("rawtypes")
public class MainViewImpl<CONTROLLER extends Controller<Model, View>> implements View<CONTROLLER> {

	private static final long serialVersionUID = 1L;

	private CONTROLLER controller;

	private JFrame frame;

	public MainViewImpl(CONTROLLER controller) {
		this.controller = controller;
	}

	@Override
	public void showMessage(String string) {
		System.out.println(string);
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

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 21);
		this.frame.getContentPane().add(menuBar);

		JMenu mnAes = new JMenu("A\u00E7\u00F5es");
		menuBar.add(mnAes);

		JMenuItem mntmPegarLivro = new JMenuItem("Pegar Livro");
		mnAes.add(mntmPegarLivro);

		JMenuItem mntmDevolverLivro = new JMenuItem("Devolver Livro");
		mnAes.add(mntmDevolverLivro);

		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnOpes.add(mntmSobre);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnOpes.add(mntmAjuda);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mnOpes.add(mntmSair);

		JLabel lblLivrosEmprestados = new JLabel("Livros Emprestados:");
		lblLivrosEmprestados.setBounds(7, 32, 770, 39);
		lblLivrosEmprestados.setFont(new Font("Tahoma", Font.PLAIN, 27));
		this.frame.getContentPane().add(lblLivrosEmprestados);

		// LoginPanel login = new LoginPanel();
		// login.setLocationRelativeTo(null);
		// login.setVisible(true);
		// login.setLoginListener(this);

		String[] columnNames = { "Título", "Autor", "Data Retirada", "Data Devolução", "Vencido" };

		Object[][] data = {
				{ "Programação Orientada a Objetos", "John Smith", new Date(), new Date(), new Boolean(false) },
				{ "Programação Orientada a Objetos", "John Smith", new Date(), new Date(), new Boolean(false) } };

		JTable table = new JTable(data, columnNames);

		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(784, 481);
		scrollPane.setLocation(0, 80);
		this.frame.getContentPane().add(scrollPane);

		this.frame.setSize(ViewConstants.DEFAULT_WIDTH, ViewConstants.DEFAULT_HEIGHT);
		this.frame.setLocationRelativeTo(null);
	}

}
