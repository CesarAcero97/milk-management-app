package views;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import constants.PathConstants;

public class JFMainWindowApp extends JFrame {

	private static final String TEXT_TITTLE_MAIN_WINDOW = "Gestor de producción de leche (ANALAC)";
	private static final long serialVersionUID = 1L;
	private JPMainPanelApp jpMainPanelApp;
	private JScrollPane scrollPane;
	private JDMainAddMunicipality dialogAddMunicipality;

	public JFMainWindowApp(ActionListener actionListener) {
		intiFrame();
		initComponents(actionListener);
		addComponentsToFrame();
		this.setVisible(true);
	}

	private void intiFrame() {
		this.setTitle(TEXT_TITTLE_MAIN_WINDOW);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setIconImage(new ImageIcon(getClass().getResource(PathConstants.PATH_ICON_WINDOW_FRAME)).getImage());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	private void initComponents(ActionListener actionListener) {
		jpMainPanelApp = new JPMainPanelApp(actionListener);
		scrollPane = new JScrollPane();
		this.dialogAddMunicipality = new JDMainAddMunicipality(actionListener, this);
	}

	private void addComponentsToFrame() {
		this.add(jpMainPanelApp);
		scrollPane.setViewportView(jpMainPanelApp);
		this.getContentPane().add(scrollPane);
	}
	
	public void showDialogAdd() {
		 dialogAddMunicipality.setVisible(true);
	}
}
