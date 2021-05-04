package views.body;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.ConstantsUI;

public class JPMainBriefcast extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel lblTittleBriefCase;

	public JPMainBriefcast() {
		initPanel();
		initComponents();
		addComponents();
		this.setVisible(true);
	}

	private void initPanel() {
		this.setLayout(new GridBagLayout());
		this.setBackground(ConstantsUI.COLOR_WHITE);
	}

	private void initComponents() {
		gbc = new GridBagConstraints();
		lblTittleBriefCase = new JLabel();
	}

	private void addComponents() {
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(30, 30, 30, 30);
	}

}
