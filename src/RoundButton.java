import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;


@SuppressWarnings("serial")
class RoundButton extends JButton implements ActionListener {
	private Color couleur;
	private boolean typeJeu;
	
	public RoundButton() {
		//size.width = size.height = Math.max(size.width,size.height);
		//size.width = size.height=radius;
		//setMargin(new Insets(10, 10, 10, 10));
		this.couleur=Color.lightGray;
		this.typeJeu = true;
		setContentAreaFilled(false);
		addActionListener(this);
	}
	
	public RoundButton(Color couleur) {
		this.couleur=couleur;
		this.typeJeu = false;
		setBackground(this.couleur);
		setContentAreaFilled(false);
		addActionListener(this);
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
		
		if (getModel().isArmed()) {
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

	public static int boutonRadius(){
		int radius = Combinaison.combinaisonHeight()-10;  
		return radius;

	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(boutonRadius(), boutonRadius());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.typeJeu) {
			
		}else {
			
		}
		
	}

	public Color getCouleur() {
		return couleur;
	}


}

