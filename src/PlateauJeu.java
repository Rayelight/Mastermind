import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PlateauJeu extends JPanel implements ActionListener{


	SpringLayout layout;
	GrilleCouleurs grilleCouleurs;

	public PlateauJeu(){
		//			Panel Setup
		layout = new SpringLayout();
		this.setLayout(layout);
		this.setBackground(Color.red);
		
		//			Components creation
		grilleCouleurs = new GrilleCouleurs();
		
		//		Bien Placés
		//		Présents dans le code
		
		
		//			Adding components
		this.add(grilleCouleurs);
		
		
		
		
	}
	

	public void adjustContraints() {
		//			Adjust Constraints
		// 		grilleCouleurs Constrains
		layout.putConstraint(SpringLayout.NORTH, grilleCouleurs, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, grilleCouleurs, -20, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, grilleCouleurs, 0, SpringLayout.HORIZONTAL_CENTER, this);


	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}

