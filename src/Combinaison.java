import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Combinaison extends JPanel implements ActionListener{
	
	private RoundButton[] couleurs = new RoundButton[Mastermind.tailleCombinaison];

	public Combinaison(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		//this.setOpaque(false);
		this.setBackground(Color.blue);
		//this.setBorder(BorderFactory.createLineBorder(Color.black));

		for(int i=0; i<Mastermind.tailleCombinaison; i++) {
			couleurs[i] = new RoundButton();
			couleurs[i].addActionListener(this);
			this.add(couleurs[i]);
		}
		setEnabled(false);

	}
	
	public void setEnabled(boolean b){
		for(int i=0; i<Mastermind.tailleCombinaison; i++) {
			couleurs[i].setEnabled(b);
		}

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		RoundButton bouton = (RoundButton)(e.getSource());	
		Color couleur = Mastermind.getPanneauJeu().getSelectedColor();
		if(couleur!=null) {
			bouton.setCouleur(couleur);
			testFinTentative();
		}
	}
	
	private void testFinTentative() {
		boolean finTentative = true;
		for(int i=0; i<Mastermind.tailleCombinaison; i++) {
			//if there still default color
			if(couleurs[i].getCouleur()==Color.lightGray) {
				finTentative = false;
				break;
			}
		}
		
		//Disable actifTentative
		if(finTentative) {
			setEnabled(false);
			Mastermind.getPanneauJeu().evalCombi();
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
	public int nbrCouleursPlacees(Combinaison  combiJeu) {
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
	



