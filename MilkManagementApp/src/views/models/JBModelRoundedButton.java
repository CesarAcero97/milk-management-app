package views.models;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class JBModelRoundedButton extends JButton {

	private static final long serialVersionUID = 1L;
	private int arcW;
	private int arcH;

	public JBModelRoundedButton(int arcW, int arcH, String text, Color colorBackground, Color colorForeground,
			Font font) {
		super(text);
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBackground(colorBackground);
		this.setContentAreaFilled(false);
		this.setForeground(colorForeground);
		this.setFont(font);
		this.setBorder(new EmptyBorder(15, 30, 15, 30));
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.setHorizontalAlignment(SwingConstants.CENTER);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getBackground());
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcW, arcH);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getBackground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcW, arcH);
	}
}
