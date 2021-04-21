package views.footer;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.ConstantsUI;
import constants.PathConstants;

public class JPMainSponsors extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblIconsSponsors;

	public JPMainSponsors() {
		initPane();
		addComponentsToPanel();
		this.setVisible(true);
	}

	private void initPane() {
		this.setLayout(new FlowLayout());
		this.setBackground(ConstantsUI.COLOR_BLACK);
	}

	private void addComponentsToPanel() {
		this.add(updatePropertiesIcon(lblIconsSponsors, PathConstants.PATH_ICON_TV));
		this.add(updatePropertiesIcon(lblIconsSponsors, PathConstants.PATH_ICON_ALMAGAN));
		this.add(updatePropertiesIcon(lblIconsSponsors, PathConstants.PATH_ICON_BURSAGAN));
		this.add(updatePropertiesIcon(lblIconsSponsors, PathConstants.PATH_ICON_CART_FEDEGAN));
		this.add(updatePropertiesIcon(lblIconsSponsors, PathConstants.PATH_ICON_FRIOGAN));
		this.add(updatePropertiesIcon(lblIconsSponsors, PathConstants.PATH_ICON_GAN_CONNTEXT));
		this.add(updatePropertiesIcon(lblIconsSponsors, PathConstants.PATH_ICON_FUNDAGAN));
	}

	private JLabel updatePropertiesIcon(JLabel lblInt, String pathIcon) {
		lblInt = new JLabel();
		lblInt.setIcon(new ImageIcon(getClass().getResource(pathIcon)));
		lblInt.setBorder(new EmptyBorder(10,20,10,20));
		return lblInt;
	}
}
