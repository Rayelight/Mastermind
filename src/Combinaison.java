import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Combinaison extends JPanel{
	private RoundButton[] couleurs = new RoundButton[Mastermind.tailleCombinaison];

	public Combinaison(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		//this.setOpaque(false);
		this.setBackground(Color.green);
		//this.setBorder(BorderFactory.createLineBorder(Color.black));

		for(int i=0; i<Mastermind.tailleCombinaison; i++) {
			couleurs[i] = new RoundButton();
			couleurs[i].setBackground(Color.gray);
			this.add(couleurs[i]);
		}

	}
	
	
	/**
	 * Compare la combinaison du joueur avec la combinaison exacte
	 * Méthode qui renvoie le nombre de couleurs bien plac�es
	 */
	public int nbrCouleursValides(Combinaison  combiJeu) {
		int res=0;
		for(int i=0; i<Mastermind.tailleCombinaison ; i++) {
			if(this.couleurs[Mastermind.tailleCombinaison].getCouleur() == combiJeu.couleurs[Mastermind.tailleCombinaison].getCouleur()) {	
				res++;
		    }
		}
		return res;
	}

	/**
	 * Compare la combinaison du joueur avec la combinaison exacte
	 * Méthode qui renvoie le nombre de couleurs devinées mais mal plac�es
	 */
	public int nbrCouleursPresent (Combinaison combiJeu) {
		int res=0;
		int j=0;
		boolean malplace=false;
		for(int i=0; i<Mastermind.tailleCombinaison; i++) {
			if(combiJeu.couleurs[Mastermind.tailleCombinaison].getCouleur()!=this.couleurs[Mastermind.tailleCombinaison].getCouleur()) {
				while(j<Mastermind.tailleCombinaison && !malplace) {
					if(combiJeu.couleurs[Mastermind.tailleCombinaison].getCouleur()==this.couleurs[Mastermind.tailleCombinaison].getCouleur()) {				
						malplace=true;
						res++;
					}
					j++;	
				}	
		    }		
		}
		return res;
	}
   
}
	
	



