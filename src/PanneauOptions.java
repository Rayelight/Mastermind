// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




@SuppressWarnings("serial")
public class PanneauOptions extends JPanel implements ActionListener, ChangeListener , ItemListener  {

	// Les Widgets � d�clarer en dehors du constructeur

	private JCheckBox checkBoxAides;
	private JCheckBox checkBoxMultiColor;
	private JButton[] boutonOption = new JButton[2];
	private JLabel[] textOption = new JLabel[4];
	private JSlider sliderTailleCombi;
	private JSlider sliderNbrCouleurs;
	private JLabel titreOption;



	public PanneauOptions() {

		//Panneau global
		setLayout(null);
		setBackground(Color.white);


		//Boutons Option

		//	Creation Boutons
		boutonOption[0] = boutonOption("DeleteScores");
		boutonOption[0].setBounds(250,450,300,50);
		this.add(boutonOption[0]);

		boutonOption[1] = boutonOption("Reset Settings");
		boutonOption[1].setBounds(250,550,300,50);
		this.add(boutonOption[1]);

		// Texte Option


		//	Creation des differents textes
		textOption[0] = textOption("Activer les aides dans le jeu");
		textOption[0].setBounds(400,150,400,50);
		this.add(textOption[0]);

		textOption[1] = textOption("Combinaison avec plus d'une fois la m�me couleur(Default False)");
		textOption[1].setBounds(400,210,400,50);
		this.add(textOption[1]);

		textOption[2] = textOption("Nombre de couleurs disponibles(Default 8)");
		textOption[2].setBounds(400,270,400,50);
		this.add(textOption[2]);

		textOption[3] = textOption("Nombre de couleurs par combinaison(Default 4)");
		textOption[3].setBounds(400,330,400,50);
		this.add(textOption[3]);

		//Afiichage du titre Options

		titreOption= new JLabel("Options");
		titreOption.setBounds(350,20,600,100);
		titreOption.setBackground(Color.white);
		titreOption.setForeground(Color.blue);	
		this.add(titreOption);


		// Checkbox

		checkBoxAides = new JCheckBox("");
		checkBoxAides.setBounds(200,150, 50,50);
		checkBoxAides.setSelected(false);
		checkBoxAides.addItemListener(this);

		checkBoxMultiColor = new JCheckBox("");
		checkBoxMultiColor.setBounds(200,210, 50,50);
		checkBoxMultiColor.setSelected(false);
		checkBoxMultiColor.addItemListener(this);
		this.add(checkBoxAides);
		this.add(checkBoxMultiColor);

		//Curseurs (nombre de couleurs disponibles)
		int min = 6;
		int max = 10;
		int init = 8; 


		sliderNbrCouleurs = new JSlider (JSlider.HORIZONTAL,min, max, init);
		sliderNbrCouleurs.setMajorTickSpacing(2);
		sliderNbrCouleurs.setMinorTickSpacing(0);
		sliderNbrCouleurs.setSnapToTicks(true);
		sliderNbrCouleurs.setPaintTicks (true);
		sliderNbrCouleurs.setPaintLabels (true);
		sliderNbrCouleurs.setBounds(150,270, 150,50);
		sliderNbrCouleurs.addChangeListener(this);  
		this.add(sliderNbrCouleurs);



		//Curseurs ( nombre de couleurs par combinaison)
		int mini = 3;
		int maxi =6;
		int initi = 4;    



		sliderTailleCombi = new JSlider (JSlider.HORIZONTAL,mini, maxi, initi);
		sliderTailleCombi.setMajorTickSpacing (1);
		sliderTailleCombi.setMinorTickSpacing(0);
		sliderTailleCombi.setSnapToTicks(true);
		sliderTailleCombi.setPaintTicks (true);
		sliderTailleCombi.setPaintLabels (true);
		sliderTailleCombi.setBounds(150,330, 150,50);
		sliderTailleCombi.addChangeListener(this); 
		this.add(sliderTailleCombi);


	}


	public void itemStateChanged(ItemEvent event) {
		JCheckBox checkboxname=(JCheckBox)event.getSource();
		boolean valeur=checkboxname.isSelected();
		if(checkboxname==checkBoxMultiColor && valeur==true) {
			Mastermind.multiColor=true;
		}if(checkboxname==checkBoxMultiColor && valeur==false){
			Mastermind.multiColor=false;
		}if(checkboxname==checkBoxAides && valeur==true){
			//affichage du panneau regles
		}if(checkboxname==checkBoxAides && valeur==false){
			//enlever le panneau regles 
		}
	}


	public void stateChanged(ChangeEvent event) {
		JSlider sliderName = (JSlider)event.getSource();
		int valeur = sliderName.getValue();
		if(sliderName==sliderTailleCombi)
			Mastermind.tailleCombinaison=valeur;
		if(sliderName==sliderNbrCouleurs)
			Mastermind.nbrCouleurs=valeur;

	}       


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boutonOption[1]){
			sliderNbrCouleurs.setValue(8);
			sliderTailleCombi.setValue(4);
			sliderNbrCouleurs.paintAll(sliderNbrCouleurs.getGraphics());
			sliderTailleCombi.paintAll(sliderTailleCombi.getGraphics());
			checkBoxMultiColor.setSelected(false);
			checkBoxAides.setSelected(false);
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



