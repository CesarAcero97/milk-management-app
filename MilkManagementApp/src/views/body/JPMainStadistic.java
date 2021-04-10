package views.body;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.Commands;
import constants.ConstantsUI;
import persistence.HandlerLanguage;
import views.models.JButtonHeader;

public class JPMainStadistic extends JPanel {

	private static final String TEXT_STATISTIC_DATA = "Statistic_Data";
	private static final long serialVersionUID = 1L;
	private static final String TEXT_TEN_REPORT = "Ten_Report";
	private static final String TEXT_NINE_REPORT = "Nine_Report";
	private static final String TEXT_EIGHT_REPORT = "Eight_Report";
	private static final String TEXT_SEVEN_REPORT = "Seven_Report";
	private static final String TEXT_SIX_REPORT = "Six_Report";
	private static final String TEXT_FIVE_REPORT = "Five_Report";
	private static final String TEXT_FOUR_REPORT = "Four_Report";
	private static final String TEXT_THREE_REPORT = "Three_Report";
	private static final String TEXT_SECOND_REPORT = "Second_Report";
	private static final String TEXT_FIRST_REPORT = "First_Report";
	private JButtonHeader firstReport;
	private JButtonHeader secondReport;
	private JButtonHeader threeReport;
	private JButtonHeader fourReport;
	private JButtonHeader fiveReport;
	private JButtonHeader sixReport;
	private JButtonHeader sevenReport;
	private JButtonHeader eightReport;
	private JButtonHeader nineReport;
	private JButtonHeader tenReport;
	private JLabel lblTittleStatistic;
	private int arcWidth = 20;
	private int arcHeight = 20;

	public JPMainStadistic(ActionListener actionListener) {
		initPanel();
		initComponents(actionListener);
		addComponentsToPanel();
		this.setVisible(true);
	}

	private void initPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//this.setLayout(new GridLayout(11,1));
		//this.setLayout();
		this.setBackground(ConstantsUI.COLOR_WHITE);
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
	}

	private void initComponents(ActionListener actionListener) {
		lblTittleStatistic = new JLabel("Estadistica");
		
		
	
		
		firstReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_FIRST_REPORT), Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_FIRST_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		secondReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_SECOND_REPORT),Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_SECOND_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		threeReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_THREE_REPORT), Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_THREE_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		fourReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_FOUR_REPORT), Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_FOUR_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		fiveReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_FIVE_REPORT), Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_FIVE_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		sixReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_SIX_REPORT),Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_SIX_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		sevenReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_SEVEN_REPORT), Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_SEVEN_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		eightReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_EIGHT_REPORT), Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_EIGTH_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		nineReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_NINE_REPORT), Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_NINE_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
		tenReport = new JButtonHeader(arcWidth, arcHeight,
				HandlerLanguage.languageProperties.getProperty(TEXT_TEN_REPORT), Color.white, Color.black,
				ConstantsUI.FONT_UBUNTU, Commands.C_SHOW_TEN_REPORT.toString(), actionListener,ConstantsUI.COLOR_OLIVEDRAP);
	}

	private void addComponentsToPanel() {
		
		this.add(updatePropertiesBannerTxt(lblTittleStatistic, TEXT_STATISTIC_DATA));
		this.add(firstReport);
		this.add(secondReport);
		this.add(threeReport);
		this.add(fourReport);
		this.add(fiveReport);
		this.add(sixReport);
		this.add(sevenReport);
		this.add(eightReport);
		this.add(nineReport);
		this.add(tenReport);
	}
	
	private JLabel updatePropertiesBannerTxt(JLabel lblInt, String text) {
		lblInt = new JLabel();
		lblInt.setText(text);
		lblInt.setForeground(Color.BLACK);
		lblInt.setBorder(new EmptyBorder(50, 90, 20, 90));
		lblInt.setFont(ConstantsUI.FONT_ROBOTO);
		lblInt.setAlignmentX(Component.CENTER_ALIGNMENT);
		return lblInt;
	}
}
