import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class GrilleCouleurs  extends JPanel{

	protected Combinaison[] tentatives = new Combinaison[Mastermind.nbrTentatives];

	public GrilleCouleurs() {
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setLayout(new GridLayout(Mastermind.nbrTentatives, 1));
		this.setBackground(Color.red);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));

		for(int i=Mastermind.nbrTentatives-1; i>=0; i--) {
			this.add(tentatives[i]=new Combinaison());

		}
	}


	//		Paramétisation des dimensions
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(gridColorWidth(), gridColorHeight());
	}

	public static int gridColorWidth(){
		int grilleCouleursWidth = (RoundButton.boutonRadius()+10)*Mastermind.tailleCombinaison+5; 
		return grilleCouleursWidth;

	}

	public static int gridColorHeight(){
		int grilleCouleursHeight = Mastermind.generalHeight()-40;
		return grilleCouleursHeight;

	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint (getWidth()/4, getHeight()/4, Color.blue, 
				getWidth()*5/4, getHeight()*5/4, Color.cyan); 
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, getWidth(), getHeight()); 
	}


}



