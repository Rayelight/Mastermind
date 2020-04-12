import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanneauJeu extends JPanel{

	PlateauJeu plateauJeu;
	BarreMenu barreMenu;
	
	protected Color selectedColor=null;
	protected int tentativeActif=0;
	
	public PanneauJeu(){

		
		//			Panel Setup
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setBackground(Color.orange);
		
		//			Components creation
		plateauJeu = new PlateauJeu();
		barreMenu = new BarreMenu();
		
		//			Adding components
		this.add(plateauJeu);
		this.add(barreMenu);
		

		
	}
	
	//		Méthodes Jeu
	public void lancerJeu() {
		plateauJeu.grilleCouleurs.tentatives[0].setEnabled(true);
	}
	
	
	public void evalCombi() {
		Combinaison combiJeu = plateauJeu.grilleCouleurs.tentatives[tentativeActif];
		Combinaison combiCache = barreMenu.hiddenCombiPanel.hiddenCombi;
		
		int nbrPresentes = combiCache.nbrCouleursPresentes(combiJeu);
		int nbrPlacees = combiCache.nbrCouleursPlacees(combiJeu);
		
		plateauJeu.carrePresence.tentatives[tentativeActif].setText(""+nbrPresentes);
		plateauJeu.carrePlacement.tentatives[tentativeActif].setText(""+nbrPlacees);
		
		boolean fini = testFinjeu(nbrPlacees);
		
		if(!fini)
			activeNextTentative();
		
	}
	
	

	private void activeNextTentative() {
		tentativeActif++;
		plateauJeu.grilleCouleurs.tentatives[tentativeActif].setEnabled(true);
		
	}
	
	
	public boolean testFinjeu(int nbrValides) {

		if(Mastermind.tailleCombinaison==nbrValides) {
			return true;	
		}else if(Mastermind.nbrTentatives==tentativeActif) {
			return true;	
		}
		return false;
	}

	
	
	//		Getters et Setters
	
	public Color getSelectedColor() {
		return selectedColor;
	}


	public void setSelectedColor(Color selectedColor) {
		this.selectedColor = selectedColor;
	}


	public int getTentativeActif() {
		return tentativeActif;
	}


	public void setTentativeActif(int tentativeActif) {
		this.tentativeActif = tentativeActif;
	}

	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Mastermind.generalWidth(),Mastermind.generalHeight());
	}

	



}

