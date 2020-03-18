// Chargement des biblioth�ques Swing et AWT
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel; 

@SuppressWarnings("serial")
public class PanneauAccueil extends JPanel implements ActionListener {

	private static final float CENTRAL_ALIGNMENT = 0;
	private JButton[] boutonsAccueil;
	private JButton scores;
	
	static int nombreBoutons=4;
	static double pourcentageEspace =1/8;
	
	
	public PanneauAccueil() {
		
		int width=Mastermind.general.getWidth();
		int height=Mastermind.general.getHeight();


		this.setLayout(null);
		this.setBackground(Color.white);
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));




		String titreMastermind = new String();
		int taille =20;
		titreMastermind += "<html><font size='"+taille+"' color=red>M</font>";
		titreMastermind += "<font size='"+taille+"' color=orange>A</font>";
		titreMastermind += "<font size='"+taille+"' color=yellow>S</font>";
		titreMastermind += "<font size='"+taille+"' color=lime>T</font>";
		titreMastermind += "<font size='"+taille+"' color=green>E</font>";
		titreMastermind += "<font size='"+taille+"' color=navy>R</font>";
		titreMastermind += "<font size='"+taille+"' color=blue>M</font>";
		titreMastermind += "<font size='"+taille+"' color=aqua>I</font>";
		titreMastermind += "<font size='"+taille+"' color=purple>N</font>";
		titreMastermind += "<font size='"+taille+"' color=fucshia>D</font></html>";

		JLabel titre = new JLabel(titreMastermind, JLabel.CENTER);   
	    titre.setFont(new Font("Serif", Font.PLAIN, 120));
		titre.setBounds(width/2,height/20,60*5,100);
		titre.setAlignmentX(CENTRAL_ALIGNMENT);
		titre.setBorder(BorderFactory.createLineBorder(Color.black));
		this.add(titre);

		

		boutonsAccueil = new JButton[PanneauAccueil.nombreBoutons];
		
		 //		Boutons centraux
		boutonsAccueil[0] = boutonAccueil("Jouer");
		boutonsAccueil[1] = boutonAccueil("Options");
		boutonsAccueil[2] = boutonAccueil("Mode Ordinateur");
		boutonsAccueil[3] = boutonAccueil("Règles");
		
		//		Box Boutons centreaux
		Box boutons = Box.createHorizontalBox();
		boutons.setLayout(new FlowLayout() {
			@Override
			public int getHgap(){
				Insets insets = Mastermind.general.getInsets();
	    		int width = Mastermind.general.getWidth()-insets.right-insets.left;
	    		int boutonWidth = (int) (width/(PanneauAccueil.nombreBoutons*(1+PanneauAccueil.pourcentageEspace)+PanneauAccueil.pourcentageEspace));
	    		return boutonWidth/8;
			}
			
			@Override
			public int getVgap(){
	    		return 0;
			}
		});
		
		
		//		Ajout des boutons centreaux
		for(JButton b : boutonsAccueil) {
			boutons.add(b);
			b.addActionListener(this);
		}
		

		//		Bouton Scores

		scores = boutonAccueil("Tableau des scores");
		scores.setBounds(width/3,height/2,300,70);
		
		
		

	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	private JButton boutonAccueil(String texte) {
	    JButton bouton = new JButton(texte){
	    	@Override
	    	public Dimension getPreferredSize(){
	    		Insets insets = Mastermind.general.getInsets();
	    		int width = Mastermind.general.getWidth()-insets.right-insets.left;
	    		int boutonWidth = (int) (width/(PanneauAccueil.nombreBoutons*(1+PanneauAccueil.pourcentageEspace)+PanneauAccueil.pourcentageEspace));
	    		
	    		
	    		return new Dimension(boutonWidth,50);

	    	}
        };
        bouton.setBackground(Color.cyan);
		bouton.setForeground(Color.white);
	    
		return bouton;
	}
	


}

