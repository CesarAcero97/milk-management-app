package views.body;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.ConstantsUI;
import constants.PathConstants;
import views.models.JPMainPaintImageBackground;

public class JPMainBanner extends JPanel {

	private static final String TEXT_SLOGAN = "<html><body>Asociación nacional <br> de productores de leche</body></html>";
	private static final long serialVersionUID = 1L;
	private JLabel lblTextBanner;
	private JPMainPaintImageBackground imageBackground;

	public JPMainBanner() {
		initPanel();
		initComponents();
		addComponents();
		this.setVisible(true);
	}

	private void initPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(ConstantsUI.COLOR_WHITE);
	}

	private void initComponents() {
		lblTextBanner = new JLabel();
	}

	private void addComponents() {
		imageBackground = new JPMainPaintImageBackground(PathConstants.PATH_BANNER_);
		imageBackground
				.add(updatePropertiesBannerTxt(lblTextBanner, TEXT_SLOGAN));
		this.add(imageBackground);
	}

	private JLabel updatePropertiesBannerTxt(JLabel lblInt, String text) {
		lblInt = new JLabel();
		lblInt.setText(text);
		lblInt.setForeground(Color.BLACK);
		lblInt.setBorder(new EmptyBorder(150, 90, 200, 900));
		lblInt.setFont(ConstantsUI.FONT_ROBOTO);
		lblInt.setAlignmentX(Component.CENTER_ALIGNMENT);
		return lblInt;
	}
}
