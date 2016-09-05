package t1.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import t1.controller.MainControllerImpl;
import t1.model.Model;
import t1.view.dados.Dados;
import t1.view.dados.ListaLivrosEmprestados;
import t1.view.objects.Livro;
import t1.view.objects.LivroTableModel;

@SuppressWarnings("rawtypes")
public class MainViewImpl<CONTROLLER extends Controller<Model, View>> implements View<CONTROLLER> {

	private static final long serialVersionUID = 1L;

	private CONTROLLER controller;

	private JFrame frame;

	private JTable table;

	private List<Livro> livros;

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
		mntmPegarLivro.addActionListener(event -> ((MainControllerImpl) this.controller).showPegarLivro());
		mnAes.add(mntmPegarLivro);

		JMenuItem mntmDevolverLivro = new JMenuItem("Devolver Livro");
		mntmDevolverLivro.addActionListener(event -> ((MainControllerImpl) this.controller).showDevolverLivro());
		mnAes.add(mntmDevolverLivro);

		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnOpes.add(mntmSobre);

		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mnOpes.add(mntmAjuda);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(event -> System.exit(0));
		mnOpes.add(mntmSair);

		JLabel lblLivrosEmprestados = new JLabel("Livros Emprestados:");
		lblLivrosEmprestados.setBounds(7, 32, 770, 39);
		lblLivrosEmprestados.setFont(new Font("Tahoma", Font.PLAIN, 27));
		this.frame.getContentPane().add(lblLivrosEmprestados);

		this.table = new JTable();
		this.table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		this.table.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(this.table);
		scrollPane.setSize(784, 481);
		scrollPane.setLocation(0, 80);
		this.frame.getContentPane().add(scrollPane);

		this.frame.setSize(ViewConstants.DEFAULT_WIDTH, ViewConstants.DEFAULT_HEIGHT);
		this.frame.setLocationRelativeTo(null);
	}

	@Override
	public void setDados(Dados dados) {
		if (dados instanceof ListaLivrosEmprestados) {
			this.livros = ((ListaLivrosEmprestados) dados).getLivrosEmprestados();
			LivroTableModel model = new LivroTableModel(this.livros);
			this.table.setModel(model);
		}
		this.teste();
	}

	private void teste() {
		Livro livro = new Livro();
		livro.setID(1L);
		livro.setTituloLivro("Programação Orientada a Objetos");
		livro.setNomeAutor("John Smith");
		livro.setDataRetirada(new Date());

		List<Livro> livrosAux = new ArrayList<>();
		livrosAux.addAll(this.livros);
		livrosAux.add(livro);

		LivroTableModel model = new LivroTableModel(livrosAux);
		this.table.setModel(model);
		this.livros = livrosAux;
		this.table.repaint();
	}

	@Override
	public Dados getDados() {
		// TODO Auto-generated method stub
		return null;
	}
}
