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
		 * Panneau global
		 */
		JPanel panneauGlobal = new JPanel();
		panneauGlobal.setBounds(0,0,400,400);
		panneauGlobal.setLayout(null);
		panneauGlobal.setBackground(Color.white);
		this.add(panneauGlobal);




		String titreMastermind = new String();
		int taille =10;
		titreMastermind += "<html><font size='"+taille+"' color=red>M</font>";
		titreMastermind += "<font size='"+taille+"' color=orange>A</font>";
		titreMastermind += "<font size='"+taille+"' color=yellow>S</font>";
		titreMastermind += "<font size='"+taille+"' color=lime>T</font>";
		titreMastermind += "<font size='"+taille+"' color=green>E</font>";
		titreMastermind += "<font size='"+taille+"' color=navy>R</font>";
		titreMastermind += "<font size='"+taille+"' color=blue>M</font>";
		titreMastermind += "<font size='"+taille+"' color=aqua>I</font>";
		titreMastermind += "<font size='"+taille+"' color=purple>N</font>";
		titreMastermind += "<font size='"+taille+"' color=fucshia>D</font></html>";

		JLabel titre = new JLabel(titreMastermind);
		titre.setBounds(width/8,height/15,60*10,80);
		panneauGlobal.add(titre);


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

