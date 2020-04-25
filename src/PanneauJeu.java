import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class PanneauJeu extends JPanel{

	PlateauJeu plateauJeu;
	BarreMenu barreMenu;

	protected Color selectedColor=null;
	protected int tentativeActif=0;
	LinkedList<Color[]> listeCombi = new LinkedList<>();
	private ExecutorService executor;
	private boolean fini = false;
	private boolean modeOrdi = false;

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
		lancerExecutor();
	}

	//		Méthode de gestion de l'évaluation des combinaisons
	public void evalCombi() {
		Combinaison combiJeu = plateauJeu.grilleCouleurs.tentatives[tentativeActif];
		Combinaison combiCache = barreMenu.hiddenCombiPanel.hiddenCombi;

		//int nbrPresentes = combiCache.nbrCouleursPresentes(combiJeu);
		//int nbrPlacees = combiCache.nbrCouleursPlacees(combiJeu);
		int[] evalCombi = Combinaison.evalCombi(combiJeu.getCouleurs(), combiCache.getCouleurs());

		plateauJeu.carrePresence.tentatives[tentativeActif].setText(""+evalCombi[1]);
		plateauJeu.carrePlacement.tentatives[tentativeActif].setText(""+evalCombi[0]);

		fini = testFinjeu(evalCombi[0]);

		ajouterThread(new Elimination(combiJeu.getCouleurs(), evalCombi));
		if(!fini)
			activeNextTentative();
	}


	//		Méthode pour activer la tentative suivante
	private void activeNextTentative() {
		tentativeActif++;
		
		if(!modeOrdi )
			plateauJeu.grilleCouleurs.tentatives[tentativeActif].setEnabled(true);
		repaint();
		activationOrdi();
	}


	public boolean testFinjeu(int nbrValides) {
		if(Mastermind.tailleCombinaison==nbrValides) {
			new FenetreFin(true);
			return true;	
		}else if(Mastermind.nbrTentatives==tentativeActif) {
			new FenetreFin(false);
			return true;	
		}
		return false;
	}

	//	Lance l'exécuteur et la génération de coùmbi aléatoires
	public void lancerExecutor() {
		executor = Executors.newSingleThreadExecutor();
		executor.execute(new Thread(generation));
	}

	//	Ajouter une thread à la file
	public void ajouterThread(Thread t) {
		executor.execute(t);
	}

	//	Thread de génération des combinaisons
	Runnable generation = () -> listeCombi = ModeOrdinateur.generationCombis();


	//	Thread d'élimination des combis invalides
	class Elimination extends Thread {
		private Color[] combiJeu;
		private int[] evalCombi;

		public Elimination(Color[] combiJeu, int[] evalCombi) {
			this.combiJeu = combiJeu;
			this.evalCombi = evalCombi;
		}

		public void run() {
			//System.out.println();
			//System.out.println(listeCombi);
			ModeOrdinateur.eliminerInvalides(listeCombi, combiJeu, evalCombi);
			//System.out.println("Elimination");
			//System.out.println(listeCombi);
		}
	}

	//	Ajouter une thread à la file
	public void activationOrdi() {
		//	Attendre la fin des calculs de partie
		executor.shutdown();
		while(!executor.isTerminated()) {}

		//	Mise en place du Mode Ordi
		modeOrdi = true;
		plateauJeu.grilleCouleurs.tentatives[tentativeActif].setEnabled(false);


		//	Execution du mode ordinateur
		executor = Executors.newSingleThreadExecutor();
		while(!fini) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					//Choix Combinaison Aleatoire
					int numCombi = (int)(Math.random()*listeCombi.size());
					plateauJeu.grilleCouleurs.tentatives[tentativeActif-1].modifierCombi(listeCombi.getFirst());
					repaint();
				}
			});
			


			//Elimination Invalide
			evalCombi();
			repaint();
		}
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

