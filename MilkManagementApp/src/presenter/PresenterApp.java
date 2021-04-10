package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import constants.Commands;
import persistence.HandlerLanguage;
import views.JFMainWindowApp;

public class PresenterApp implements ActionListener {

	private JFMainWindowApp display;
	private HandlerLanguage config;

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

}
