import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import javax.swing.JButton;


@SuppressWarnings("serial")
class RoundButton extends JButton {
	private Color couleur;
	
	public RoundButton() {
		//size.width = size.height = Math.max(size.width,size.height);
		//size.width = size.height=radius;
		//setMargin(new Insets(10, 10, 10, 10));
		this.couleur=Color.lightGray;
		setContentAreaFilled(false);
	}
	
	public RoundButton(Color couleur) {
		this();
		this.couleur=couleur;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        
        if (getModel().isArmed()) {
			g.setColor(couleur.brighter());
		} else {
			g.setColor(getBackground());
		}
        
        //GradientPaint
        Color secondColor = new Color(getBackground().getRed(), getBackground().getGreen(),
        		getBackground().getBlue(), 0);
        
        GradientPaint gp = new GradientPaint (getWidth()/4, getHeight()/4, getBackground().brighter(), 
        		getWidth()*3/4, getHeight()*3/4, secondColor); 
        g2d.setPaint(gp);
        
        //LinearGradientPaint
        Point2D start = new Point2D.Float(getWidth()/4, getHeight()/4);
        Point2D end = new Point2D.Float(getWidth(), getHeight());
        float[] dist = {0.25f, 1.0f};
        Color[] colors = {getBackground(), new HSLColor(getBackground()).adjustTone(80)};
        LinearGradientPaint p =
            new LinearGradientPaint(start, end, dist, colors);
		
        g2d.setPaint(p);
        
		g2d.fillOval(0, 0, getSize().width-1, getSize().height-1);
	}

	protected void paintBorder(Graphics g) {
		
		if (getModel().isArmed()||isSelected()) {
			g.setColor(Color.white);
		} else {
			g.setColor(getForeground());
		}
		g.drawOval(0, 0, getSize().width-1, getSize().height-1);
	}

	Shape shape;
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}
	
	@Override
	public Color getBackground() {
		return this.couleur;
	}
	
	
	
	public static int boutonRadius(){
		int radius = Combinaison.combinaisonHeight()-10;  
		return radius;

	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(boutonRadius(), boutonRadius());
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}


}

