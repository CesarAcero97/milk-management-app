package views;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import presenter.PresenterApp;
import views.body.ContainerBody;
import views.header.ContainerHeader;

public class MainPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ContainerHeader containerHeader;
	private ContainerBody containerBody;
	
	public MainPanel(PresenterApp presenterApp) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents(presenterApp);
	}

	private void initComponents(PresenterApp presenterApp) {
		containerHeader = new ContainerHeader(presenterApp);
		this.add(containerHeader);
		
		containerBody = new ContainerBody(presenterApp);
		this.add(containerBody);
	}

	public void addElementToTable(Object[] object) {
		containerBody.addElementToTable(object);
	}

	public void showFullList(ArrayList<Object[]> entryList) {
		containerBody.showFullList(entryList);
	}

	public void changeLanguage() {
		containerHeader.changeLanguage();
		containerBody.changeLanguage();
	}

}
