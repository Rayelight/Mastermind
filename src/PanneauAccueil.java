// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout; 

@SuppressWarnings("serial")
public class PanneauAccueil extends JPanel implements ActionListener {

	private JLabel titre;
	private JButton[] boutonsAccueil;
	private JButton scores;
	private JPanel boutons;
	private SpringLayout layout;

	static int nombreBoutons=4;
	static double pourcentageEspace =1.0/8.0;


	public PanneauAccueil() {

		layout = new SpringLayout();
		this.setLayout(layout);
		this.setBackground(Color.white);


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
				return new Dimension(boutonWidth()*2,boutonHeight());
			}
		};   
		titre.setFont(new Font("Serif", Font.PLAIN, 50));
		titre.setBorder(BorderFactory.createLineBorder(Color.black));


		//		BoutonsAccueil
		boutonsAccueil = new JButton[nombreBoutons];

		//	Creation Boutons
		boutonsAccueil[0] = boutonAccueil("Jouer");
		boutonsAccueil[1] = boutonAccueil("Options");
		boutonsAccueil[2] = boutonAccueil("Mode Ordinateur");
		boutonsAccueil[3] = boutonAccueil("Règles");

		//	Box Boutons centreaux
		boutons = new JPanel() {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(Mastermind.generalWidth(), boutonHeight());
			}
		};
		boutons.setLayout(new FlowLayout(FlowLayout.CENTER));


		//	Ajout des boutons centreaux
		for(JButton b : boutonsAccueil) {
			boutons.add(b);
		}


		//		Bouton Scores
		scores = new JButton("Tableau des Scores"){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(boutonWidth()*2,boutonHeight());
			}
		};
		scores.setBackground(Color.cyan);
		scores.setForeground(Color.white);
		scores.addActionListener(this);




		//				Layout construction
		this.add(titre);
		this.add(boutons);
		this.add(scores);



	}




	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==boutonsAccueil[0]) {
			plateaujeu= new Plateaujeu();
			this.setVisible(true);
		}
		if(e.getSource()==boutonsAccueil[1]) {
			options= new Options();
			this.setVisible(true);
		}
		if(e.getSource()==boutonsAccueil[2]) {
			//affichage mode oridnateur 
		}
		if(e.getSource()==boutonsAccueil[3]) {
			//affichage mode regles 
		}
		if(e.getSource()==scores) {
			//affichage tableau des scores
	}

		
		
	private JButton boutonAccueil(String texte) {
		JButton bouton = new JButton(texte){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(boutonWidth(), boutonHeight());
			}
		};
		bouton.setBackground(Color.cyan);
		bouton.setForeground(Color.white);
		bouton.addActionListener(this);

		return bouton;
	}

	public static int boutonHeight() {
		int boutonHeight = ((Mastermind.generalHeight()*2/3)-50-100-100)/4;
		return boutonHeight;

	}

	public static int boutonWidth() {
		int boutonWidth = (int) (Mastermind.generalWidth()/(nombreBoutons*(1+pourcentageEspace)+pourcentageEspace))-30;
		return boutonWidth;

	}
	
	public void adjustContraints() {
		//			Adjust Constraints
		// 		Titre
		layout.putConstraint(SpringLayout.NORTH, titre, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titre, 0, SpringLayout.HORIZONTAL_CENTER, this);

		// 		Boutons Centreaux
		layout.putConstraint(SpringLayout.NORTH, boutons, 100, SpringLayout.SOUTH, titre);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, boutons, 0, SpringLayout.HORIZONTAL_CENTER, this);

		// 		Bouton Score
		layout.putConstraint(SpringLayout.NORTH, scores, 100, SpringLayout.SOUTH, boutons);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, scores, 0, SpringLayout.HORIZONTAL_CENTER, this);
		

	}


	public void resizeLayoutHgap() {
		int hGap = (int) (boutonWidth()*pourcentageEspace);
		((FlowLayout) boutons.getLayout()).setHgap(hGap);

	}

}

