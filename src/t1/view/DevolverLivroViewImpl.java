package t1.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DevolverLivroViewImpl extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField emprestimo;
	private JTextField expiracao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DevolverLivroViewImpl frame = new DevolverLivroViewImpl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DevolverLivroViewImpl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel digite_o_codigo = new JLabel("Digite o c\u00F3digo do livro");
		digite_o_codigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		digite_o_codigo.setBounds(10, 26, 247, 40);
		contentPane.add(digite_o_codigo);
		
		codigo = new JTextField();
		codigo.setBounds(10, 96, 202, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(218, 95, 79, 23);
		contentPane.add(btnNewButton);
		
		JLabel label_expiracao = new JLabel("Data de expira\u00E7\u00E3o do empr\u00EAstimo");
		label_expiracao.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_expiracao.setBounds(10, 185, 224, 14);
		contentPane.add(label_expiracao);
		
		JLabel label_data = new JLabel("Data de emprestimo");
		label_data.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_data.setBounds(10, 129, 138, 14);
		contentPane.add(label_data);
		
		emprestimo = new JTextField();
		emprestimo.setForeground(UIManager.getColor("Button.light"));
		emprestimo.setEditable(false);
		emprestimo.setEnabled(false);
		emprestimo.setBounds(10, 154, 287, 20);
		contentPane.add(emprestimo);
		emprestimo.setColumns(10);
		
		expiracao = new JTextField();
		expiracao.setForeground(SystemColor.controlHighlight);
		expiracao.setEnabled(false);
		expiracao.setEditable(false);
		expiracao.setColumns(10);
		expiracao.setBounds(10, 210, 287, 20);
		contentPane.add(expiracao);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.setBounds(40, 265, 89, 23);
		contentPane.add(btnOk);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelar.setBounds(180, 265, 89, 23);
		contentPane.add(cancelar);
	}
}
