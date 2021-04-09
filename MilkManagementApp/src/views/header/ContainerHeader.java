package views.header;

import javax.swing.JPanel;

import presenter.PresenterApp;

public class ContainerHeader extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuBar menuBar;
	private ToolBar toolBar;

	public ContainerHeader(PresenterApp presenterApp) {
		
		initComponents(presenterApp);
	}

	private void initComponents(PresenterApp presenterApp) {
		// TODO Auto-generated method stub
		menuBar = new MenuBar(presenterApp);
		this.add(menuBar);
		
		toolBar = new ToolBar(presenterApp);
		this.add(toolBar);
	}

	public void changeLanguage() {
		menuBar.changeLanguage();
		toolBar.changeLanguage();
	}

}
