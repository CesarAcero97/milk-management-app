package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import views.body.JPMainBodyApp;
import views.footer.JPMainFooterApp;
import views.header.JPMainHeaderApp;

public class JPMainPanelApp extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPMainHeaderApp jpMainHeaderApp;
	private JPMainBodyApp jpMainBodyApp;
	private JPMainFooterApp jpMainFooterApp;

	public JPMainPanelApp(ActionListener actionListener) {
		initPanel();
		initComponents(actionListener);
		addComponentsToPanel();
	}

	private void initPanel() {
		this.setLayout(new BorderLayout());
	}

	private void initComponents(ActionListener actionListener) {
		jpMainHeaderApp = new JPMainHeaderApp(actionListener);
		jpMainBodyApp = new JPMainBodyApp(actionListener);
		jpMainFooterApp = new JPMainFooterApp();
	}

	private void addComponentsToPanel() {
		this.add(jpMainHeaderApp, BorderLayout.NORTH);
		this.add(jpMainBodyApp, BorderLayout.CENTER);
		this.add(jpMainFooterApp, BorderLayout.SOUTH);
	}
	
	public void refreshTable(ArrayList<Object[]> vector) {
		jpMainBodyApp.refreshTable(vector);
	}

	public void cleansRowTable() {
		jpMainBodyApp.cleansRowTable();
	}

	public void setIdentifiersPrincipal() {
		jpMainBodyApp.setIdentifiersPrincipal();
	}
}
