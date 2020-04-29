// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Dimension;



@SuppressWarnings("serial")
public class PanneauOptions extends JPanel implements ActionListener, ChangeListener , ItemListener  {

	// Les Widgets � d�clarer en dehors du constructeur

	private JCheckBox checkBoxAides;
	private JCheckBox checkBoxMultiColor;
	private JButton boutonOption;
	static int nombreOption=5;
	private JLabel[] textOption = new JLabel[nombreOption];
	private JSlider sliderTailleCombi;
	private JSlider sliderNbrCouleurs;
	private JLabel titreOption;
	protected SpringLayout layout = new SpringLayout();
	private JComponent[] Compenant = new JComponent[nombreOption];
	


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
		boutonOption= boutonOption("Reset Settings");


		//	Creation des differents textes

		textOption[0] = textOption("Activer les aides dans le jeu");
		textOption[1] = textOption("Combinaison avec plus d'une fois la m�me couleur(Default False)");
		textOption[2] = textOption("Nombre de couleurs disponibles(Default 8)");
		textOption[3] = textOption("Nombre de couleurs par combinaison(Default 4)");
		textOption[4] = textOption("Permet de remettre les settings originaux");


		//Affichage du titre Options
		titreOption = new JLabel("Options") {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(9*Vgap(), 3*Vgap());

			}
		};
		titreOption.setBackground(Color.white);
		titreOption.setForeground(Color.red);	
		titreOption.setOpaque(true);
		titreOption.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				titreOption.setFont(new Font("Serif", Font.BOLD, Vgap()/2));
				titreOption.repaint();
			}
		});

		// Checkbox
		checkBoxAides = new JCheckBox("") {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(3*Hgap(), 2*Vgap());

			}
		};
		checkBoxAides.setSelected(false);
		checkBoxAides.addItemListener(this);
		checkBoxAides.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				checkBoxAides.setFont(new Font("Serif", Font.BOLD, Vgap()/2));
				checkBoxAides.repaint();
			}
		});
		
		checkBoxMultiColor = new JCheckBox("") {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(3*Hgap(), 2*Vgap());

			}
		};
		checkBoxMultiColor.setSelected(false);
		checkBoxMultiColor.addItemListener(this);
		checkBoxMultiColor.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				checkBoxMultiColor.setFont(new Font("Serif", Font.BOLD, Vgap()/2));
				checkBoxMultiColor.repaint();
			}
		});

		//Curseurs (nombre de couleurs disponibles)
		int min = 6;
		int max = 10;
		int init = 8; 
		
		sliderNbrCouleurs = new JSlider (JSlider.HORIZONTAL,min, max, init) {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(3*Hgap(), 2*Vgap());

			}
		};
		sliderNbrCouleurs.setMajorTickSpacing(2);
		sliderNbrCouleurs.setMinorTickSpacing(0);
		sliderNbrCouleurs.setSnapToTicks(true);
		sliderNbrCouleurs.setPaintTicks (true);
		sliderNbrCouleurs.setPaintLabels (true);
		sliderNbrCouleurs.addChangeListener(this);  
		sliderNbrCouleurs.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				sliderNbrCouleurs.setFont(new Font("Serif", Font.BOLD, Vgap()/2));
				sliderNbrCouleurs.repaint();
			}
		});


		//Curseurs ( nombre de couleurs par combinaison)
		int mini = 3;
		int maxi =6;
		int initi = 4;    
		
		sliderTailleCombi = new JSlider (JSlider.HORIZONTAL,mini, maxi, initi) {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(3*Hgap(), 2*Vgap());

			}
		};
		sliderTailleCombi.setMajorTickSpacing (1);
		sliderTailleCombi.setMinorTickSpacing(0);
		sliderTailleCombi.setSnapToTicks(true);
		sliderTailleCombi.setPaintTicks (true);
		sliderTailleCombi.setPaintLabels (true);
		sliderTailleCombi.addChangeListener(this); 
		sliderTailleCombi.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				sliderTailleCombi.setFont(new Font("Serif", Font.BOLD, Vgap()/2));
				sliderTailleCombi.repaint();
			}
		});
		

		//Tableau de JCompenant
		Compenant[0] = checkBoxAides;
		Compenant[1] = checkBoxMultiColor;
		Compenant[2] = sliderNbrCouleurs;
		Compenant[3] = sliderTailleCombi;
		Compenant[4] = boutonOption;


		//			Ajout Widgets
		this.add(boutonOption);
		this.add(textOption[0]);
		this.add(textOption[1]);
		this.add(textOption[2]);
		this.add(textOption[3]);
		this.add(textOption[4]);
		this.add(titreOption);
		this.add(checkBoxAides);
		this.add(checkBoxMultiColor);
		this.add(sliderNbrCouleurs);
		this.add(sliderTailleCombi);
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
		if(e.getSource()==boutonOption){
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
		bouton.setBackground(Color.white);
		bouton.setForeground(Color.red);
		bouton.addActionListener(this);

		return bouton;
	}

	//Création des textes 
	private JLabel textOption (String texte) {
		JLabel text = new JLabel(texte){

			@Override
			public Dimension getPreferredSize(){
				return new Dimension(Hgap()*8,Vgap()*2);
			}


		};
		text.setBackground(Color.blue);
		text.setForeground(Color.red);
		text.setOpaque(true);

		return text;
	}
	public void adjustContraints() {
		//			Adjust Constraints

		//Titre Constrains
		layout.putConstraint(SpringLayout.NORTH, titreOption, 2*Vgap(), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titreOption,0, SpringLayout.HORIZONTAL_CENTER, this);


		for(int i=0; i<nombreOption; i++) {
			//Horizontale Constrains
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, Compenant[i], (int)(2.5*Hgap()), SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.WEST, textOption[i],5*Hgap(), SpringLayout.WEST, this);

			//Verticale Constrains
			int posV = 2*Vgap()+3*i*Vgap();
			layout.putConstraint(SpringLayout.NORTH, Compenant[i], posV, SpringLayout.SOUTH, titreOption);
			layout.putConstraint(SpringLayout.NORTH, textOption[i], posV, SpringLayout.SOUTH, titreOption);
		}	
	}
	//Distance Verticale entre les widgets
	public static int Vgap() {
		int vGap = (int)Math.round ((Mastermind.generalHeight())/(3*nombreOption+11.0));
		return vGap;

	}
	//Distance Horizontale entre les widgets
	public static int Hgap() {
		int Hgap = (int)Math.round (Mastermind.generalWidth()/14.0);
		return Hgap;
	}
}

