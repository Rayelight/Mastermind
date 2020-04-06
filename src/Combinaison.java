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
	
	public static int combinaisonHeight(){
		int height = (int)Math.round((double)GrilleCouleurs.gridColorHeight()/Mastermind.nbrTentatives);
		return height;

	}
	
	
	/**
	 * Compare la combinaison du joueur avec la combinaison exacte
	 * Méthode qui renvoie le nombre de couleurs bien plac�es
	 */
	public int nbrCouleursValides(Combinaison  combiJeu) {
		int res=0;
		for(int i=0; i<Mastermind.tailleCombinaison ; i++) {
			if(this.couleurs[i].getCouleur() == combiJeu.couleurs[i].getCouleur()) {	
				res++;
		    }
		}
		return res;
	}

	/**
	 * Compare la combinaison du joueur avec la combinaison exacte
	 * Méthode qui renvoie le nombre de couleurs devinées mais mal plac�es
	 */
	public int nbrCouleursPresentes (Combinaison combiJeu) {
		int res=0;
		for(int i=0; i<Mastermind.tailleCombinaison ; i++) {
			boolean malPlace=false;
			int j=0;
			if(combiJeu.couleurs[i].getCouleur()!=this.couleurs[i].getCouleur()) {
				while(j<Mastermind.tailleCombinaison && !malPlace) {
					if(combiJeu.couleurs[i].getCouleur()==this.couleurs[j].getCouleur()) {				
						malPlace=true;
						res++;
						if(Mastermind.multiColor){					
							break;
						}
					}					
					j++;	
				}	
		    }		
		}
		return res;
	}
}
	



