
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class GradientButton extends JButton {
	
	GradientButton(String texte){
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#FF5A01"),4));
	}
	
	@Override
    protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //GradientPaint gp = new GradientPaint(0, -getHeight()/2, getBackground().brighter().brighter(),
        // 		0, getHeight()/2,getBackground());
        GradientPaint gp = new GradientPaint (getWidth()/4, getHeight()/4, Color.blue, 
        		getWidth()*3/4, getHeight()*3/4, Color.decode("#FF8701")); 
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight()); 
        //super.paintComponent(grphcs);
    }
	


}