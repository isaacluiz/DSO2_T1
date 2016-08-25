package t1.view;

import javax.swing.JFrame;

import t1.constants.ViewConstants;
import t1.controller.Controller;
import t1.model.Model;
import t1.view.panels.LoginPanel;

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

		this.frame.add(new LoginPanel());

		this.frame.setSize(ViewConstants.DEFAULT_WIDTH, ViewConstants.DEFAULT_HEIGHT);
	}

}
