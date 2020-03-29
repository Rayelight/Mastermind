// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JSlider;

@SuppressWarnings("serial")
public class Options extends JFrame implements ActionListener {

	// Les Widgets � d�clarer en dehors du constructeur
        private JButton Scores;
        private JButton Settings;
        private JCheckBox checkBox1;
        private JCheckBox checkBox2;

    
    public Options() {
    	 
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
		
		
		//Panneau global
		 
		JPanel panneauGlobal = new JPanel();
		panneauGlobal.setBounds(0,0,800,800);
		panneauGlobal.setLayout(null);
		panneauGlobal.setBackground(Color.white);
		this.add(panneauGlobal);
		
		// Texte Option
		 
		JLabel Option = new JLabel();
		Option.setBounds(350,height/20,350,50);
		Option.setText("Options");
		Option.setBackground(Color.GRAY);
		Option.setForeground(Color.blue);
		panneauGlobal.add(Option);
		
		//Bouton Delete Scores
		
		Scores = new JButton(" DeleteScores");
		Scores.setBounds(300,450,150,50);
		Scores.setBackground(Color.blue);
		Scores.setForeground(Color.white);
		/* branchement de l'�couteur*/
		Scores.addActionListener(this);
		panneauGlobal.add(Scores);
		
		//Bouton Reset Settings
		
		Settings = new JButton(" Reset Settings ");
		Settings.setBounds(300,520,150,50);
		Settings.setBackground(Color.blue);
		Settings.setForeground(Color.white);
		/* branchement de l'�couteur*/
		Settings.addActionListener(this);
		panneauGlobal.add(Settings);
		
	    //Texte1
		 
		JLabel text1 = new JLabel();
		text1.setBounds(400,150,300,50);	
		text1.setText("Activer les aides dans le jeu ");
		text1.setBackground(Color.GRAY);
		text1.setForeground(Color.blue);
		panneauGlobal.add(text1);
		
		//Texte2
		JLabel text2 = new JLabel();
		text2.setBounds(400,210,400,50);	
		text2.setText("Combinaison avec plus d'une fois la m�me couleur(Default False)");
		text2.setBackground(Color.GRAY);
		text2.setForeground(Color.blue);
		panneauGlobal.add(text2);
		
		//Texte3
		
		JLabel text3 = new JLabel();
		text3.setBounds(400,270,300,50);	
		text3.setText("Nombre de couleurs disponibles(Default 8)");
		text3.setBackground(Color.GRAY);
		text3.setForeground(Color.blue);
		panneauGlobal.add(text3);
		
		//Texte4
		
		JLabel text4 = new JLabel();
		text4 .setBounds(400,330,300,50);
		text4 .setText("Nombre de couleurs par combinaison(Default 4)");
		text4 .setBackground(Color.GRAY);
		text4 .setForeground(Color.blue);
		panneauGlobal.add(text4);
		

		
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
       slidercouleursdispo.setMajorTickSpacing (1);
       slidercouleursdispo.setPaintTicks (true);
       slidercouleursdispo.setPaintLabels (true);
       slidercouleursdispo.setBounds(150,270, 150,50);
       panneauGlobal.add(slidercouleursdispo);

        //Curseurs ( nombre de couleurs par combinaison)
         int mini = 2;
         int maxi =6;
         int initi = 4;    
        JSlider slidercouleurscombi = new JSlider (JSlider.HORIZONTAL,mini, maxi, initi);
        slidercouleurscombi.setMajorTickSpacing (1);
        slidercouleurscombi.setPaintTicks (true);
        slidercouleurscombi.setPaintLabels (true);
        slidercouleurscombi.setBounds(150,330, 150,50);
        panneauGlobal.add(slidercouleurscombi);
        
        
        slidercouleursdispo.addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent event) {
	        int valeur = slidercouleursdispo.getValue();
	        if (valeur == 6) {
	        	Mastermind.nbrCouleurs=6;
	        } else if (valeur == 7) {
	        	Mastermind.nbrCouleurs=7;
	        } else if (valeur == 8) {
	        	Mastermind.nbrCouleurs=8;
	        } else if  (valeur == 9){
	        	Mastermind.nbrCouleurs=9;
	        }else if  (valeur == 10) {
	        Mastermind.nbrCouleurs=10;
	        }
	        }
        });  
        
        slidercouleurscombi.addChangeListener(new ChangeListener() {
	      public void stateChanged(ChangeEvent event) {
	        int valeur = slidercouleurscombi.getValue();
	        if (valeur == 2) {
	          Mastermind.tailleCombinaison=2;
	        } else if (valeur == 3) {
	        	Mastermind.tailleCombinaison=3;
	        } else if (valeur == 4) {
	        	Mastermind.tailleCombinaison=4;
	        } else if(valeur == 5) {
	        	Mastermind.tailleCombinaison=5;
	        }else if (valeur == 6) {
	        	Mastermind.tailleCombinaison=6;	        
	        }
	      }
        }); 
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
	
}





