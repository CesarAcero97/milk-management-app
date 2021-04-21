package views.footer;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.ConstantsUI;
import constants.PathConstants;
import persistence.HandlerLanguage;

public class JPMainContactInformation extends JPanel {

	private static final String TEXT_CONTACT = "Information";

	private static final long serialVersionUID = 1L;

	private JLabel lblLogoFooter;
	private JLabel lblConactInformation;
	private JLabel lblSocialNetWork;

	public JPMainContactInformation() {
		initPanel();
		initComponents();
		addComponentsToPanel();
		this.setVisible(true);
	}

	private void initPanel() {
		this.setLayout(new FlowLayout());
		this.setBackground(ConstantsUI.COLOR_DARKS_LATE_GRAY);
	}

	private void initComponents() {
		lblLogoFooter = new JLabel();
		lblConactInformation = new JLabel();
		lblSocialNetWork = new JLabel();
	}

	private void addComponentsToPanel() {
		this.add(updatePropertiesImage(lblLogoFooter, PathConstants.PATH_LOGO_FOOTER));
		lblConactInformation.setText(HandlerLanguage.languageProperties.getProperty(TEXT_CONTACT));
		lblConactInformation.setForeground(ConstantsUI.COLOR_WHITE);
		lblConactInformation.setBorder(new EmptyBorder(10, 10, 10, 100));
		this.add(lblConactInformation);
		this.add(updatePropertiesIcon(lblSocialNetWork, PathConstants.PATH_ICON_FACEBOOK));
		this.add(updatePropertiesIcon(lblSocialNetWork, PathConstants.PATH_ICON_INSTAGRAM));
		this.add(updatePropertiesIcon(lblSocialNetWork, PathConstants.PATH_ICON_SLIDESH));
		this.add(updatePropertiesIcon(lblSocialNetWork, PathConstants.PATH_ICON_TWITTER));
		this.add(updatePropertiesIcon(lblSocialNetWork, PathConstants.PATH_ICON_YOUTUBE));
	}

	private JLabel updatePropertiesImage(JLabel lblInt, String pathIcon) {
		lblInt = new JLabel();
		Image img = new ImageIcon((pathIcon)).getImage();
		ImageIcon icon = new ImageIcon(img.getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		lblInt.setIcon(icon);
		lblInt.setBorder(new EmptyBorder(10, 10, 10, 600));
		return lblInt;
	}

	private JLabel updatePropertiesIcon(JLabel lblInt, String pathIcon) {
		lblInt = new JLabel();
		lblInt.setIcon(new ImageIcon(getClass().getResource(pathIcon)));
		lblInt.setBorder(new EmptyBorder(10, 0, 10, 0));
		return lblInt;
	}
}
