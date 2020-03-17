import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PlateauJeu extends JPanel implements ActionListener{


	SpringLayout layout;
	JPanel grilleCouleurs;

	public PlateauJeu(){
		//			Panel Setup
		layout = new SpringLayout();
		this.setLayout(layout);
		this.setBackground(Color.red);
		
		//			Components creation
		//		Grille Couleurs
		grilleCouleurs = new JPanel();
		//grilleCouleurs.setSize(new Dimension( Mastermind.general.getContentPane().getWidth()/4, Mastermind.general.getContentPane().getHeight()-80*2) );
		//grilleCouleurs.setLocation((Mastermind.general.getContentPane().getWidth()-grilleCouleurs.getWidth())/2,80);
		
		//grilleCouleurs.setLayout(new BoxLayout(grilleCouleurs, BoxLayout.PAGE_AXIS));
		//grilleCouleurs.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		grilleCouleurs.setLayout(new GridLayout(Mastermind.nbrTentatives,1));
		grilleCouleurs.setBackground(Color.yellow);

		Combinaison[] tentatives = new Combinaison[10];
		for(int i=0; i<10; i++) {
			grilleCouleurs.add(tentatives[i]=new Combinaison());

		}
		
		//		Bien Placés
		
		
		//		Présents dans le code
		
		
		//			Adding components
		this.add(grilleCouleurs);
		
		
		
		
	}
	

	public void adjustContraints() {
		//			Adjust Constraints
		// 		grilleCouleurs Constrains
		Insets insets = Mastermind.general.getInsets();
		int height = Mastermind.general.getHeight()-insets.top-insets.bottom;
		int grilleCouleursHeight = height-40;
		int boutonsRadius = (height-40-5*Mastermind.nbrTentatives)/Mastermind.nbrTentatives; 
		int grilleCouleursWidth = (boutonsRadius+5)*Mastermind.tailleCombinaison+5; 
		
		layout.putConstraint(SpringLayout.WEST, grilleCouleurs, -grilleCouleursWidth/2, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.EAST, grilleCouleurs, grilleCouleursWidth/2, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, grilleCouleurs, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, grilleCouleurs, -20, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, grilleCouleurs, 0, SpringLayout.HORIZONTAL_CENTER, this);


		
		//Mastermind.general.getWidth()/4

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}

