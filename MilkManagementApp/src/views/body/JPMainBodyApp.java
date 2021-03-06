package views.body;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import exceptions.NotSelectionRow;

public class JPMainBodyApp extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPMainBanner bannerFirstPanel;
	private JPMainTable tableInformation;
	private JPMainFunction mainFunction;
	private JPMainInformation mainInformation;
	private JPMainStadistic mainStadistic;

	public JPMainBodyApp(ActionListener actionListener) {
		initPanel();
		initComponents(actionListener);
		addComponentsToPanel();
	}

	private void initPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private void initComponents(ActionListener actionListener) {
		bannerFirstPanel = new JPMainBanner();
		tableInformation = new JPMainTable();
		mainFunction = new JPMainFunction(actionListener);
		mainInformation = new JPMainInformation();
		mainStadistic = new JPMainStadistic(actionListener);
	}

	private void addComponentsToPanel() {
		this.add(bannerFirstPanel);
		this.add(tableInformation);
		this.add(mainFunction);
		this.add(mainInformation);
		this.add(mainStadistic);
	}
	
	public void refreshTable(ArrayList<Object[]> vector) {
		tableInformation.refresh(vector);
	}
	
	public void addElementToTable(Object[] vectorElement) {
		tableInformation.addElementToTable(vectorElement);
	}

	public void cleansRowTable() {
		tableInformation.cleanRowsTable();
	}

	
	public int getRowTable() throws NotSelectionRow {
		return tableInformation.getRowSelect();
	}
	public void setIdentifiersPrincipal() {
		tableInformation.setIdetifiersPrincipal();
	}
	
	public void changeLanguage() {
		bannerFirstPanel.changeLenguage();
		tableInformation.changeLanguage();
		mainFunction.changeLanguage();
	}
}
