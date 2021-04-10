package views.models;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

public class JModelComboBox extends JComboBox<Object> {


	private static final long serialVersionUID = 1L;
	public JModelComboBox(Object[] objects, String title) {
		super(objects);
		setBorder(BorderFactory.createTitledBorder(title));
	}
	public void setItems(Object[] objects) {
		this.removeAllItems();
		for (int i = 0; i < objects.length; i++) {
			this.addItem(objects[i]);
		}
	}
}
