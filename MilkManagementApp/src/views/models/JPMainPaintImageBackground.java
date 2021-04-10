package views.models;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPMainPaintImageBackground extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image image;

	public JPMainPaintImageBackground(String pathImage) {
		image = new ImageIcon(pathImage).getImage();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, 1100, 450, this);
		setOpaque(false);
		super.paint(g);
	}
}
