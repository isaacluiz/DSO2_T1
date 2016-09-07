package t1.view;

import javax.swing.JOptionPane;

import t1.view.dados.Dados;

public interface View<CONTROLlER> {

	default void showMessage(String string) {
		JOptionPane.showMessageDialog(null, string);
	}

	void createScreen();

	void setDados(Dados dados);

	Dados getDados();

}
