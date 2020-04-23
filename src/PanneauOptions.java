// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
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
	protected SpringLayout layout = new SpringLayout();
	

	public PanneauOptions() {

		//Panneau global
		setLayout(layout);
		setBackground(Color.white);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
			}
		});	

        //		Creation Widgets
		//Boutons Option
		boutonOption[0] = boutonOption("DeleteScores");
		boutonOption[1] = boutonOption("Reset Settings");
		
		
		//	Creation des differents textes
		textOption[0] = textOption("Activer les aides dans le jeu");
		textOption[1] = textOption("Combinaison avec plus d'une fois la m�me couleur(Default False)");
		textOption[2] = textOption("Nombre de couleurs disponibles(Default 8)");
		textOption[3] = textOption("Nombre de couleurs par combinaison(Default 4)");


		//Afiichage du titre Options
		titreOption= new JLabel("Options");
		titreOption.setBackground(Color.white);
		titreOption.setForeground(Color.blue);	


		// Checkbox
		checkBoxAides = new JCheckBox("");
		checkBoxAides.setSelected(false);
		checkBoxAides.addItemListener(this);

		checkBoxMultiColor = new JCheckBox("");
		checkBoxMultiColor.setSelected(false);
		checkBoxMultiColor.addItemListener(this);
		

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
		sliderNbrCouleurs.addChangeListener(this);  


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
		sliderTailleCombi.addChangeListener(this); 


		//			Ajout Widgets
		this.add(boutonOption[0]);
		this.add(boutonOption[1]);
		this.add(textOption[0]);
		this.add(textOption[1]);
		this.add(textOption[2]);
		this.add(textOption[3]);
		this.add(titreOption);
		this.add(checkBoxAides);
		this.add(checkBoxMultiColor);
		this.add(sliderNbrCouleurs);
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
	public void adjustContraints() {
		//			Adjust Constraints

		//Boutons Constrains
		layout.putConstraint(SpringLayout.NORTH,  boutonOption[0], 100, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, boutonOption[0], -200,SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, boutonOption[0], 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		layout.putConstraint(SpringLayout.NORTH, boutonOption[1], 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH,  boutonOption[1], -50, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST,  boutonOption[1], 70, SpringLayout.WEST, this);
		
		
		//Text Constrains
		layout.putConstraint(SpringLayout.NORTH, textOption[0], 280, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, textOption[0], -50, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, textOption[0], -70, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH, textOption[1], 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, textOption[1], -130, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, textOption[1], 30, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, textOption[2], 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, textOption[2], -130, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textOption[2], 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.WEST, textOption[2], 150, SpringLayout.WEST, this);
		
		layout.putConstraint(SpringLayout.NORTH, textOption[3], 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, textOption[3], -130, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, textOption[3],-30, SpringLayout.EAST, this);

		
		//Titre Constrains
		layout.putConstraint(SpringLayout.NORTH, titreOption, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, titreOption, -130, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, titreOption,-30, SpringLayout.EAST, this);
		
		
		//Checkbox Constrains
		layout.putConstraint(SpringLayout.NORTH, checkBoxAides, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, checkBoxAides, -130, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, checkBoxAides,-30, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH, checkBoxMultiColor, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, checkBoxMultiColor, -130, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, checkBoxMultiColor,-30, SpringLayout.EAST, this);
		
		
		//Sliders Constrains
		layout.putConstraint(SpringLayout.NORTH, sliderNbrCouleurs, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, sliderNbrCouleurs, -130, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, sliderNbrCouleurs,-30, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH, sliderTailleCombi, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, sliderTailleCombi, -130, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, sliderTailleCombi,-30, SpringLayout.EAST, this);

	}
}



