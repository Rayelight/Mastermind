import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class GrilleCouleurs  extends JPanel{


	public GrilleCouleurs() {
		//grilleCouleurs.setLayout(new BoxLayout(grilleCouleurs, BoxLayout.PAGE_AXIS));
		//grilleCouleurs.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setLayout(new GridLayout(Mastermind.nbrTentatives,1));
		this.setBackground(Color.yellow);

		Combinaison[] tentatives = new Combinaison[10];
		for(int i=0; i<10; i++) {
			this.add(tentatives[i]=new Combinaison());

		}
	}

	@Override
	public Dimension getPreferredSize(){
		Insets insets = Mastermind.general.getInsets();
		int height = Mastermind.general.getHeight()-insets.top-insets.bottom;
		int grilleCouleursHeight = height-40;
		int boutonsRadius = (height-40-5*Mastermind.nbrTentatives)/Mastermind.nbrTentatives; 
		int grilleCouleursWidth = (boutonsRadius+5)*Mastermind.tailleCombinaison+5; 
		return new Dimension(grilleCouleursWidth, grilleCouleursHeight);

	}
}

