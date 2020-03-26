import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PlateauJeu extends ContraintsJPanel implements ActionListener{


	GrilleCouleurs grilleCouleurs;
	CarreEval carrePlacement;
	CarreEval carreValide;

	public PlateauJeu(){
		//			Panel Setup	
		this.setBackground(Color.red);
		
		//			Components creation
		grilleCouleurs = new GrilleCouleurs();
		carrePlacement = new CarreEval();
		carreValide = new CarreEval();
		
		
		//			Adding components
		this.add(grilleCouleurs);
		this.add(carrePlacement);
		this.add(carreValide);
		
		
		
		
	}
	

	public void adjustContraints() {
		//			Adjust Constraints
		// 		grilleCouleurs Constrains
		layout.putConstraint(SpringLayout.NORTH, grilleCouleurs, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, grilleCouleurs, -20, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, grilleCouleurs, 0, SpringLayout.HORIZONTAL_CENTER, this);

		// 		carreValide Constrains
		layout.putConstraint(SpringLayout.NORTH, carreValide, 25, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, carreValide, -25, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, carreValide, RoundButton.boutonRadius(), SpringLayout.WEST, grilleCouleurs);
		
		// 		carrePlacement Constrains
		layout.putConstraint(SpringLayout.NORTH, carrePlacement, 25, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, carrePlacement, -25, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, carrePlacement, RoundButton.boutonRadius(), SpringLayout.EAST, grilleCouleurs);
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension((int) (Mastermind.generalWidth()*0.7),Mastermind.generalHeight());
	}



}

