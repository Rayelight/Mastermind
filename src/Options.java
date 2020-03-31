// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings("serial")
public class Options extends JFrame implements ActionListener, ChangeListener  {

	// Les Widgets � d�clarer en dehors du constructeur

	private JCheckBox checkBox1;
	private JCheckBox checkBox2;
	private JButton[] boutonOption;
	private JLabel[] textOption;

	public Options() {

		this.setTitle("Jeu ");
		this.setSize(800,800);
		// Pour placer la fen�tre au centre de l'�cran
		this.setResizable(true);
		// Pour permettre la fermeture de la fen�tre lors de l'appui sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width=this.getWidth();
		int height=this.getHeight();


		//Panneau global

		JPanel panneauGlobal = new JPanel();
		panneauGlobal.setBounds(0,0,800,800);
		panneauGlobal.setLayout(null);
		panneauGlobal.setBackground(Color.white);
		this.add(panneauGlobal);

		//Boutons Option
		boutonOption = new JButton[2];

		//	Creation Boutons
		boutonOption[0] = boutonOption("DeleteScores");
		boutonOption[0].setBounds(250,450,300,50);
		panneauGlobal.add(boutonOption[0]);

		boutonOption[1] = boutonOption("Reset Settings");
		boutonOption[1].setBounds(250,550,300,50);
		panneauGlobal.add(boutonOption[1]);

		// Texte Option

		textOption = new JLabel[5];

		//	Creation des differents textes
		textOption[0] = textOption("Activer les aides dans le jeu");
		textOption[0].setBounds(400,150,300,50);
		panneauGlobal.add(textOption[0]);

		textOption[1] = textOption("Combinaison avec plus d'une fois la m�me couleur(Default False)");
		textOption[1].setBounds(400,210,400,50);
		panneauGlobal.add(textOption[1]);

		textOption[2] = textOption("Nombre de couleurs disponibles(Default 8)");
		textOption[2].setBounds(400,270,300,50);
		panneauGlobal.add(textOption[2]);

		textOption[3] = textOption("Nombre de couleurs par combinaison(Default 4)");
		textOption[3].setBounds(400,330,300,50);
		panneauGlobal.add(textOption[3]);

		textOption[4] = textOption("Options");
		textOption[4].setBounds(350,20,350,50);
		panneauGlobal.add(textOption[4]);


		// Checkbox

		JCheckBox checkBox1 = new JCheckBox("");
		checkBox1.setBounds(200,150, 50,50);
		JCheckBox checkBox2 = new JCheckBox("");
		checkBox2.setBounds(200,210, 50,50);
		panneauGlobal.add(checkBox1);
		panneauGlobal.add(checkBox2);

		//Curseurs ( nombre de couleurs disponibles)
		int min = 6;
		int max = 10;
		int init = 8; 

		JSlider slidercouleursdispo = new JSlider (JSlider.HORIZONTAL,min, max, init);
		slidercouleursdispo.setMajorTickSpacing(2);
		slidercouleursdispo.setMinorTickSpacing(0);
		slidercouleursdispo.setSnapToTicks(true);
		slidercouleursdispo.setPaintTicks (true);
		slidercouleursdispo.setPaintLabels (true);
		slidercouleursdispo.setBounds(150,270, 150,50);
		slidercouleursdispo.addChangeListener(this);  
		panneauGlobal.add(slidercouleursdispo);

		JSlider sliderNbrCouleurs = new JSlider (JSlider.HORIZONTAL,min, max, init);
		sliderNbrCouleurs.setMajorTickSpacing(2);
		sliderNbrCouleurs.setMinorTickSpacing(0);
		sliderNbrCouleurs.setSnapToTicks(true);
		sliderNbrCouleurs.setPaintTicks (true);
		sliderNbrCouleurs.setPaintLabels (true);
		sliderNbrCouleurs.setBounds(150,270, 150,50);
		sliderNbrCouleurs.addChangeListener(this);  
		panneauGlobal.add(sliderNbrCouleurs);


		//Curseurs ( nombre de couleurs par combinaison)
		int mini = 3;
		int maxi =6;
		int initi = 4;    

		JSlider slidercouleurscombi = new JSlider (JSlider.HORIZONTAL,mini, maxi, initi);
		slidercouleurscombi.setMajorTickSpacing (1);
		slidercouleurscombi.setMinorTickSpacing(0);
		slidercouleurscombi.setSnapToTicks(true);
		slidercouleurscombi.setPaintTicks (true);
		slidercouleurscombi.setPaintLabels (true);
		slidercouleurscombi.setBounds(150,330, 150,50);
		slidercouleurscombi.addChangeListener(this); 
		panneauGlobal.add(slidercouleurscombi);

		public void stateChanged(ChangeEvent event) {
			int valeur = ((JSlider) event.getSource()).getValue();
			
				Mastermind.nbrCouleurs=valeur;

		}       

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==checkBox1) {
				//affichage des aides
			}
			if(e.getSource()==checkBox2) {
				//possibilité de mettre 2 couleurs dans ses combinaisons 
			}
		}



		//Création des Boutons 
		private JButton boutonOption (String texte) {
			JButton bouton = new JButton(texte){
			};
			bouton.setBackground(Color.blue);
			bouton.setForeground(Color.white);
			bouton.addActionListener(this);

			return bouton;
		}

		//Création des textes 
		private JLabel textOption (String texte) {
			JLabel text = new JLabel(texte){
			};
			text.setBackground(Color.blue);
			text.setForeground(Color.white);
			text.setOpaque(true);;

			return text;
		}
	}



