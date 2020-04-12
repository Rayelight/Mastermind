import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class GrilleCouleurs  extends JPanel{

	protected Combinaison[] tentatives = new Combinaison[Mastermind.nbrTentatives];

	public GrilleCouleurs() {
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setLayout(new GridLayout(Mastermind.nbrTentatives, 1));
		this.setBackground(Color.red);


		for(int i=Mastermind.nbrTentatives-1; i>=0; i--) {
			this.add(tentatives[i]=new Combinaison());

		}
	}


	//		Paramétisation des dimensions
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(gridColorWidth(), gridColorHeight());
	}

	public static int gridColorWidth(){
		int grilleCouleursWidth = (RoundButton.boutonRadius()+10)*Mastermind.tailleCombinaison+5; 
		return grilleCouleursWidth;

	}

	public static int gridColorHeight(){
		int grilleCouleursHeight = Mastermind.generalHeight()-40;
		return grilleCouleursHeight;

	}


}



