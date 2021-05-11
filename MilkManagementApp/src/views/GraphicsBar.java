package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class GraphicsBar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel title;
	private Random random;
	private Object[] values;
	public Object[] keys;

	public GraphicsBar() {
		this.title = new JLabel();
		title.setBorder(new EmptyBorder(new Insets(30,0,0,0)));
		this.add(this.title);
		title.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 20));
	}

	public void setValues(Object[] vector , Object[] keys, String title) {
		this.title.setText(title);
		this.values = vector;
		this.keys = keys;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintAxis(g);
		paintBar(g, values, keys);
	}

	private int calculateMayor(Object[] vector){
		int mayor = (int) vector[0];
		for (int i = 0; i < vector.length; i++) {
			if ((int)vector[i] > mayor){
				mayor = (int)vector[i];
			}
		}
		return mayor;
	}

	private void paintAxis(Graphics g){
		g.drawLine(70,80,70,400);
		g.drawLine(70,400,700,400);
		g.drawString("^",68,85);
		g.drawString(">",700,405);
		g.setColor(Color.red);
		g.drawString("X",715,410);
		g.drawString("Y",60,75);
		g.drawString("O",60,405);
		g.drawString("--",70,100);
		g.drawString(String.valueOf(calculateMayor(values))+"   ",40,100);
	}
	public void paintBar(Graphics g, Object[] vector, Object[] keys){
		random = new Random();
		int value_Mayor = calculateMayor(vector);
		int x = 100;
		int x1 = 100;

		for (int i = 0; i < vector.length; i++) {

			float redColor = random.nextFloat();
			float greenColor = random.nextFloat();
			float blueColor = random.nextFloat();

			g.setColor(new Color(redColor, greenColor, blueColor));
			g.fillRect(x, 400 - ((Integer) vector[i] * 300 / value_Mayor) , 40, (Integer) vector[i] * 300 / value_Mayor);
			g.drawString(keys[i] + "", x1, 420);
			x += 80;
			x1 += 80;
		}
	}

}
