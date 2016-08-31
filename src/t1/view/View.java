package t1.view;

import t1.view.dados.Dados;

public interface View<CONTROLlER> {

	void showMessage(String string);

	void createScreen();

	void setDados(Dados dados);

	Dados getDados();

}
