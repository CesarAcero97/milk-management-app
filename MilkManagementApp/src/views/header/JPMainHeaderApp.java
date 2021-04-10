package views.header;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class JPMainHeaderApp extends JPanel {

	private static final long serialVersionUID = 1L;

	private JMBMainMenu jmbMainMenu;

	public JPMainHeaderApp(ActionListener actionListener) {
		initPanel();
		initComponents(actionListener);
		addComponentsToPanel();
		this.setVisible(true);
	}

	private void initPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.white);
	}

	private void initComponents(ActionListener actionListener) {
		jmbMainMenu = new JMBMainMenu(actionListener);
	}

	private void addComponentsToPanel() {
		this.add(jmbMainMenu);
	}

	public void changeLanguage() {
		// jmbMainMenu.changeLanguage();
	}
}
