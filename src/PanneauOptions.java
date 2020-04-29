// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.Dimension;
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



@SuppressWarnings("serial")
public class PanneauOptions extends JPanel implements ActionListener, ChangeListener , ItemListener  {
	
	protected SpringLayout layout = new SpringLayout();
	
	private JLabel titreOption;
	
	private int nbrOptions=5;
	private JComponent[] options = new JComponent[nbrOptions];
	private JLabel[] labelOption = new JLabel[nbrOptions];
	
	private JCheckBox checkBoxAides;
	private JCheckBox checkBoxMultiColor;
	private JSlider sliderTailleCombi;
	private JSlider sliderNbrCouleurs;
	private JButton boutonOption;

	



	public PanneauOptions() {
		//			Panneau global
		setLayout(layout);
		setBackground(Color.white);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
			}
		});	




		//			Creation Widgets


		//		Titre Options
		titreOption = new JLabel("Options") {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(9*Vgap(), 3*Vgap());

			}
		};
		titreOption.setBackground(Color.blue);
		titreOption.setForeground(Color.red);	
		titreOption.setOpaque(true);
		titreOption.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				titreOption.setFont(new Font("Serif", Font.BOLD, Vgap()/2));
				titreOption.repaint();
			}
		});


		//		Options
		checkBoxAides = checkBoxOption();
		checkBoxMultiColor = checkBoxOption();
		sliderNbrCouleurs = sliderOption(6, 10, 8, 0, 2);
		sliderTailleCombi = sliderOption(3, 6, 4, 0, 1);
		boutonOption= boutonOption("Reset Settings");

		//		Tableau options
		options[0] = checkBoxAides;
		options[1] = checkBoxMultiColor;
		options[2] = sliderNbrCouleurs;
		options[3] = sliderTailleCombi;
		options[4] = boutonOption;

		//		Labels Options

		labelOption[0] = labelOption("Activer les aides dans le jeu");
		labelOption[1] = labelOption("Combinaison avec plus d'une fois la m�me couleur(Default False)");
		labelOption[2] = labelOption("Nombre de couleurs disponibles(Default 8)");
		labelOption[3] = labelOption("Nombre de couleurs par combinaison(Default 4)");
		labelOption[4] = labelOption("Permet de remettre les settings originaux");




		//			Ajout Widgets
		//		Titre
		this.add(titreOption);

		//		Components et Labels
		for(int i=0; i<nbrOptions; i++) {
			this.add(options[i]);
			this.add(labelOption[i]);
		}


	}

	//			Création des composants

	//		Création des JCheckBox
	private JCheckBox checkBoxOption() {
		JCheckBox checkBox = new JCheckBox() {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(2*Vgap(), 2*Vgap());

			}
		};
		checkBox.setSelected(false);
		checkBox.addItemListener(this);
		checkBox.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				checkBox.setFont(new Font("Serif", Font.BOLD, Vgap()/2));
				checkBox.repaint();
			}
		});

		return checkBox;
	}

	//		Création des JSlider
	private JSlider sliderOption (int min, int max, int init, int minorTick, int majorTick ) {

		JSlider slider = new JSlider (JSlider.HORIZONTAL, min, max, init) {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(3*Hgap(), 2*Vgap());

			}
		};

		slider.setMinorTickSpacing(minorTick);
		slider.setMajorTickSpacing (majorTick);
		slider.setSnapToTicks(true);
		slider.setPaintTicks (true);
		slider.setPaintLabels (true);
		slider.addChangeListener(this); 
		slider.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				slider.setFont(new Font("Serif", Font.BOLD, Vgap()/2));
				slider.repaint();
			}
		});

		return slider;
	}


	//		Création des JButton
	private JButton boutonOption(String texte) {
		JButton bouton = new JButton(texte){

			@Override
			public Dimension getPreferredSize(){
				return new Dimension(Vgap()*6,Vgap()*2);
			}
		};
		bouton.setBackground(Color.white);
		bouton.setForeground(Color.red);
		bouton.addActionListener(this);

		return bouton;
	}

	//		Création des JLabels
	private JLabel labelOption (String texte) {
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



	//			Listener des Composants

	//		ItemListener
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


	//		stateListener
	public void stateChanged(ChangeEvent event) {
		JSlider sliderName = (JSlider)event.getSource();
		int valeur = sliderName.getValue();
		if(sliderName==sliderTailleCombi)
			Mastermind.tailleCombinaison=valeur;
		if(sliderName==sliderNbrCouleurs)
			Mastermind.nbrCouleurs=valeur;

	}       


	//		actionListener
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

	//			Tailles Dynamiques
	//		Adjust Constraints
	public void adjustContraints() {
		//Titre Constrains
		layout.putConstraint(SpringLayout.NORTH, titreOption, 2*Vgap(), SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titreOption,0, SpringLayout.HORIZONTAL_CENTER, this);


		for(int i=0; i<nbrOptions; i++) {
			//Horizontale Constrains
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, options[i], (int)(2.5*Hgap()), SpringLayout.WEST, this);
			layout.putConstraint(SpringLayout.WEST, labelOption[i],5*Hgap(), SpringLayout.WEST, this);

			//Verticale Constrains
			int posV = 2*Vgap()+3*i*Vgap();
			layout.putConstraint(SpringLayout.NORTH, options[i], posV, SpringLayout.SOUTH, titreOption);
			layout.putConstraint(SpringLayout.NORTH, labelOption[i], posV, SpringLayout.SOUTH, titreOption);
		}	
	}
	
	//		Distance Verticale entre les widgets
	public int Vgap() {
		int vGap = (int)Math.round ((Mastermind.generalHeight())/(3*nbrOptions+11.0));
		return vGap;

	}
	
	//		Distance Horizontale entre les widgets
	public int Hgap() {
		int Hgap = (int)Math.round (Mastermind.generalWidth()/14.0);
		return Hgap;
	}
}

