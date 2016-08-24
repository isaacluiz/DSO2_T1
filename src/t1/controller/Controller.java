package t1.controller;

public interface Controller<MODEL, VIEW> {

	void setView(VIEW view);

	void setModel(MODEL model);

}
