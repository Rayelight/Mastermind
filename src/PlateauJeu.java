import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PlateauJeu extends GradientPanel implements ActionListener{


	protected GrilleCouleurs grilleCouleurs;
	CarreEval carrePlacement;
	CarreEval carrePresence;
	
	
	public PlateauJeu(){
		
		//			Panel Setup	
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, borderColor));
		
		
		//			Components creation
		grilleCouleurs = new GrilleCouleurs();
		carrePlacement = new CarreEval(true);
		carrePresence = new CarreEval(false);


		//			Adding components
		this.add(grilleCouleurs);
		this.add(carrePlacement);
		this.add(carrePresence);

		adjustContraints();

	}


	public void adjustContraints() {
		//			Adjust Constraints
		// 		grilleCouleurs Constrains
		layout.putConstraint(SpringLayout.NORTH, grilleCouleurs, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, grilleCouleurs, -20, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, grilleCouleurs, 0, SpringLayout.HORIZONTAL_CENTER, this);

		// 		carrePresence Constrains
		layout.putConstraint(SpringLayout.NORTH, carrePresence, 25, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, carrePresence, -25, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, carrePresence, -RoundButton.boutonRadius(), SpringLayout.WEST, grilleCouleurs);

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
		return new Dimension(gameWidth(),Mastermind.generalHeight());
	}
	
	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
	
	
	public static int gameWidth(){
		int width = (int) Math.round(Mastermind.generalWidth()*0.68);  
		return width;

	}


}

