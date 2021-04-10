package views.models;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

import constants.PathConstants;
import constants.Commands;

public class JButtonModel extends JButton {

	private UploadResources uploadResources;
	private static final long serialVersionUID = 1L;

	public JButtonModel(String pathIcon, Commands actionCommand, ActionListener actionListener, String title) {
		uploadResources = new UploadResources();
		setText(title);
		setIcon(new ImageIcon(getClass().getResource(pathIcon)));
		setActionCommand(actionCommand.toString());
		addActionListener(actionListener);
		setToolTipText(title);
		UIManager.put("ToolTip.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 11));
		setBorder(null);
		setBorderPainted(false);
		setBackground(Color.WHITE);
	}
}
