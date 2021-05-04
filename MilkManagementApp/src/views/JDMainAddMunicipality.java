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
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.text.DefaultFormatter;

import constants.Commands;
import constants.ConstantsUI;
import constants.PathConstants;
import exceptions.FieldsNullException;
import model.FarmingType;
import model.Processor;
import model.ProductionEntry;
import persistence.HandlerLanguage;
import utilities.Utilities;
import views.models.JModelComboBox;
import views.models.JButtonHeader;
import views.models.UploadResources;

public class JDMainAddMunicipality extends JDialog {

	private static final String TEXT_YEAR_STUDY = "Year_Study";
	//private static final String TEXT_YEAR = "Year_Selection ";
	private static final String TEXT_CANCEL_BUTTON = "Cancel";
	private static final String TEXT_ADD_BUTTON = "Add";
	private static final String TETX_TOTAL_LITERS = "Total_Liters";
	private static final String TEXT_NUMBER_COWS = "Number_Cows";
	private static final String TEXT_NUMBER_LITERS = "Number_Liters";
	private static final String TEXT_TYPE_EXPLOTATION = "Type_Explotation";
	private static final String TEXT_NAME_MUNICIPALITY = "Name_municipality";
	private static final String TEXT_NEW_MUNICIPALITY = "New_Municipality";
	//private static final String TEXT_ADD_MUNICIPALITY = "Add_Municipality";
	private static final long serialVersionUID = 1L;
	private UploadResources uploadResources;

	private JSpinner jspYear;
	private JPanel jpContainer;
	private JTextField jtfNameMunicipality;
	private JModelComboBox jcbTypeExplotation;
	private JSpinner jspNumberLiters;
	private JSpinner jspNumberCows;
	private JSpinner jspTotalLiters;
	private JButton bntAdd;
	private JButton bntCancel;
	private Processor processor;

	public JDMainAddMunicipality(ActionListener actionListener, JFMainWindowApp jfMainWindowApp) {
		initDialog(actionListener, jfMainWindowApp);
		initComponents();
		addComponentsToDialog(actionListener);
	}

	private void initDialog(ActionListener actionListener, JFMainWindowApp jfMainWindowApp) {
		this.setModal(true);
		this.setTitle(HandlerLanguage.languageProperties.getProperty(TEXT_NEW_MUNICIPALITY));
		this.setSize(400, 550);
		this.setLocationRelativeTo(jfMainWindowApp);
		this.setIconImage(new ImageIcon(getClass().getResource(PathConstants.PATH_ICON_ADD)).getImage());
		this.setFont();
	}

	private void initComponents() {
		jpContainer = new JPanel();
		jspYear = new JSpinner(new SpinnerNumberModel(2020, 1970, Integer.MAX_VALUE, 1));
		jtfNameMunicipality = new JTextField();
		jspNumberLiters = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		jspNumberCows = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		jspTotalLiters = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		jcbTypeExplotation = new JModelComboBox(FarmingType.values(), TEXT_TYPE_EXPLOTATION);
	}

	private void addComponentsToDialog(ActionListener actionListener) {
		createAuxPanel();
		((DefaultFormatter) ((JSpinner.NumberEditor) jspYear.getEditor()).getTextField().getFormatter())
				.setAllowsInvalid(false);
		jspYear.setBorder(
				BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(TEXT_YEAR_STUDY)));
		jpContainer.add(jspYear);

		jtfNameMunicipality.setBorder(BorderFactory
				.createTitledBorder(HandlerLanguage.languageProperties.getProperty(TEXT_NAME_MUNICIPALITY)));
		jpContainer.add(jtfNameMunicipality);

		jcbTypeExplotation = new JModelComboBox(FarmingType.values(),
				HandlerLanguage.languageProperties.getProperty((TEXT_TYPE_EXPLOTATION)));
		jpContainer.add(jcbTypeExplotation);

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

		bntAdd = new JButtonHeader(10, 10, HandlerLanguage.languageProperties.getProperty(TEXT_ADD_BUTTON),
				ConstantsUI.COLOR_DARKCYAN, Color.WHITE, ConstantsUI.FONT_UBUNTU, Commands.C_ADD.toString(),
				actionListener, ConstantsUI.COLOR_DARKCYAN);
		jpContainer.add(bntAdd);
		bntCancel = new JButtonHeader(10, 10, HandlerLanguage.languageProperties.getProperty(TEXT_CANCEL_BUTTON),
				ConstantsUI.COLOR_DARKCYAN, Color.WHITE, ConstantsUI.FONT_UBUNTU, Commands.C_CANCEL.toString(),
				actionListener, ConstantsUI.COLOR_DARKCYAN);
		jpContainer.add(bntCancel);

		this.add(jpContainer);

	}

	private JPanel createAuxPanel() {
		jpContainer.setBackground(ConstantsUI.COLOR_WHITE);
		GridLayout gridLayout = new GridLayout(9, 1);
		gridLayout.setVgap(15);
		jpContainer.setLayout(gridLayout);
		jpContainer.setBorder(ConstantsUI.BORDER_EMPTY_NEW_USER_PANEL);
		jpContainer.setVisible(true);
		return jpContainer;
	}

	private void setFont() {
		uploadResources = new UploadResources();
		UIManager.put("TextField.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 12));
		UIManager.put("TitledBorder.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 12));
		UIManager.put("Button.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 12));
		UIManager.put("ComboBox.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 12));
	}
	
	public void setDefaultFields() {
		jtfNameMunicipality.setText("");
	}

	public ProductionEntry createProductionEntry() throws FieldsNullException {
		setVisible(false);
		if ((Utilities.verifyFields(jtfNameMunicipality.getText()))) {
			throw new FieldsNullException();
		} else {
			return Processor.createProductionEntry(processor.getGenerateID(),
					Integer.parseInt((String) jspYear.getValue()), jtfNameMunicipality.getText(),
					(FarmingType) jcbTypeExplotation.getSelectedItem(),
					Integer.parseInt((String) jspNumberLiters.getValue()),
					Integer.parseInt((String) jspNumberCows.getValue()),
					Integer.parseInt((String) jspTotalLiters.getValue()));
		}
	}
}
