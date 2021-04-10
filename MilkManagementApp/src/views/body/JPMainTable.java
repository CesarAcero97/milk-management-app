package views.body;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import constants.ConstantsUI;
import constants.PathConstants;
import utilities.Utilities;
import views.models.UploadResources;

public class JPMainTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private JTable jtElements;
	private JScrollPane jspTable;
	private UploadResources uploadResources;

	public JPMainTable() {
		setFontManager();
		initPanel();
		initComponents();
		addComponentsToPanel();
	}

	private void initPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void initComponents() {
		dtmElements = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		dtmElements.setColumnIdentifiers(Utilities.changeLanguageHeaders());
		jtElements = new JTable();
		updatePropertiesElements();
		jspTable = new JScrollPane(jtElements);
		updatePropertiesTable();
		centertextInCell();
		this.setBorder(null);
	}

	private void updatePropertiesElements() {
		jtElements.setIntercellSpacing(new Dimension(0, 0));
		jtElements.setShowVerticalLines(false);
		jtElements.setFocusable(false);
		jtElements.getTableHeader().setResizingAllowed(false);
		jtElements.setBackground(Color.WHITE);
		jtElements.getTableHeader().setPreferredSize(new Dimension(0, 60));
		jtElements.getTableHeader().setForeground(Color.WHITE);
		jtElements.getTableHeader().setOpaque(false);
		jtElements.getTableHeader().setBackground(Color.BLACK);
		jtElements.setRowHeight(35);
		jtElements.setSelectionBackground(ConstantsUI.COLOR_MEDIUM_AQUAMARINE);
		jtElements.setBorder(null);
		jtElements.setModel(dtmElements);
	}

	private void updatePropertiesTable() {
		jspTable.setForeground(ConstantsUI.COLOR_WHITE);
		jspTable.setBorder(null);
	}

	private void addComponentsToPanel() {
		this.add(jspTable, BorderLayout.PAGE_END);
	}

	private void setFontManager() {
		uploadResources = new UploadResources();
		UIManager.put("TableHeader.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 1, 11));
		UIManager.put("Table.font", uploadResources.uploadFont(PathConstants.PATH_FONT_VERDANA, 0, 11));
	}

	public void setDtmElements(DefaultTableModel dtmElements) {
		this.dtmElements = dtmElements;
	}

	public DefaultTableModel getDtmElements() {
		return dtmElements;
	}

	private void centertextInCell() {
		DefaultTableCellRenderer centerModel = new DefaultTableCellRenderer();
		centerModel.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < dtmElements.getColumnCount(); i++) {
			jtElements.getColumnModel().getColumn(i).setCellRenderer(centerModel);
		}
	}
}
