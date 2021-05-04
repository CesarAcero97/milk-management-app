package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import constants.PathConstants;
import exceptions.FieldsNullException;
import exceptions.NotSelectionRow;
import model.ProductionEntry;

public class JFMainWindowApp extends JFrame {

	private static final String TEXT_TITTLE_MAIN_WINDOW = "Gestor de producción de leche (ANALAC)";
	private static final long serialVersionUID = 1L;
	private JPMainPanelApp jpMainPanelApp;
	private JScrollPane scrollPane;
	private JDMainAddMunicipality dialogAddMunicipality;
	private JDMainEditMunicipality dialogEditMunicipality;

	public JFMainWindowApp(ActionListener actionListener) {
		intiFrame();
		initComponents(actionListener);
		addComponentsToFrame();
		this.setVisible(true);
	}

	private void intiFrame() {
		this.setTitle(TEXT_TITTLE_MAIN_WINDOW);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setIconImage(new ImageIcon(getClass().getResource(PathConstants.PATH_ICON_WINDOW_FRAME)).getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	private void initComponents(ActionListener actionListener) {
		jpMainPanelApp = new JPMainPanelApp(actionListener);
		scrollPane = new JScrollPane();
		this.dialogAddMunicipality = new JDMainAddMunicipality(actionListener, this);
		this.dialogEditMunicipality = new JDMainEditMunicipality(actionListener, this);
	}

	private void addComponentsToFrame() {
		this.add(jpMainPanelApp);
		scrollPane.setViewportView(jpMainPanelApp);
		this.getContentPane().add(scrollPane);
	}
	
	public ProductionEntry createProductionEntry() throws FieldsNullException {
		return dialogAddMunicipality.createProductionEntry();
	}
	
	public void addElementToTable(Object[] vectorElement) {
		jpMainPanelApp.addElementToTable(vectorElement);
	}
	
	public void showDialogEditUser() {
		dialogEditMunicipality.setVisible(true);
	}
	
	public Object[] editMunicipaity() {
		return dialogEditMunicipality.editMunicipality();
	}

	public void showDialogAdd() {
		 dialogAddMunicipality.setVisible(true);
	}
	public void notShowDialog() {
		dialogAddMunicipality.setVisible(false);
		dialogAddMunicipality.setDefaultFields();
	}
	
	public int getRowTable() throws NotSelectionRow {
		return jpMainPanelApp.getRowTable();
	}

	public void cleansRowTable() {
		jpMainPanelApp.cleansRowTable();
	}

	public void setIdentifiersPrincipal() {
		jpMainPanelApp.setIdentifiersPrincipal();
	}

	public void refreshTable(ArrayList<Object[]> vector) {
		jpMainPanelApp.refreshTable(vector);
	}
}
