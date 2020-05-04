import java.awt.Color;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanneauJeu extends JPanel{

	PlateauJeu plateauJeu;
	BarreMenu barreMenu;

	protected Color selectedColor=null;
	protected int tentativeActif=0;
	LinkedList<Color[]> listeCombi = new LinkedList<>();
	private ExecutorService executor;
	protected boolean fini = false;
	private boolean modeOrdi = false;
	FenetreFin finaleFrame;
	private boolean gagner;
	private boolean revealed =false;

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
		System.out.println(tentativeActif);
		Color[] combiJeu = Arrays.copyOf(plateauJeu.grilleCouleurs.tentatives[tentativeActif].getCouleurs(), Mastermind.tailleCombinaison);
		Color[] combiCache = Arrays.copyOf(barreMenu.hiddenCombiPanel.hiddenCombi.getCouleurs(), Mastermind.tailleCombinaison);

		ModeOrdinateur.printCombi(combiJeu);
		ModeOrdinateur.printCombi(combiCache);


		//int nbrPresentes = combiCache.nbrCouleursPresentes(combiJeu);
		//int nbrPlacees = combiCache.nbrCouleursPlacees(combiJeu);
		int[] evalCombi = Combinaison.evalCombi(Arrays.copyOf(combiJeu, combiJeu.length), Arrays.copyOf(combiCache, combiCache.length));

		plateauJeu.carrePresence.tentatives[tentativeActif].setText(""+evalCombi[1]);
		plateauJeu.carrePlacement.tentatives[tentativeActif].setText(""+evalCombi[0]);

		fini = testFinjeu(evalCombi[0]);

		ajouterThread(new Elimination(Arrays.copyOf(combiJeu, combiJeu.length), evalCombi));
		if(!fini) {
			activeNextTentative();
		}else {
			String temps = barreMenu.gameStats.timerLabel.stopTimer();
			if(!modeOrdi&&!revealed)
				finaleFrame = new FenetreFin(gagner, temps, tentativeActif+1);
		}
	}


	//		Méthode pour activer la tentative suivante
	private void activeNextTentative() {
		tentativeActif++;

		if(!modeOrdi) {
			plateauJeu.grilleCouleurs.tentatives[tentativeActif].setEnabled(true);
		}else {
			activationOrdi();
		}
		repaint();

	}

	//		Test si le jeu est fini est si l'utilisateur a gagné ou perdu
	public boolean testFinjeu(int nbrValides) {
		if(Mastermind.tailleCombinaison==nbrValides) {
			gagner =true;
			barreMenu.hiddenCombiPanel.afficheCombi();
			return true;	
		}else if(Mastermind.nbrTentatives==tentativeActif) {
			gagner=false;
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
			ModeOrdinateur.eliminerInvalides(listeCombi, combiJeu, evalCombi);
		}
	}

	//	Ajouter une thread à la file
	public void activationOrdi() {
		//	Mise en place du Mode Ordi
		plateauJeu.grilleCouleurs.tentatives[tentativeActif].setEnabled(false);
		
		//	Attendre la fin des calculs de partie
		executor.shutdown();
		while(!executor.isTerminated()) {}



		//	Execution du mode ordinateur
		executor = Executors.newSingleThreadExecutor();


		//Choix Combinaison Aleatoire
		int numCombi = (int)(Math.random()*listeCombi.size());
		plateauJeu.grilleCouleurs.tentatives[tentativeActif].modifierCombi(listeCombi.get(numCombi));
		repaint();
		System.out.println("combiModif");

		//Elimination Invalide
		evalCombi();
		repaint();

	}
	
	//		Bouton Mode Ordinateur
	public void lancerOrdi() {
		modeOrdi=true;
	}
	
	//		Bouton Reveal Code
	public void reveal() {
		barreMenu.hiddenCombiPanel.afficheCombi();
		//		Alternative au reveal
		//barreMenu.gameStats.timerLabel.stopTimer();
		//plateauJeu.grilleCouleurs.tentatives[tentativeActif].setEnabled(false);
		revealed = true;
		
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

