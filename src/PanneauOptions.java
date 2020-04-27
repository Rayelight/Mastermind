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
	
	static int nombreText=4;
	static int nombreBouton=2;
	static double pourcentageEspace =1.0/4.0;

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
		titreOption.setBackground(Color.blue);
		titreOption.setForeground(Color.white);	
		titreOption.setOpaque(true);


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

		//Titre Constrains
		layout.putConstraint(SpringLayout.NORTH, titreOption, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titreOption,0, SpringLayout.HORIZONTAL_CENTER, this);
		
		
		//Boutons Constrains
		BoutonContraints();
		//Text Constrains
		TextContraints();
		
		
		//Checkbox Constrains
		layout.putConstraint(SpringLayout.EAST, checkBoxAides,-70, SpringLayout.EAST, textOption[0]);
		layout.putConstraint(SpringLayout.EAST, checkBoxMultiColor, -70, SpringLayout.EAST, textOption[1]);
		
		
		//Sliders Constrains
		layout.putConstraint(SpringLayout.EAST, sliderNbrCouleurs,-70, SpringLayout.EAST, textOption[2]);
		layout.putConstraint(SpringLayout.EAST, sliderTailleCombi,-70, SpringLayout.EAST, textOption[3]);

	}
	public void TextContraints() {
		//			Text Constraints
		for(int i=0; i<nombreBouton; i++) {
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textOption[i], 2*textVgap(), SpringLayout.HORIZONTAL_CENTER, titreOption);
			layout.putConstraint(SpringLayout.NORTH, textOption[i], textHeight()*2, SpringLayout.NORTH, this);
		}
	}
		public void BoutonContraints() {
			//			Bouton Constraints
			for(int i=0; i<nombreBouton; i++) {
				layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, boutonOption[i], 0, SpringLayout.HORIZONTAL_CENTER, this);
				layout.putConstraint(SpringLayout.NORTH, boutonOption[i], textHeight()*8, SpringLayout.NORTH, titreOption);

			}
}
	//Distance Verticale entre les widgets
	public static int textVgap() {
		int vGap = (int) ((Mastermind.generalHeight()*2.0/3.0-textHeight()*4.0)/5.0);
		return vGap;

	}
	//Hauteur d'un bouton
	public static int textHeight() {
		int textHeight = textWidth()/4;
		return textHeight;

	}
	//Largeur d'un bouton
	public static int textWidth() {
		int textWidth = (Mastermind.generalWidth()-(nombreText+1)*textHgap())/nombreText;
		return textWidth;

	}
	//Distance Horizontale entre les boutons
	public static int textHgap() {
		int hGap = (int) (Mastermind.generalWidth()*pourcentageEspace/(pourcentageEspace*(nombreText+1)+nombreText));
		return hGap;

	}

	//Position de l'axe central vertical des boutons
	public static int textHbouton(int i) {
		int textHbouton = textHgap()+textWidth()/2+i*(textHgap()+textWidth()) ;
		return textHbouton;

	}


}

