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
		int width=this.getWidth();
		int height=this.getHeight();



		/**
		 * Texte M
		 */
		JLabel lettreM = new JLabel();
		lettreM.setText("M");
		lettreM.setSize(30,40);
		lettreM.setForeground(Color.red);		


		/**
		 * Texte A
		 */
		JLabel lettreA = new JLabel();
		lettreA.setText("A");
		lettreA.setSize(30,40);
		lettreA.setForeground(Color.orange);		

		/**
		 * Texte S
		 */
		JLabel lettreS = new JLabel();
		lettreS.setText("S");
		lettreS.setSize(30,40);
		lettreS.setForeground(Color.yellow);		

		/**
		 * Texte T
		 */
		JLabel lettreT = new JLabel();
		lettreT.setText("T");
		lettreT.setSize(30,40);
		lettreT.setForeground(Color.green);		

		/**
		 * Texte E
		 */
		JLabel lettreE = new JLabel();
		lettreE.setText("E");
		lettreE.setSize(30,40);
		lettreE.setForeground(Color.black);		

		/**
		 * Texte R
		 */
		JLabel lettreR = new JLabel();
		lettreR.setText("R");
		lettreR.setSize(30,40);
		lettreR.setForeground(Color.black);		

		/**
		 * Texte M
		 */
		JLabel lettreM2 = new JLabel();
		lettreM2.setText("M");
		lettreM2.setSize(30,40);
		lettreM2.setForeground(Color.green);		

		/**
		 * Texte I
		 */
		JLabel lettreI = new JLabel();
		lettreI.setText("I");
		lettreI.setSize(30,40);
		lettreI.setForeground(Color.yellow);		

		/**
		 * Texte N
		 */
		JLabel lettreN = new JLabel();
		lettreN.setText("N");
		lettreN.setSize(30,40);
		lettreN.setForeground(Color.orange);		

		/**
		 * Texte D
		 */
		JLabel lettreD = new JLabel();
		lettreD.setText("D");
		lettreD.setSize(30,40);
		lettreD.setForeground(Color.red);		

		/**
		 * Texte Mastermind
		 */
		JPanel lettreMastermind = new JPanel();
		lettreMastermind.setBounds(width/2,height/15,30*10,40);		
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
		panneauGlobal.setBackground(Color.orange);
		this.add(panneauGlobal);
		panneauGlobal.add(lettreMastermind);


		/**
		 * Bouton Jouer
		 */
		Jouer = new JButton("Jouer");
		Jouer.setBounds(20,height/3,180,100);
		Jouer.setBackground(Color.cyan);
		Jouer.setForeground(Color.white);
		/* branchement de l'écouteur*/
		Jouer.addActionListener(this);
		panneauGlobal.add(Jouer);

		/**
		 * Bouton Options
		 */
		Options = new JButton(" Options");
		Options.setBounds(210,height/3,180,100);
		Options.setBackground(Color.cyan);
		Options.setForeground(Color.white);
		/* branchement de l'écouteur*/
		Options.addActionListener(this);
		panneauGlobal.add(Options);

		/**
		 * Bouton Mode Ordinateur
		 */
		ModeOrdinateur = new JButton("ModeOrdinateur");
		ModeOrdinateur.setBounds(400,height/3,180,100);
		ModeOrdinateur.setBackground(Color.cyan);
		ModeOrdinateur.setForeground(Color.white);
		/* branchement de l'écouteur*/
		ModeOrdinateur.addActionListener(this);
		panneauGlobal.add(ModeOrdinateur);

		/**
		 * Bouton Règles
		 */
		Regles = new JButton("Regles");
		Regles.setBounds(590,height/3,180,100);
		Regles.setBackground(Color.cyan);
		Regles.setForeground(Color.white);
		/* branchement de l'écouteur*/
		Regles.addActionListener(this);
		panneauGlobal.add(Regles);

		/**
		 * Bouton Tableau des scores
		 */
		scores = new JButton("Tableau des scores");
		scores.setBounds(width/3,height/2,300,70);
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