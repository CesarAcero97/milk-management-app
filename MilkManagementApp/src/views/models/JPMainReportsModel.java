package views.models;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.ConstantsUI;
import persistence.HandlerLanguage;
import views.models.JBModelRoundedButton;

public class JPMainReportsModel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String TEXT_BUTTON_SHOW_MORE = "Show_More";
	private JLabel lblTittle;
	private JLabel lblParagraph;
	private JPanel panelInt;
	private GridBagConstraints gbc;

	public JPMainReportsModel(String pathImage, String tittle, String paragraph, int widthImage, int heigthImage) {
		initPanel();
		initComponents();
		addComponentsToPanel(pathImage, tittle, paragraph, widthImage, heigthImage);
	}

	private void addComponentsToPanel(String pathImage, String tittle, String paragraph, int widthImage,
			int heigthImage) {
		gbc.gridx = 0;
		gbc.gridy = 0;
		lblTittle.setText(tittle);
		this.add(getTitlePanel(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(updatePropertiesPostImage(pathImage, widthImage, heigthImage), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		lblParagraph.setText(paragraph);
		this.add(lblParagraph, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(new JBModelRoundedButton(10, 10, HandlerLanguage.languageProperties.getProperty(TEXT_BUTTON_SHOW_MORE),
				ConstantsUI.COLOR_OLIVEDRAP, Color.WHITE, ConstantsUI.FONT_UBUNTU), gbc);
	}

	private void initPanel() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.CYAN);
		this.setBorder(new EmptyBorder(10, 0, 10, 0));
	}

	private void initComponents() {
		lblTittle = new JLabel();
		lblParagraph = new JLabel();
		gbc = new GridBagConstraints();
	}

	private JLabel updatePropertiesPostImage(String pathImage, int widthImage, int heigthImage) {
		JLabel lblInt = new JLabel();
		lblInt.setBorder(new EmptyBorder(10, 20, 10, 20));
		Image img = new ImageIcon(pathImage).getImage();
		ImageIcon icon = new ImageIcon(img.getScaledInstance(widthImage, heigthImage, Image.SCALE_SMOOTH));
		lblInt.setIcon(icon);
		return lblInt;
	}
	
	public JPanel getTitlePanel() {
		panelInt = new JPanel();
		panelInt.setBackground(new Color(114, 179, 36));
		JLabel lbl = new JLabel("Encuesta");
		lbl.setFont(new Font("Helvetic", Font.BOLD, 14));
		lbl.setForeground(Color.WHITE);
		lbl.setBorder(new EmptyBorder(1, 55, 1, 55));
		panelInt.add(lbl);
		return panelInt;
	}
}