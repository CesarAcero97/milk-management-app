package views.models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JButtonHeader extends JButton {

	private static final long serialVersionUID = 1L;
	private int arcW;
	private int arcH;
	private Color colorBorder;

	public JButtonHeader(int arcW, int arcH, String text, Color colorBackground, Color colorForeground, Font font,
			String Command, ActionListener actionListener, Color colorBoder) {
		super(text);
		this.arcW = arcW;
		this.arcH = arcH;
		this.setBackground(colorBackground);
		this.setContentAreaFilled(false);
		this.setForeground(colorForeground);
		this.setFont(font);
		this.setActionCommand(Command);
		this.addActionListener(actionListener);
		this.colorBorder = colorBoder;
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getBackground());
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcW, arcH);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(colorBorder);
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcW, arcH);
	}
}
