package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;

public class GraphicsCake extends JPanel {

	private static final long serialVersionUID = 1L;

	private Object[] values;
	public Object[] keys;
	private Random random;
	private JLabel title;

	public GraphicsCake() {
		this.title = new JLabel();
		title.setBorder(new EmptyBorder(new Insets(15,0,0,0)));
		this.add(this.title);
		title.setFont(new Font("Times-Roman", Font.BOLD + Font.ITALIC, 20));
	}

	public void setDatums(Object[] vector, Object[] keys, String title) {
		this.title.setText(title);
		this.values = vector;
		this.keys = keys;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintCake(g, calculateTotal(values), values, keys);
	}

	private int calculateTotal(Object[] vector) {
		int totalSum = 0;
		for (Object obj : vector) {
			int aux = (int) Math.round((Double) obj);
			totalSum += aux;
		}
		return totalSum;
	}

	private void paintCake(Graphics g, int total, Object[] vector,Object[] keys) {
		random = new Random();

		int grades = 0;
		int gradesNext = 0;

		int conventionCy = 150;
		int conventionCx = 600;

		int conventionTy = 160;
		int conventionTx = 620;

		for (int i = 0; i < vector.length; i++) {

			float redColor = random.nextFloat();
			float greenColor = random.nextFloat();
			float blueColor = random.nextFloat();

			g.setColor( new Color(redColor,greenColor,blueColor) );
			gradesNext = ( (int) (Math.round( (Double)vector[i] * 360 / total)));
			g.fillArc(100, 50, 400, 400, grades , gradesNext);
			grades += ( (int) Math.round((Double)vector[i] * 360  / total));

			// Haciendo las convenciones
			g.fillRect(conventionCx, conventionCy, 10, 10);
			g.setColor(Color.black);
			g.drawString((String)keys[i] + "      " + toDecimalFormatStatistics((Double)vector[i]), conventionTx, conventionTy);
			conventionCy += 20;
			conventionTy += 20;
		}
	}

	private static String toDecimalFormatStatistics(double value) {
		DecimalFormat df = new DecimalFormat("#.#'%'");
		return df.format(value);
	}

}
