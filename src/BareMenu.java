import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BareMenu extends JPanel{


	public BareMenu(){
		//			Panel Setup
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.magenta);

		//		Components creation
		HiddenCombiPanel hiddenCombiPanel = new HiddenCombiPanel() {
			public Dimension getPreferredSize(){
				return new Dimension((int) (Mastermind.generalWidth()*0.3),(int) (Mastermind.generalHeight()*1.0/7.0));
			}
		};
		
		PaletteCouleurs paletteCouleurs = new PaletteCouleurs() {
			public Dimension getPreferredSize(){
				return new Dimension((int) (Mastermind.generalWidth()*0.3),(int) (Mastermind.generalHeight()*2.0/7.0));
			}
		};
		
		StatsPartie gameStats = new StatsPartie() {
			public Dimension getPreferredSize(){
				return new Dimension((int) (Mastermind.generalWidth()*0.3),(int) (Mastermind.generalHeight()*2.0/7.0));
			}
		};
		
		BoutonsJeu panelBoutons = new BoutonsJeu() {
			public Dimension getPreferredSize(){
				return new Dimension((int) (Mastermind.generalWidth()*0.3),(int) (Mastermind.generalHeight()*2.0/7.0));
			}
		};


		//			Adding components
		this.add(hiddenCombiPanel);
		this.add(paletteCouleurs);
		this.add(gameStats);
		this.add(panelBoutons);


	}

	public Dimension getPreferredSize() {
		return new Dimension((int) (Mastermind.generalWidth()*0.3),Mastermind.generalHeight());
	}

}



