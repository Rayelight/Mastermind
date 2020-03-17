// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel; 

@SuppressWarnings("serial")
public class PanneauAccueil extends JPanel implements ActionListener {

	private static final float CENTRAL_ALIGNMENT = 0;
	private JButton jouer;
	private JButton options;
	private JButton modeOrdinateur;
	private JButton regles;
	private JButton scores;
	
	static int nombreBoutons=4;
	static double pourcentageEspace =1/8;
	
	
	public PanneauAccueil() {
		
		int width=Mastermind.general.getWidth();
		int height=Mastermind.general.getHeight();


		this.setLayout(null);
		this.setBackground(Color.white);
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));




		String titreMastermind = new String();
		int taille =20;
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

		JLabel titre = new JLabel(titreMastermind, JLabel.CENTER);   
	    titre.setFont(new Font("Serif", Font.PLAIN, 120));
		titre.setBounds(width/2,height/20,60*5,100);
		titre.setAlignmentX(CENTRAL_ALIGNMENT);
		titre.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(titre);

		

		 //		Boutons centraux
		
		jouer = new BoutonAccueil("Jouer");

		options = new BoutonAccueil("Options");

		modeOrdinateur = new BoutonAccueil("ModeOrdinateur");

		regles = new BoutonAccueil("Règles");


		//		Bouton Scores

		scores = new BoutonAccueil("Tableau des scores");
		scores.setBounds(width/3,height/2,300,70);
		
		
		Box boutons = Box.createHorizontalBox();

	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}


}

