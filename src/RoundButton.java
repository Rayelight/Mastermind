import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

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
		if (getModel().isArmed()) {
			g.setColor(couleur);
		} else {
			g.setColor(getBackground());
		}
		g.fillOval(0, 0, getSize().width-1, getSize().height-1);
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

