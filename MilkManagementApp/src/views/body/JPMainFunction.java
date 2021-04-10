package views.body;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JToolBar;
import constants.Commands;
import constants.ConstantsUI;
import constants.PathConstants;
import utilities.Utilities;
import views.models.RoundedJButton;

public class JPMainFunction extends JToolBar {

	private static final long serialVersionUID = 1L;
	private RoundedJButton bntAdd;
	private RoundedJButton bntEdit;
	private RoundedJButton bntDelete;
	private RoundedJButton bntRefresh;
	private static final String TEXT_REFRESH = "Refresh";
	private static final String TEXT_DELETE = "Delete";
	private static final String TEXT_EDIT = "Edit";
	private static final String TEXT_ADD = "Add";
	private int arcWidth = 30;
	private int arcHeight = 30;

	public JPMainFunction(ActionListener actionListener) {
		initToolBar();
		initComponents(actionListener);
		addComponentsToToolBar();
		this.setVisible(true);
	}

	private void initToolBar() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.WHITE);
		setBorderPainted(false);
	}

	private void initComponents(ActionListener actionListener) {
		bntAdd = new RoundedJButton(arcWidth, arcHeight, Utilities.generateProperty(TEXT_ADD), ConstantsUI.COLOR_WHITE,
				Color.BLACK, ConstantsUI.FONT_UBUNTU, Commands.C_NEW.toString(), actionListener,
				PathConstants.PATH_ICON_ADD);
		bntEdit = new RoundedJButton(arcWidth, arcHeight, Utilities.generateProperty(TEXT_EDIT),
				ConstantsUI.COLOR_WHITE, Color.BLACK, ConstantsUI.FONT_UBUNTU, Commands.C_EDIT.toString(),
				actionListener, PathConstants.PATH_ICON_EDIT);
		bntDelete = new RoundedJButton(arcWidth, arcHeight, Utilities.generateProperty(TEXT_DELETE),
				ConstantsUI.COLOR_WHITE, Color.BLACK, ConstantsUI.FONT_UBUNTU, Commands.C_DELETE.toString(),
				actionListener, PathConstants.PATH_ICON_DELETE);
		bntRefresh = new RoundedJButton(arcWidth, arcHeight, Utilities.generateProperty(TEXT_REFRESH),
				ConstantsUI.COLOR_WHITE, Color.BLACK, ConstantsUI.FONT_UBUNTU, Commands.C_REFRESH.toString(),
				actionListener, PathConstants.PATH_ICON_REFRESH);
	}

	private void addComponentsToToolBar() {
		this.add(bntAdd);
		this.add(bntEdit);
		this.add(bntDelete);
		this.add(bntRefresh);
	}
}
