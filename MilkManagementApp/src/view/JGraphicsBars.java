package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JGraphicsBars extends JPanel{

	private Object[] IDENTIFIERS;
	public  Object[] DATUMS;
	private JLabel title;

	private short x1;
	private short y1;
	private short x2;
	private short y2;

	private short x1lineV;
	private short y1lineV;
	private short x2lineV;
	private short y2lineV;

	private short maxHeightY;
	private static final long serialVersionUID = 1L;

	public JGraphicsBars() {
		this.title = new JLabel();
		add(this.title);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.RED);
		x1 = (short) (getWidth()/12);
		y1 = (short) (getHeight()/1.1);
		x2 = (short) (getWidth()-getWidth()/12);
		y2 = (short) (getHeight()/1.1);

		x1lineV = (short) (getWidth()/12);
		y1lineV = 20;
		x2lineV = x1;
		y2lineV =y1;
		g.drawLine(x1,y1, x2, y2);
		g.drawLine(x1lineV, y1lineV, x2lineV, y2lineV);
		paintDivisionY(g,20);
		paintDivisionX(g,IDENTIFIERS,DATUMS,IDENTIFIERS.length);
	
	}
	
	public void setValues(Object[] keys , Object[] values, String title) {
		this.title.setText(title);
		this.IDENTIFIERS = keys;
		this.DATUMS = values;

	}
	public double getIntervalX(int interval) {
		return (short) ((x2-x1)/interval);
	}
	public double getIntervalY(int interval) {
		return (short) ((y2-y1lineV)/interval);
	}
	
	
	public int calculateBarras(int number){
		return -(number*(maxHeightY))/20000;
	}
	
	private void paintDivisionX(Graphics graphics,Object[] keys,Object[] datums,int interval) {
		short divisionsX = 0;
		graphics.setColor(Color.black);

		for (int i = 0; i < datums.length; i++) {
			divisionsX += (short) getIntervalX(interval);
			graphics.fillRect((int) divisionsX, y1, 35, calculateBarras((int)datums[i]));
		}
		divisionsX =0;
		
		for (short i = x1, j=0;i < x2; i+=getIntervalX(interval),j++) {
			divisionsX += (short) getIntervalX(interval);
			
			if (j!=interval) {
				String aux = (String)keys[j];
				if (aux.length()>8) {
					graphics.drawString((String)keys[j],(divisionsX-10), (y1+20));
				}else {
					graphics.drawString((String)keys[j],divisionsX, (y1+20));
				}
			}	
		}
		
	}
	private void paintDivisionY(Graphics graphics,int interval) {
		short divisonsY =0;
		short increment = 0;
		graphics.setColor(Color.black);
		for (short i = y1lineV; i < (y2lineV); i+=getIntervalY(interval)) {
			divisonsY +=getIntervalY(interval);
			increment +=1;
			if (increment<=20) {
			maxHeightY=divisonsY;
				graphics.drawLine(x2lineV-5,(int)(y2lineV)-divisonsY, x2lineV+5,(int)(y2lineV)-divisonsY);
//				if (increment%2 == 0) {
					graphics.drawString(increment+"k",(x2lineV-30),(int) (y2lineV)-divisonsY+3);
//				}
				
			}
		
		}

	}
	
}


