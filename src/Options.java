// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Options extends JFrame implements ActionListener {

	// Les Widgets � d�clarer en dehors du constructeur
        private JButton Scores;
        private JButton Settings;
    
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
		this.setVisible(true);
		
		/**
		 * Texte Option
		 */
		JLabel Option = new JLabel();
		Option.setBounds(350,height/20,350,50);
		Option.setText("Options");
		Option.setBackground(Color.GRAY);
		Option.setForeground(Color.blue);
		this.add(Option);
		/**
		 * Bouton Delete Scores
		 */
		Scores = new JButton(" DeleteScores");
		Scores.setBounds(width/8,500,150,50);
		Scores.setBackground(Color.blue);
		Scores.setForeground(Color.white);
		/* branchement de l'�couteur*/
		Scores.addActionListener(this);
		this.add(Scores);
		
		/**
		 * Bouton Reset Settings
		 */
		Settings = new JButton(" Reset Settings ");
		Settings.setBounds(width/8,570,150,50);
		Settings.setBackground(Color.blue);
		Settings.setForeground(Color.white);
		/* branchement de l'�couteur*/
		Settings.addActionListener(this);
		this.add(Settings);
		
		/**
		 * Texte1
		 */
		JLabel text1 = new JLabel();
		text1.setBounds(350,300,300,50);	
		text1.setText("Activer les aides dans le jeu ");
		text1.setBackground(Color.GRAY);
		text1.setForeground(Color.blue);
		this.add(text1);
		
		/**
		 * Texte2
		 */
		JLabel text2 = new JLabel();
		text2.setBounds(350,360,400,50);	
		text2.setText("Combinaison avec plus d'une fois la m�me couleur(Default False)");
		text2.setBackground(Color.GRAY);
		text2.setForeground(Color.blue);
		this.add(text2);
		
		/**
		 * Texte3
		 */
		JLabel text3 = new JLabel();
		text3.setBounds(350,420,300,50);	
		text3.setText("Nombre de couleurs disponibles(Default 8)");
		text3.setBackground(Color.GRAY);
		text3.setForeground(Color.blue);
		this.add(text3);
		
		/**
		 * Texte4
		 */
		JLabel text4 = new JLabel();
		text4 .setBounds(350,480,300,50);	
		text4 .setText("Nombre de couleurs par combinaison(Default 4)");
		text4 .setBackground(Color.GRAY);
		text4 .setForeground(Color.blue);
		this.add(text4);
		
		/**
		 * Panneau global
		 */
		JPanel panneauGlobal = new JPanel();
		panneauGlobal.setBounds(0,0,800,800);
		panneauGlobal.setLayout(null);
		panneauGlobal.setBackground(Color.white);
		this.add(panneauGlobal);
		
		
		
		
		
		
		
		
		
		
		
		
		

}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
}

}





