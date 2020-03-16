// Chargement des biblioth�ques Swing et AWT
	import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 

@SuppressWarnings("serial")
public class FenetreJeu extends JFrame implements ActionListener {
	
	// Les Widgets � d�clarer en dehors du constructeur
		private JButton Jouer;
	    private JButton Options;
	    private JButton ModeOrdinateur;
	    private JButton Regles;
	    private JButton scores;

	public FenetreJeu() {
		this.setTitle("Jeu ");
		this.setSize(800,800);
		// Pour placer la fen�tre au centre de l'�cran
		this.setLocationRelativeTo(null);
		// Pour emp�cher le redimensionnement de la fen�tre
		this.setResizable(true);
		// Pour permettre la fermeture de la fen�tre lors de l'appui sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width=this.getWidth();
		int height=this.getHeight();
	
		
		
		/**
		 * Texte M
		 */
		JLabel lettreM = new JLabel();
		lettreM.setText("M");
		lettreM.setSize(60,80);
		lettreM.setForeground(Color.red);		

		
	     /**
		 * Texte A
		 */
		JLabel lettreA = new JLabel();
		lettreA.setText("A");
		lettreA.setSize(60,80);
		lettreA.setForeground(Color.orange);		

		/**
		 * Texte S
		 */
		JLabel lettreS = new JLabel();
		lettreS.setText("S");
		lettreS.setSize(60,80);
		lettreS.setForeground(Color.blue);		

		/**
		 * Texte T
		 */
		JLabel lettreT = new JLabel();
		lettreT.setText("T");
		lettreT.setSize(60,80);
		lettreT.setForeground(Color.green);		

		/**
		 * Texte E
		 */
		JLabel lettreE = new JLabel();
		lettreE.setText("E");
		lettreE.setSize(60,80);
		lettreE.setForeground(Color.black);		

		/**
		 * Texte R
		 */
		JLabel lettreR = new JLabel();
		lettreR.setText("R");
		lettreR.setSize(60,80);
		lettreR.setForeground(Color.black);		

		/**
		 * Texte M
		 */
		JLabel lettreM2 = new JLabel();
		lettreM2.setText("M");
		lettreM2.setSize(60,80);
		lettreM2.setForeground(Color.green);		

		/**
		 * Texte I
		 */
		JLabel lettreI = new JLabel();
		lettreI.setText("I");
		lettreI.setSize(60,80);
		lettreI.setForeground(Color.blue);		

		/**
		 * Texte N
		 */
		JLabel lettreN = new JLabel();
		lettreN.setText("N");
		lettreN.setSize(60,80);
		lettreN.setForeground(Color.orange);		

		/**
		 * Texte D
		 */
		JLabel lettreD = new JLabel();
		lettreD.setText("D");
		lettreD.setSize(60,80);
		lettreD.setForeground(Color.red);		
		
		/**
		 * Texte Mastermind
		 */
		JPanel lettreMastermind = new JPanel();
		lettreMastermind.setBounds(width/8,height/15,60*10,80);		
		lettreMastermind.setBackground(Color.white);
		lettreMastermind.add(lettreM);
		lettreMastermind.add(lettreA);
		lettreMastermind.add(lettreS);
		lettreMastermind.add(lettreT);
		lettreMastermind.add(lettreE);
		lettreMastermind.add(lettreR);
		lettreMastermind.add(lettreM2);
		lettreMastermind.add(lettreI);
		lettreMastermind.add(lettreN);
		lettreMastermind.add(lettreD);
		
		/**
		 * Panneau global
		 */
		JPanel panneauGlobal = new JPanel();
		panneauGlobal.setBounds(0,0,400,400);
		panneauGlobal.setLayout(null);
		panneauGlobal.setBackground(Color.white);
		this.add(panneauGlobal);
		panneauGlobal.add(lettreMastermind);
		
		
		/**
		 * Bouton Jouer
		 */
		Jouer = new JButton("Jouer");
		Jouer.setBounds(20,height/3,180,100);
	    Jouer.setBackground(Color.cyan);
		Jouer.setForeground(Color.white);
		/* branchement de l'�couteur*/
		Jouer.addActionListener(this);
		panneauGlobal.add(Jouer);
		
		/**
		 * Bouton Options
		 */
		Options = new JButton(" Options");
		Options.setBounds(210,height/3,180,100);
		Options.setBackground(Color.cyan);
		Options.setForeground(Color.white);
		/* branchement de l'�couteur*/
		Options.addActionListener(this);
		panneauGlobal.add(Options);
		
		/**
		 * Bouton Mode Ordinateur
		 */
		ModeOrdinateur = new JButton("ModeOrdinateur");
		ModeOrdinateur.setBounds(400,height/3,180,100);
		ModeOrdinateur.setBackground(Color.cyan);
		ModeOrdinateur.setForeground(Color.white);
		/* branchement de l'�couteur*/
		ModeOrdinateur.addActionListener(this);
		panneauGlobal.add(ModeOrdinateur);
		
		/**
		 * Bouton R�gles
		 */
		Regles = new JButton("Regles");
		Regles.setBounds(590,height/3,180,100);
		Regles.setBackground(Color.cyan);
		Regles.setForeground(Color.white);
		/* branchement de l'�couteur*/
		Regles.addActionListener(this);
		panneauGlobal.add(Regles);
		
		/**
		 * Bouton Tableau des scores
		 */
		scores = new JButton("Tableau des scores");
		scores.setBounds(width/3,height/2,300,70);
		scores.setBackground(Color.cyan);
		scores.setForeground(Color.white);
		/* branchement de l'�couteur*/
		scores.addActionListener(this);
		panneauGlobal.add(scores);
	
		
	
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}

