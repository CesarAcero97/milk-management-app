package views.body;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import constants.ConstantsUI;
import constants.PathConstants;

public class JPMainInformation extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblFirstImage;
	private JLabel lblSecondImage;
	private JLabel lblThreeImage;

	public JPMainInformation() {
		initPanel();
		addComponentsToPanel();
		this.setVisible(true);
	}

	private void initPanel() {
		this.setLayout(new FlowLayout());
		this.setBackground(ConstantsUI.COLOR_OLIVEDRAP);
	}

	private void addComponentsToPanel() {
		this.add(updatePropertiesContactInf(lblFirstImage, 300, 200, PathConstants.PATH_FIRST_IMAGE));
		this.add(updatePropertiesContactInf(lblSecondImage, 500, 200, PathConstants.PATH_SECOND_IMAGE));
		this.add(updatePropertiesContactInf(lblThreeImage, 250, 200, PathConstants.PATH_THREE_IMAGE));
	}

	public JLabel updatePropertiesContactInf(JLabel lblInt, int width, int height, String pathIcon) {
		lblInt = new JLabel();
		Image img = new ImageIcon((pathIcon)).getImage();
		ImageIcon icon = new ImageIcon(img.getScaledInstance(width, height, Image.SCALE_SMOOTH));
		lblInt.setIcon(icon);
		lblInt.setBorder(new EmptyBorder(20, 30, 20, 30));
		return lblInt;
	}
}
