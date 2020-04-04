import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BarreMenu extends JPanel{

	
	HiddenCombiPanel hiddenCombiPanel;
	PaletteCouleurs paletteCouleurs;
	StatsPartie gameStats;
	BoutonsJeu panelBoutons;
	
	
	
	
	public BarreMenu(){
		//			Panel Setup
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.magenta);


		//		Components creation
		hiddenCombiPanel = new HiddenCombiPanel() {
			public Dimension getPreferredSize(){
				return new Dimension(menuWidth(),Mastermind.generalHeight()-3*singleMenuHeight());
			}
		};
		
		paletteCouleurs = new PaletteCouleurs() {
			public Dimension getPreferredSize(){
				return new Dimension(menuWidth(),singleMenuHeight());
			}
		};
		
		gameStats = new StatsPartie() {
			public Dimension getPreferredSize(){
				return new Dimension(menuWidth(),singleMenuHeight());
			}
		};
		
		panelBoutons = new BoutonsJeu() {
			public Dimension getPreferredSize(){
				return new Dimension(menuWidth(),singleMenuHeight());
			}
		};


		//			Adding components
		this.add(hiddenCombiPanel);
		this.add(paletteCouleurs);
		this.add(gameStats);
		this.add(panelBoutons);


	}

	public Dimension getPreferredSize() {
		return new Dimension(menuWidth(), Mastermind.generalHeight());
	}
	
	public static int menuWidth(){
		int width = Mastermind.generalWidth()-PlateauJeu.gameWidth();  
		return width;

	}
	
	public static int singleMenuHeight(){
		int height = (int) Math.round(Mastermind.generalHeight()*2.0/7.0);  
		return height;

	}

}



