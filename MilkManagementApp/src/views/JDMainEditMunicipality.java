package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatter;

import constants.Commands;
import constants.ConstantsUI;
import constants.PathConstants;
import persistence.HandlerLanguage;
import views.models.JButtonHeader;
import views.models.UploadResources;

public class JDMainEditMunicipality extends JDialog {

	private static final String TEXT_EDIT_MUNICIPALITY = "Edit_Municipality";

	private static final long serialVersionUID = 1L;

	private JSpinner jspNumberLiters;
	private JSpinner jspNumberCows;
	private JSpinner jspTotalLiters;
	private JPanel jpContainer;
	private JButton bntEdit;
	private JButton bntCancel;
	private UploadResources uploadResources;
	private static final String TEXT_EDIT_BUTTON = "Edit";
	private static final String TEXT_CANCEL_BUTTON = "Cancel";
	private static final String TETX_TOTAL_LITERS = "Total_Liters";
	private static final String TEXT_NUMBER_COWS = "Number_Cows";
	private static final String TEXT_NUMBER_LITERS = "Number_Liters";

	public JDMainEditMunicipality(ActionListener actionListener, JFMainWindowApp jfMainWindowApp) {
		initDialog(jfMainWindowApp);
		initComponets();
		addComponentsToDialog(actionListener);

	}

	private void setFont() {
		uploadResources = new UploadResources();
		UIManager.put("TextField.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 12));
		UIManager.put("TitledBorder.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 12));
		UIManager.put("Button.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 12));
	}

	private void initDialog(JFMainWindowApp jfMainWindowApp) {
		this.setModal(true);
		this.setTitle(HandlerLanguage.languageProperties.getProperty(TEXT_EDIT_MUNICIPALITY));
		this.setSize(300, 400);
		this.setLocationRelativeTo(jfMainWindowApp);
		this.setIconImage(new ImageIcon(getClass().getResource(PathConstants.PATH_ICON_EDIT)).getImage());
		this.setFont();
	}

	private void initComponets() {
		jspNumberLiters = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		jspNumberCows = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		jspTotalLiters = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
	}

	private void addComponentsToDialog(ActionListener actionListener) {
		createPanelAux();
		((DefaultFormatter) ((JSpinner.NumberEditor) jspNumberLiters.getEditor()).getTextField().getFormatter())
				.setAllowsInvalid(false);
		jspNumberLiters.setBorder(
				BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(TEXT_NUMBER_LITERS)));
		jpContainer.add(jspNumberLiters);

		((DefaultFormatter) ((JSpinner.NumberEditor) jspNumberCows.getEditor()).getTextField().getFormatter())
				.setAllowsInvalid(false);
		jspNumberCows.setBorder(
				BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(TEXT_NUMBER_COWS)));
		jpContainer.add(jspNumberCows);

		((DefaultFormatter) ((JSpinner.NumberEditor) jspTotalLiters.getEditor()).getTextField().getFormatter())
				.setAllowsInvalid(false);
		jspTotalLiters.setBorder(
				BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(TETX_TOTAL_LITERS)));
		jpContainer.add(jspTotalLiters);

		bntEdit = new JButtonHeader(10, 10, HandlerLanguage.languageProperties.getProperty(TEXT_EDIT_BUTTON),
				ConstantsUI.COLOR_DARKCYAN, Color.WHITE, ConstantsUI.FONT_UBUNTU, Commands.C_EDIT.toString(),
				actionListener, ConstantsUI.COLOR_DARKCYAN);
		jpContainer.add(bntEdit);

		bntCancel = new JButtonHeader(10, 10, HandlerLanguage.languageProperties.getProperty(TEXT_CANCEL_BUTTON),
				ConstantsUI.COLOR_DARKCYAN, Color.WHITE, ConstantsUI.FONT_UBUNTU, Commands.C_CANCEL.toString(),
				actionListener, ConstantsUI.COLOR_DARKCYAN);
		jpContainer.add(bntCancel);
		this.add(jpContainer);
	}

	private JPanel createPanelAux() {
		jpContainer = new JPanel();
		jpContainer.setBackground(ConstantsUI.COLOR_WHITE);
		GridLayout gridLayout = new GridLayout(5, 1);
		gridLayout.setVgap(15);
		jpContainer.setLayout(gridLayout);
		jpContainer.setBorder(ConstantsUI.BORDER_EMPTY_NEW_USER_PANEL);
		jpContainer.setVisible(true);
		return jpContainer;
	}

	public Object[] editMunicipality() {
		setVisible(false);
		return new Object[] { jspNumberLiters.getValue(), jspNumberCows.getValue(), jspTotalLiters.getValue() };
	}

	public void changeLanguage() {
		jspNumberLiters.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(TEXT_NUMBER_LITERS)));
		jspNumberCows.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(TEXT_NUMBER_COWS)));
		jspTotalLiters.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(TETX_TOTAL_LITERS)));
		bntEdit.setText(HandlerLanguage.languageProperties.getProperty(TEXT_EDIT_BUTTON));
		bntCancel.setText(HandlerLanguage.languageProperties.getProperty(TEXT_CANCEL_BUTTON));
	}
}
