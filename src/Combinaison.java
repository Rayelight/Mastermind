import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Combinaison extends JPanel implements ActionListener{

	private RoundButton[] couleurs = new RoundButton[Mastermind.tailleCombinaison];

	public Combinaison(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		this.setOpaque(false);
		this.setBackground(Color.blue);
		//this.setBorder(BorderFactory.createLineBorder(Color.black));

		for(int i=0; i<Mastermind.tailleCombinaison; i++) {
			couleurs[i] = new RoundButton();
			couleurs[i].addActionListener(this);
			this.add(couleurs[i]);
		}
		setEnabled(false);

	}

	public Combinaison(Color[] couleurs) {
		this();
		this.modifierCombi(couleurs);
	}

	public void setEnabled(boolean b){
		for(int i=0; i<Mastermind.tailleCombinaison; i++) {
			couleurs[i].setEnabled(b);
		}

	}


	//		Gestion de la taille
	public Dimension getPreferredSize(){
		return new Dimension(GrilleCouleurs.gridColorWidth(), Combinaison.combinaisonHeight());
	}
	public Dimension getMaximumSize(){
		return getPreferredSize();
	}
	public static int combinaisonHeight(){
		int height = (int)Math.round((double)GrilleCouleurs.gridColorHeight()/Mastermind.nbrTentatives);
		return height;
	}


	//		Méthodes de jeu
	@Override
	public void actionPerformed(ActionEvent e) {
		RoundButton bouton = (RoundButton)(e.getSource());	
		Color couleur = Mastermind.getPanneauJeu().getSelectedColor();
		if(couleur!=null) {
			bouton.setCouleur(couleur);
			Thread testFinTentative = new Thread() {
				public void run() {
					testFinTentative();
				}
			};
			testFinTentative.start();

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

	public static int[] evalCombi(Color[] couleursJeu, Color[] couleursCache) {

		int[] eval = {0,0};

		//		Couleurs bien Placées
		for(int i=0; i<Mastermind.tailleCombinaison ; i++) {
			if(couleursJeu[i].equals(couleursCache[i])) {	
				couleursJeu[i]=Color.lightGray;
				couleursCache[i]= Color.darkGray;
				eval[0]++;
			}
		}

		//		Couleurs Présentes
		for(int i=0; i<Mastermind.tailleCombinaison ; i++) {
			for(int j=0; j<Mastermind.tailleCombinaison ; j++) {
				if(couleursJeu[i].equals(couleursCache[j])) {	
					couleursJeu[i]=Color.lightGray;
					couleursCache[j]= Color.darkGray;
					eval[1]++;
				}
			}
		}

		return eval;
	}

	//		Renvoie une copie du tableau de Couleurs de la combinaison
	public Color[] getCouleurs() {
		Color[] couleurs = new Color[Mastermind.tailleCombinaison];
		for(int i=0; i<couleurs.length ; i++) {
			couleurs[i]=this.couleurs[i].getCouleur();	
		}

		return couleurs;
	}
	
	//		Modifie une combinaison suivants un tableau de couleurs
	public void modifierCombi(Color[] couleurs) {

		for(int i=0; i<couleurs.length ; i++) {
			this.couleurs[i].setCouleur(couleurs[i]);
			//System.out.println(couleurs[i]);
		}
		this.revalidate();
		this.repaint();

	}

}




