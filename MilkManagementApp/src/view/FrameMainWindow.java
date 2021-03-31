package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import model.ProductionEntry;
import persistence.LanguageHandler;
import presenter.PresenterApp;

public class FrameMainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private DialogAddEntry dialogAddEntry;
	private DialogFileChooser dialogFileChooser;
	private DialogReport dialogReport;
	
	public FrameMainWindow(PresenterApp presenterApp) {
		
		initComponents(presenterApp);
		setVisible(true);
	}

	private void initComponents(PresenterApp presenterApp) {
		mainPanel = new MainPanel(presenterApp);
		dialogAddEntry = new DialogAddEntry(presenterApp);
		dialogFileChooser = new DialogFileChooser(presenterApp);
		dialogReport = new DialogReport(presenterApp);
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		add(scrollPane);
	}
	
	public void showDialogNewEntry() {
		dialogAddEntry.setVisible(true);
	}
	
	public void showDialogFileChooser() {
		dialogFileChooser.setVisible(true);
	}
	
	public void showDialogReport(int reportNumber) {
		dialogReport.setVisible(true);
	}
	
	public ProductionEntry createEntry() {
		return dialogAddEntry.createEntry();
	}
	
	public void addElementToTable(Object[] object) {
		mainPanel.addElementToTable(object);
	}
	
	public void showFullList(ArrayList<Object[]> entryList) {
		mainPanel.showFullList(entryList);
	}
	
	public void changeLanguage() {
		this.setTitle(LanguageHandler.languageProperties.getProperty(ConstantsUI.T_MAIN_WINDOW));
		mainPanel.changeLanguage();
	}
	
	public void manageOpenFile() {
		dialogFileChooser.setVisible(true);
	}
	
	public String getPathFileOpen() throws Exception {
		return dialogFileChooser.getPathFile();
	}
	
	public void manageSaveFile() throws Exception {
		dialogFileChooser.showSaveFile();
	}

}