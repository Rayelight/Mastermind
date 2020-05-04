// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;


@SuppressWarnings("serial")
public class PanneauAccueil extends GradientPanel implements ActionListener{

	private JLabel titre;
	private JButton[] boutonsAccueil;
	private JButton credits;


	static int nombreBoutons=4;
	static double pourcentageEspace =1.0/4.0;




	public PanneauAccueil() {

		//			Boxes Creation

		//		Titre
		String titreMastermind = new String();
		titreMastermind += "<html>";
		titreMastermind += "<font color=red>M</font>";
		titreMastermind += "<font color=orange>A</font>";
		titreMastermind += "<font color=yellow>S</font>";
		titreMastermind += "<font color=lime>T</font>";
		titreMastermind += "<font color=green>E</font>";
		titreMastermind += "<font color=navy>R</font>";
		titreMastermind += "<font color=blue>M</font>";
		titreMastermind += "<font color=aqua>I</font>";
		titreMastermind += "<font color=purple>N</font>";
		titreMastermind += "<font color=fucshia>D</font>";
		titreMastermind +="</html>";

		titre = new JLabel(titreMastermind, JLabel.CENTER){

			@Override
			public Dimension getPreferredSize(){
				return new Dimension(boutonWidth()*2,boutonHeight()*3/2);
			}

			protected void paintComponent(Graphics grphcs) {
				 Color borderColor= Mastermind.darkMode?Color.decode("#484321"):Color.black;
				this.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, borderColor));
				
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);
		        g2d.setColor(Color.decode("#D3CEBA"));
		        if(Mastermind.darkMode)
		        	g2d.fillRect(0, 0, getWidth(), getHeight()); 
				
				super.paintComponent(grphcs);
			}

		};
		titre.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				titre.setFont(new Font("Serif", Font.PLAIN, boutonHeight()));
				titre.repaint();
			}
		});

	



		//		BoutonsAccueil
		boutonsAccueil = new JButton[nombreBoutons];

		//	Creation Boutons
		boutonsAccueil[0] = boutonAccueil("Jouer");
		boutonsAccueil[1] = boutonAccueil("Options");
		boutonsAccueil[2] = boutonAccueil("Mode Ordinateur");
		boutonsAccueil[3] = boutonAccueil("Règles");




		//		Bouton credits
		credits = new GradientButton("Credits"){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(boutonWidth()*3/2,boutonHeight());
			}
		};
		credits.addActionListener(this);
		credits.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				credits.setFont(new Font("Serif", Font.BOLD, boutonHeight()/2));
				credits.repaint();
			}
		});



		//				Layout construction
		this.add(titre);
		//		Ajout des boutons centreaux
		for(JButton b : boutonsAccueil) {
			this.add(b);
		}
		this.add(credits);

		adjustContraints();
	}




	public void actionPerformed(ActionEvent e) {
		//	Jouer
		if(e.getSource()==boutonsAccueil[0]) {
			Mastermind.setPanneauJeu();
		}
		//	Options
		if(e.getSource()==boutonsAccueil[1]) {
			Mastermind.setPanneauOption(); 
		}
		//	Mode Ordinateur
		if(e.getSource()==boutonsAccueil[2]) {
			Mastermind.setPanneauJeu();
			Mastermind.panneauJeu.lancerOrdi();
			Mastermind.panneauJeu.tacheOrdi();
		}
		//	Regles
		if(e.getSource()==boutonsAccueil[3]) {
			new Regles();
		}
		//	Credits
		if(e.getSource()==credits) {
			//affichage tableau des credits
		}
	}



	//Création des Boutons et paramétrisation
	private JButton boutonAccueil(String texte) {
		JButton bouton = new GradientButton(texte){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(boutonWidth(), boutonHeight());
			}
		};
		bouton.addActionListener(this);

		return bouton;
	}

	//Hauteur d'un bouton
	public static int boutonHeight() {
		int boutonHeight = boutonWidth()/4;
		return boutonHeight;

	}

	//Largeur d'un bouton
	public static int boutonWidth() {
		int boutonWidth = (Mastermind.generalWidth()-(nombreBoutons+1)*boutonsHgap())/nombreBoutons;
		return boutonWidth;

	}


	//Position de l'axe central vertical des boutons
	public static int centreHbouton(int i) {
		int centreHbouton = boutonsHgap()+boutonWidth()/2+i*(boutonsHgap()+boutonWidth()) ;
		return centreHbouton;

	}


	//Distance Horizontale entre les boutons
	public static int boutonsHgap() {
		int hGap = (int) (Mastermind.generalWidth()*pourcentageEspace/(pourcentageEspace*(nombreBoutons+1)+nombreBoutons));
		return hGap;

	}

	//Distance Verticale entre les widgets
	public static int boutonsVgap() {
		int vGap = (int) ((Mastermind.generalHeight()*3.0/4.0-boutonHeight()*4.0)/5.0);
		return vGap;

	}



	public void adjustContraints() {
		//			Adjust Constraints
		// 		Titre
		layout.putConstraint(SpringLayout.NORTH, titre, boutonsVgap(), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titre, 0, SpringLayout.HORIZONTAL_CENTER, this);

		//		Boutons Centreaux
		boutonsContraints();

		// 		Bouton Score
		layout.putConstraint(SpringLayout.NORTH, credits, boutonsVgap()*2, SpringLayout.SOUTH, boutonsAccueil[0]);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, credits, 0, SpringLayout.HORIZONTAL_CENTER, this);


	}

	public void boutonsContraints() {
		//			Boutons Constraints
		for(int i=0; i<nombreBoutons; i++) {
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, boutonsAccueil[i], centreHbouton(i), SpringLayout.WEST, this);
			//System.out.println(i*Mastermind.generalWidth()/(nombreBoutons+1));
			layout.putConstraint(SpringLayout.NORTH, boutonsAccueil[i], boutonsVgap()*2, SpringLayout.SOUTH, titre);
		}

	}




}

