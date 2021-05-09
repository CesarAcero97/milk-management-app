package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.json.simple.DeserializationException;

import constants.Commands;
import exceptions.FieldsNullException;
import exceptions.IdNotFoundException;
import exceptions.NotSelectionRow;
import persistence.HandlerLanguage;
import persistence.JsonHandler;
import utilities.Utilities;
import views.JFMainWindowApp;
import model.*;

public class PresenterApp implements ActionListener {

	private JFMainWindowApp display;
	private HandlerLanguage config;
	private Processor processor;

	private static final String FILE_ENGLISH_PATH = "resources/languages/languageUS.properties";
	private static final String FILE_SPANISH_PATH = "resources/languages/languageES.properties";
	private static final String FILE_NAME_CONFIG_PATH = "resources/config/config.init";
	private static final String FILE_OUT = "resources/output/milkInfo.txt";
	public static final String JD_MESSAGE_ERROR = "Message_Error";
	public static final String MESSAGE_DELETE = "Message_Delete";
	private static final String TEXT_DELETE_USER = "Delete_User";

	public PresenterApp() {
		loadConfiguration();
		initApp();
		StartApp();
		processor.generateReportOne(2018);
		processor.generateReportTwo("SORACA");
		display.refreshTable(processor.generateFullList());
	}

	private void initApp() {
		display = new JFMainWindowApp(this);
		processor = new Processor();
	}

	private void StartApp() {

		try {
//			new JsonHandler().readFile("resources/input/data.json");
			new JsonHandler();

			ArrayList<String> listProductionEntry = JsonHandler
					.readFileFromUrl("https://www.datos.gov.co/resource/3urw-7985.json");
			manageCreateMunicipality(listProductionEntry);
			// JsonHandler.readFileFromUrl("https://www.datos.gov.co/resource/3urw-7985.json");
		} catch (IOException | DeserializationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case C_SHOW_PANEL_NEW:
			manageshowNewPanel();
			break;
		case C_ADD:
			manageAddProductionEntry();
			break;
		case C_EDIT:
			manageEditMunicipality();
			break;
		case C_EXIT:
			manageExitApp();
			break;
		case C_CANCEL:
			manageCancel();
			break;
		case C_DELETE:
			manageDelete();
			break;
		case C_SPANISH:
			manageChangeLanguageES();
			break;
		case C_ENGLISH:
			manageChangeLanguageUS();
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
	
	private void manageChangeLanguageES() {
		try {
			changeToSpanish();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(display, e.getMessage());
		}
		manageChangeLanguage();
	}
	
	private void manageChangeLanguageUS() {
		try {
			changeToEnglish();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(display, e.getMessage());
		}
		manageChangeLanguage();
	}
	
	public void loadLanguage() {
		try {
			config.loadLanguage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(display, e.getMessage());
		}
	}
	
	private void manageChangeLanguage() {
		display.changeLanguage();
	}
	
	public void changeToSpanish() {
		HandlerLanguage.language = FILE_SPANISH_PATH;
		saveConfig();
		loadLanguage();
	}
	
	public void changeToEnglish() {
		HandlerLanguage.language = FILE_ENGLISH_PATH;
		saveConfig();
		loadLanguage();
	}
	
	public void saveConfig() {
		try {
			new HandlerLanguage( FILE_NAME_CONFIG_PATH).savelanguage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(display, e.getMessage());
		}
	}

	private void manageshowNewPanel() {
		display.showDialogAdd();
		display.setIdentifiersPrincipal();
		display.cleansRowTable();
		display.refreshTable(processor.generateFullList());
	}

	private void manageAddProductionEntry() {
		display.refreshTable(processor.toMatrixVector());
		ProductionEntry entryAux;
		try {
			entryAux = display.createProductionEntry();
			processor.addEntry(entryAux);
			display.addElementToTable(entryAux.toObjectVector());
			display.notShowDialog();
		} catch (FieldsNullException e3) {

			JOptionPane.showMessageDialog(display, Utilities.generateProperty(e3.getMessage()),
					Utilities.generateProperty(JD_MESSAGE_ERROR), JOptionPane.WARNING_MESSAGE);
		}
	}

	private void manageCancel() {
		display.notShowDialog();

	}

	private void manageEditMunicipality() {
		this.display.showDialogEditUser();
		Object[] datumsUser = display.editMunicipaity();
		try {
			int datumsTable = display.getRowTable();
			ProductionEntry entryAux = processor.searchProductionEntryByID(datumsTable);
			entryAux.setDailyLitersPerCow(Integer.parseInt((String) datumsUser[0]));
			entryAux.setDailyLiters(Integer.parseInt((String) datumsUser[1]));
			entryAux.setNumberOfCows(Integer.parseInt((String) datumsUser[2]));
			display.cleansRowTable();
			display.refreshTable(processor.toMatrixVector());
		} catch (NotSelectionRow e2) {
			JOptionPane.showMessageDialog(display, Utilities.generateProperty(e2.getMessage()),
					Utilities.generateProperty(JD_MESSAGE_ERROR), JOptionPane.WARNING_MESSAGE);
		} catch (IdNotFoundException e1) {
			JOptionPane.showMessageDialog(display, e1.getMessage());
		}
	}

	private void manageDelete() {
		try {
			int datasAux = display.getRowTable();
			int option = JOptionPane.showConfirmDialog(display, Utilities.generateProperty(MESSAGE_DELETE),
					Utilities.generateProperty(TEXT_DELETE_USER), JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (option == JOptionPane.YES_OPTION) {
				processor.deleteEntry(processor.searchPositionNumber(datasAux));
				display.cleansRowTable();
				display.refreshTable(processor.toMatrixVector());
			}
		} catch (NotSelectionRow e1) {
			JOptionPane.showMessageDialog(display, Utilities.generateProperty(e1.getMessage()),
					Utilities.generateProperty(JD_MESSAGE_ERROR), JOptionPane.WARNING_MESSAGE);
		} catch (IdNotFoundException e2) {
			JOptionPane.showMessageDialog(display, e2.getMessage());
		}
	}

	private void manageExitApp() {
		display.setVisible(false);
		display.dispose();
	}

	private void manageCreateMunicipality(ArrayList<String> dataCyclistList) {
		for (String data : dataCyclistList) {
			String[] aux = Utilities.SplitLine(data);
			try {
				processor.addEntry(Processor.createProductionEntry(processor.getGenerateID(), Integer.parseInt(aux[0]),
						aux[1], Utilities.parseFarmingType(aux[2]), Integer.parseInt(aux[3]), Integer.parseInt(aux[4]),
						Integer.parseInt(aux[5])));
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}
