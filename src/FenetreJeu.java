// Chargement des bibliothèques Swing et AWT
	import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame implements ActionListener {
	
	// Les Widgets à déclarer en dehors du constructeur
		private JButton Jouer;
	    private JButton Options;
	    private JButton ModeOrdinateur;
	    private JButton Regles;
	    private JButton scores;

	public FenetreJeu() {
		this.setTitle("Jeu ");
		this.setSize(800,800);
		// Pour placer la fenêtre au centre de l'écran
		this.setLocationRelativeTo(null);
		// Pour empêcher le redimensionnement de la fenêtre
		this.setResizable(true);
		// Pour permettre la fermeture de la fenêtre lors de l'appui sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * Panneau Mastermind
		 */
		JPanel panneauMastermind = new JPanel();
		panneauMastermind.setBounds(100,20,600,50);
		panneauMastermind.setLayout(null);
		panneauMastermind.setBackground(Color.white);
		int width=this.getWidth();
		int height=this.getHeight();
		this.add(panneauMastermind);
		
		/**
		 * Texte Mastermind
		 */
		JLabel lettreMastermind = new JLabel();
		lettreMastermind.setText("Mastermind");
		lettreMastermind.setBounds(width/2,height/15,30*10,40);		
		panneauMastermind.add(lettreMastermind);
		
		/**
		 * Texte M
		 */
		JLabel lettreM = new JLabel();
		lettreM.setText("M");
		lettreM.setBounds(width+10,height+10,15,20);
		lettreM.setForeground(Color.red);		
		panneauMastermind.add(lettreM);
		
	     /**
		 * Texte A
		 */
		JLabel lettreA = new JLabel();
		lettreA.setText("A");
		lettreA.setBounds(140,35,15,20);
		lettreA.setForeground(Color.orange);		
		panneauMastermind.add(lettreA);
		/**
		 * Texte S
		 */
		JLabel lettreS = new JLabel();
		lettreS.setText("S");
		lettreS.setBounds(160,35,15,20);
		lettreS.setForeground(Color.yellow);		
		panneauMastermind.add(lettreS);
		/**
		 * Texte T
		 */
		JLabel lettreT = new JLabel();
		lettreT.setText("T");
		lettreT.setBounds(180,35,15,20);
		lettreT.setForeground(Color.green);		
		panneauMastermind.add(lettreT);
		/**
		 * Texte E
		 */
		JLabel lettreE = new JLabel();
		lettreE.setText("E");
		lettreE.setBounds(200,35,15,20);
		lettreE.setForeground(Color.black);		
		panneauMastermind.add(lettreE);
		/**
		 * Texte R
		 */
		JLabel lettreR = new JLabel();
		lettreR.setText("R");
		lettreR.setBounds(220,35,15,20);
		lettreR.setForeground(Color.black);		
		panneauMastermind.add(lettreR);
		/**
		 * Texte M
		 */
		JLabel lettreM2 = new JLabel();
		lettreM2.setText("M");
		lettreM2.setBounds(240,35,15,20);
		lettreM2.setForeground(Color.green);		
		panneauMastermind.add(lettreM2);
		/**
		 * Texte I
		 */
		JLabel lettreI = new JLabel();
		lettreI.setText("I");
		lettreI.setBounds(260,35,15,20);
		lettreI.setForeground(Color.yellow);		
		panneauMastermind.add(lettreI);
		/**
		 * Texte N
		 */
		JLabel lettreN = new JLabel();
		lettreN.setText("N");
		lettreN.setBounds(280,35,15,20);
		lettreN.setForeground(Color.orange);		
		panneauMastermind.add(lettreN);
		/**
		 * Texte D
		 */
		JLabel lettreD = new JLabel();
		lettreD.setText("M");
		lettreD.setBounds(300,35,15,20);
		lettreD.setForeground(Color.red);		
		panneauMastermind.add(lettreD);
		
		/**
		 * Panneau global
		 */
		JPanel panneauGlobal = new JPanel();
		panneauGlobal.setBounds(0,0,400,400);
		panneauGlobal.setLayout(null);
		panneauGlobal.setBackground(Color.orange);
		this.add(panneauGlobal);
		
		
		/**
		 * Bouton Jouer
		 */
		Jouer = new JButton("Jouer");
		Jouer.setBounds(20,100,80,50);
	    Jouer.setBackground(Color.cyan);
		Jouer.setForeground(Color.white);
		/* branchement de l'écouteur*/
		Jouer.addActionListener(this);
		panneauGlobal.add(Jouer);
		
		/**
		 * Bouton Options
		 */
		Options = new JButton(" Options");
		Options.setBounds(100,100,80,50);
		Options.setBackground(Color.cyan);
		Options.setForeground(Color.white);
		/* branchement de l'écouteur*/
		Options.addActionListener(this);
		panneauGlobal.add(Options);
		
		/**
		 * Bouton Mode Ordinateur
		 */
		ModeOrdinateur = new JButton("ModeOrdinateur");
		ModeOrdinateur.setBounds(180,100,80,50);
		ModeOrdinateur.setBackground(Color.cyan);
		ModeOrdinateur.setForeground(Color.white);
		/* branchement de l'écouteur*/
		ModeOrdinateur.addActionListener(this);
		panneauGlobal.add(ModeOrdinateur);
		
		/**
		 * Bouton Règles
		 */
		Regles = new JButton("Regles");
		Regles.setBounds(260,100,80,50);
		Regles.setBackground(Color.cyan);
		Regles.setForeground(Color.white);
		/* branchement de l'écouteur*/
		Regles.addActionListener(this);
		panneauGlobal.add(Regles);
		
		/**
		 * Bouton Tableau des scores
		 */
		scores = new JButton("Tableau des scores");
		scores.setBounds(260,200,80,50);
		scores.setBackground(Color.cyan);
		scores.setForeground(Color.white);
		/* branchement de l'écouteur*/
		scores.addActionListener(this);
		panneauGlobal.add(scores);
	
		
	
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

