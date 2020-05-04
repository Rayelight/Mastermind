import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public abstract class GradientPanel extends JPanel {

	protected SpringLayout layout;
	Color borderColor;

	GradientPanel(){

		//			Panel Setup 
		layout = new SpringLayout();
		this.setLayout(layout);

		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
				revalidate();
				repaint();

			}
		});
	}

	public abstract void adjustContraints();
	
	@Override
	protected void paintComponent(Graphics grphcs) {
		this.borderColor = Mastermind.darkMode?Color.decode("#C4C8BB"):Color.decode("#FF5A01");
		this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, borderColor));
		
		super.paintComponent(grphcs);
		Graphics2D g2d = (Graphics2D) grphcs;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		//GradientPaint gp = new GradientPaint(0, -getHeight()/2, getBackground().brighter().brighter(),
		// 		0, getHeight()/2,getBackground());
		GradientPaint gp = new GradientPaint (getWidth()/4, getHeight()/4, Color.orange, 
				getWidth()*3/4, getHeight()*3/4, Color.decode("#FF8701")); 
		g2d.setPaint(gp);
		if(Mastermind.darkMode) {
        	g2d.setColor(Color.decode("#403A2C"));
        }
		g2d.fillRect(0, 0, getWidth(), getHeight()); 

	}





}
