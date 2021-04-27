package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import constants.Commands;
import model.Processor;
import persistence.HandlerLanguage;
import utilities.Utilities;
import views.JFMainWindowApp;

public class PresenterApp implements ActionListener {

	private JFMainWindowApp display;
	private HandlerLanguage config;
	private Processor processor;

	private static final String FILE_ENGLISH_PATH = "resources/languages/languageUS.properties";
	private static final String FILE_SPANISH_PATH = "resources/languages/languageES.properties";
	private static final String FILE_NAME_CONFIG_PATH = "resources/config/config.init";

	public PresenterApp() {
		loadConfiguration();
		initApp();
		 display.showDialogAdd();
	}

	private void initApp() {
		display = new JFMainWindowApp(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case C_NEW:
			break;
		case C_EDIT:
			break;
		case C_EXIT:
			break;
		case C_SPANISH:
			break;

		case C_ENGLISH:
			break;
		default:
			break;
		}
	}

	public void loadConfiguration() {
		if (config == null) {
			config = new HandlerLanguage(FILE_NAME_CONFIG_PATH);
		}
		try {
			config.loadLanguage();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(display, e.getMessage());
		}
	}

	private void manageshowNewPanel() {
		display.showDialogAdd();
		display.setIdentifiersPrincipal();
		display.cleansRowTable();
		display.refreshTable(processor.generateFullList());
	}

	private void manageCreateMunicipality(ArrayList<String> dataCyclistList) {
		for (String data : dataCyclistList) {
			String[] aux = Utilities.SplitLine(data);
			
			 try {
				 processor.addEntry(Processor.createProductionEntry(Integer.parseInt(aux[1]), aux[2], Utilities.parseFarmingType(aux[3]),
							Integer.parseInt(aux[4]), Integer.parseInt(aux[5]), Integer.parseInt(aux[6])));
				
			} catch (Exception e) {
			e.getMessage();
			}
			 
		
//
//			productionEntry = new ProductionEntry(Integer.parseInt(aux[1]), aux[2], Utilities.parseFarmingType(aux[3]),
//					Integer.parseInt(aux[4]), Integer.parseInt(aux[5]), Integer.parseInt(aux[6]));
//			 processor.addEntry(productionEntry);
			 
			 
			 
//				managerCyclingRace.addCyclist(ManagerCyclingRace.createCyclist((short) Utilities.parseShortToString(aux[0]), aux[1], aux[2],aux[3],
//						Utilities.validateAddCyclingAge(aux[4]), Utilities.getGender(aux[5]),
//						Utilities.getTeam(aux[6]), Utilities.getTime(aux[7])));
		}
	}

}
