

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class GradientLabel extends JLabel {

	GradientLabel(){
		//this.setBorder(BorderFactory.createLineBorder(Color.decode("#FF5A01"),4));
		this.setBackground(Color.blue);
		this.setForeground(Color.black);
		this.setOpaque(false);
		Color borderColor = Mastermind.darkMode?Color.decode("#484321"):Color.white;
		this.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(borderColor, 2, true),
				BorderFactory.createEmptyBorder(10,10,10,10)));
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setFont(new Font("Serif", Font.BOLD, getHeight()*5/12));
				repaint();
			}
		});
	}

	GradientLabel(String texte){
		this();
		this.setText(texte);

	}

	@Override
	protected void paintComponent(Graphics grphcs) {

		Graphics2D g2d = (Graphics2D) grphcs;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		//GradientPaint gp = new GradientPaint(0, -getHeight()/2, getBackground().brighter().brighter(),
		// 		0, getHeight()/2,getBackground());
		GradientPaint gp = new GradientPaint (getWidth()/4, getHeight()/4, Color.blue, 
				getWidth()*5/4, getHeight()*5/4, Color.cyan); 
		g2d.setPaint(gp);
		if(Mastermind.darkMode) {
			g2d.setColor(Color.decode("#D3CEBA"));
		}
		g2d.fillRect(0, 0, getWidth(), getHeight()); 
		super.paintComponent(grphcs);

	}



}
