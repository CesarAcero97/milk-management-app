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
import constants.PathConstants;
import persistence.HandlerLanguage;
import views.models.JButtonHeader;
import views.models.JPMainReportsModel;

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
	}

	private void initComponents(ActionListener actionListener) {
		lblTittleStatistic = new JLabel("Estadistica");
	}

	private void addComponentsToPanel() {
		this.add(new JPMainReportsModel(PathConstants.PATH_SECOND_IMAGE, "Primer reporte", "Descripción", 10, 10));
	}
}
