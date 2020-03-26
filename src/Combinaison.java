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
	 * M�thode qui renvoie le nombre de couleurs bien plac�es
	 */
	public static int compteur(RoundButton[]combinaison1, RoundButton []combinaison2,int n) {
		//Le tableau doublon permet d'eviter de compter plusieurs fois une couleur
		boolean[]doublon=new boolean[n];
		int res=0;
		for(int i=0; i<n ; i++) {
			if(combinaison1[i]==combinaison2[i]) {
				doublon[i]=true;		
				res++;
			}else {
				doublon[i]=false;
		    }
		}
		return res;
	}

	/**
	 * Compare la combinaison du joueur avec la combinaison exacte
	 * M�thode qui renvoie le nombre de couleurs devin�es mais mal plac�es
	 */
	public static int compteur2 (RoundButton[]combinaison1, RoundButton []combinaison2,int n) {
		int res=0;
		boolean[]doublon=new boolean[n];
		int j=0;
		boolean malplace=false;
		for(int i=0; i<n; i++) {
			if(combinaison1[i]!=combinaison2[i]) {
				while(j<n && !malplace) {
					if(!doublon[j] && combinaison1[i]==combinaison2[j]) {
						doublon[i]=true;
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
	
	



