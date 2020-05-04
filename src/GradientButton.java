
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class GradientButton extends JButton {
	
	GradientButton(String texte){
		super(texte);
		this.setBackground(Color.blue);
		this.setOpaque(false);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setFont(new Font("Serif", Font.BOLD, getHeight()*5/12));
				repaint();
			}
		});
	}
	
	@Override
    protected void paintComponent(Graphics grphcs) {
		this.setForeground(Mastermind.darkMode?Color.decode("#D3CEBA"):Color.black);
		Color borderColor = Mastermind.darkMode?Color.decode("#484321"):Color.white;
		this.setBorder(BorderFactory.createLineBorder(borderColor, 2, true));
		
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //GradientPaint gp = new GradientPaint(0, -getHeight()/2, getBackground().brighter().brighter(),
        // 		0, getHeight()/2,getBackground());
        GradientPaint gp = new GradientPaint (getWidth()/4, getHeight()/4, Color.blue, 
        		getWidth()*5/4, getHeight()*5/4, Color.cyan); 
        g2d.setPaint(gp);
        if(Mastermind.darkMode) {
        	g2d.setColor(Color.decode("#605D48"));
        	if(this.getModel().isRollover()) {
        		g2d.setColor(Color.decode("#312E28"));
        	}
        	if(this.getModel().isPressed()||this.getModel().isArmed()||this.getModel().isSelected()) {
        		g2d.setColor(Color.decode("#484321"));
        	}
        }
        g2d.fillRect(0, 0, getWidth(), getHeight()); 
        super.paintComponent(grphcs);
    }
	


}
