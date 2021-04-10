package views.header;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import constants.Commands;
import constants.ConstantsUI;
import constants.PathConstants;
import persistence.HandlerLanguage;
import utilities.Utilities;
import views.models.JButtonHeader;
import views.models.UploadResources;

public class JMBMainMenu extends JMenuBar {

	private static final String TEXT_HOME = "Home";
	private static final String TEXT_ENGLISH_LANGUAGE = "English_Language";
	private static final String TEXT_SPANISH_LANGUAGE = "Spanish_Language";
	private static final String TEXT_EXIT_APP = "Exit_App";
	private static final String TEXT_EDIT_MUNICIPALITY = "Edit_Municipality";
	private static final String TEXT_NEW_MUNICIPALITY = "New_Municipality";
	private static final String TEXT_LANGUAGE_APP = "Language_App";
	private static final String TEXT_STATISTICS_APP = "Statistics_App";
	private static final String TEXT_FILE_APP = "File_App";

	private static final long serialVersionUID = 1L;
	private UploadResources uploadResources;
	private JMenu jmenuFile;
	private JMenu jmenuStatistics;
	private JMenu jmenuLanguage;
	private JMenuItem jmiNew;
	private JMenuItem jmiEdit;
	private JMenuItem jmiExit;
	private JMenuItem jmiSpanish;
	private JMenuItem jmiEnglish;
	private JLabel lblLogoApp;
	private JButton bntHome;

	public JMBMainMenu(ActionListener actionLister) {
		initMenuBar();
		initComponents();
		addComponentsToMenuBar(actionLister);
		this.setVisible(true);
	}

	private void initMenuBar() {
		UIManager.put("Menu.font", setManager());
		UIManager.put("Menu.foreground", ConstantsUI.COLOR_WHITE);
		UIManager.put("MenuItem.font", setManager());
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(ConstantsUI.COLOR_OLIVEDRAP);
	}

	private Font setManager() {
		uploadResources = new UploadResources();
		return uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 15);
	}

	private void initComponents() {
		jmenuFile = new JMenu(HandlerLanguage.languageProperties.getProperty(TEXT_FILE_APP));
		jmenuStatistics = new JMenu(HandlerLanguage.languageProperties.getProperty(TEXT_STATISTICS_APP));
		jmenuLanguage = new JMenu(Utilities.generateProperty(TEXT_LANGUAGE_APP));
		jmiNew = new JMenuItem(HandlerLanguage.languageProperties.getProperty(TEXT_NEW_MUNICIPALITY));
		jmiEdit = new JMenuItem(HandlerLanguage.languageProperties.getProperty(TEXT_EDIT_MUNICIPALITY));
		jmiExit = new JMenuItem(HandlerLanguage.languageProperties.getProperty(TEXT_EXIT_APP));
		jmiSpanish = new JMenuItem(Utilities.generateProperty(TEXT_SPANISH_LANGUAGE));
		jmiEnglish = new JMenuItem(Utilities.generateProperty(TEXT_ENGLISH_LANGUAGE));
	}

	private void addComponentsToMenuBar(ActionListener actionListener) {
		jmiNew.setActionCommand(Commands.C_NEW.toString());
		jmiNew.addActionListener(actionListener);
		jmenuFile.add(jmiNew);
		jmiEdit.setActionCommand(Commands.C_EDIT.toString());
		jmiEdit.addActionListener(actionListener);
		jmenuFile.add(jmiEdit);
		jmiExit.setActionCommand(Commands.C_EXIT.toString());
		jmiExit.addActionListener(actionListener);
		jmenuFile.add(jmiExit);
		jmiSpanish.setActionCommand(Commands.C_SPANISH.toString());
		jmiSpanish.addActionListener(actionListener);
		jmenuLanguage.add(jmiSpanish);
		jmiEnglish.setActionCommand(Commands.C_ENGLISH.toString());
		jmiEnglish.addActionListener(actionListener);
		jmenuLanguage.add(jmiEnglish);
		bntHome = new JButtonHeader(10, 10, HandlerLanguage.languageProperties.getProperty(TEXT_HOME),
				ConstantsUI.COLOR_OLIVEDRAP, Color.WHITE, setManager(), Commands.C_HOME.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		this.add(updatePropertiesImage(lblLogoApp, "", PathConstants.PATH_LOGO_APP));
		this.add(bntHome);
		this.add(jmenuFile);
		this.add(jmenuStatistics);
		this.add(jmenuLanguage);
	}

	public JLabel updatePropertiesImage(JLabel lblInt, String text, String pathIcon) {
		lblInt = new JLabel();
		Image img = new ImageIcon((pathIcon)).getImage();
		ImageIcon icon = new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		lblInt.setIcon(icon);
		lblInt.setBorder(new EmptyBorder(5, 10, 5, 900));
		return lblInt;
	}

	public void changeLanguageMenuBar() {
		jmenuFile.setText(HandlerLanguage.languageProperties.getProperty(TEXT_FILE_APP));
		jmenuStatistics.setText(HandlerLanguage.languageProperties.getProperty(TEXT_STATISTICS_APP));
		jmenuLanguage.setText(Utilities.generateProperty(TEXT_LANGUAGE_APP));
		jmiNew.setText(HandlerLanguage.languageProperties.getProperty(TEXT_NEW_MUNICIPALITY));
		jmiEdit.setText(HandlerLanguage.languageProperties.getProperty(TEXT_EDIT_MUNICIPALITY));
		jmiExit.setText(HandlerLanguage.languageProperties.getProperty(TEXT_EXIT_APP));
		jmiSpanish.setText(Utilities.generateProperty(TEXT_SPANISH_LANGUAGE));
		jmiEnglish.setText(Utilities.generateProperty(TEXT_ENGLISH_LANGUAGE));
	}
}
