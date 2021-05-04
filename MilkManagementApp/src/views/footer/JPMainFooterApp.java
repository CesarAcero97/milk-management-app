package views.footer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class JPMainFooterApp extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPMainContactInformation mainContactInformation;
	private JPMainSponsors mainSponsors;

	public JPMainFooterApp() {
		initPanel();
		initComponents();
		addComponentsToPanel();
		this.setVisible(true);
	}

	private void initPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private void initComponents() {
		mainContactInformation = new JPMainContactInformation();
		mainSponsors = new JPMainSponsors();
	}

	private void addComponentsToPanel() {
		this.add(mainContactInformation);
		this.add(mainSponsors);
	}
}
