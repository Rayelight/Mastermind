import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class GrilleCouleurs  extends JPanel{


	public GrilleCouleurs() {
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setLayout(new GridLayout(Mastermind.nbrTentatives, 1));
		this.setBackground(Color.yellow);

		Combinaison[] tentatives = new Combinaison[Mastermind.nbrTentatives];
		for(int i=0; i<Mastermind.nbrTentatives; i++) {
			this.add(tentatives[i]=new Combinaison());

		}
	}

	@Override
	public Dimension getPreferredSize(){
		int grilleCouleursHeight = Mastermind.generalHeight()-40;
		int grilleCouleursWidth = (RoundButton.boutonRadius()+10)*Mastermind.tailleCombinaison+5; 
		return new Dimension(grilleCouleursWidth, grilleCouleursHeight);

	}
}

