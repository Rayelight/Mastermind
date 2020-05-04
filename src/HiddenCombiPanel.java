import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class HiddenCombiPanel extends GradientPanel{

	Combinaison hiddenCombi;
	JLabel cache;

	public HiddenCombiPanel(){

		//		Components creation
		Color[] couleurs = HiddenCombiPanel.combiAleatoire();
		hiddenCombi = new Combinaison(couleurs) {
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint (getWidth()/4, getHeight()/4, Color.blue, 
						getWidth()*5/4, getHeight()*5/4, Color.cyan); 
				if(Mastermind.darkMode) {
					gp = new GradientPaint (getWidth()/4, getHeight()/4, Color.decode("#11100F"), 
							getWidth()*5/4, getHeight()*5/4, Color.decode("#1D1B15")); 
				}
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight()); 
			}
		};

		cache = new JLabel() {
			public Dimension getPreferredSize(){
				return hiddenCombi.getPreferredSize();
			}
			public Dimension getMaximumSize(){
				return getPreferredSize();
			}
		};
		cache.setBackground(Color.black);
		cache.setBorder(BorderFactory.createLineBorder(Color.white, 2, true));
		cache.setOpaque(true);


		//			Adding components
		this.add(cache);
		this.add(hiddenCombi);


		adjustContraints();

	}


	public void adjustContraints() {
		//			Adjust Constraints
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, hiddenCombi, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hiddenCombi, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, cache, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, cache, 0, SpringLayout.HORIZONTAL_CENTER, this);
	}

	public static Color[] combiAleatoire() {
		int [] aleatoire = new int[Mastermind.tailleCombinaison];
		do {
			for(int i=0;i<Mastermind.tailleCombinaison;i++) {
				aleatoire[i]=(int)(Math.random()*Mastermind.nbrCouleurs);
			}				
		}while(!Mastermind.multiColor&&ModeOrdinateur.countDistinct(aleatoire)!=Mastermind.tailleCombinaison); 		

		return ModeOrdinateur.clone(aleatoire);
	}

	public void afficheCombi() {
		cache.setOpaque(false);
		repaint();
	}

	public void reinitialiserCombi() {
		Color[] couleurs = HiddenCombiPanel.combiAleatoire();
		hiddenCombi.modifierCombi(couleurs);
		cache.setOpaque(true);
		repaint();
	}

}