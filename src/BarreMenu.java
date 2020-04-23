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
		this.setAlignmentX(CENTER_ALIGNMENT);

		//		Components creation
		hiddenCombiPanel = new HiddenCombiPanel() {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(menuWidth(),Mastermind.generalHeight()-3*singleMenuHeight());
			}
			public Dimension getMaximumSize(){
				return getPreferredSize();
			}
		};
		hiddenCombiPanel.setAlignmentY(CENTER_ALIGNMENT);
		
		paletteCouleurs = new PaletteCouleurs() {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(menuWidth(),singleMenuHeight());
			}
			public Dimension getMaximumSize(){
				return getPreferredSize();
			}
		};
		paletteCouleurs.setAlignmentY(CENTER_ALIGNMENT);
		
		gameStats = new StatsPartie() {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(menuWidth(),singleMenuHeight());
			}
			public Dimension getMaximumSize(){
				return getPreferredSize();
			}
		};
		gameStats.setAlignmentY(CENTER_ALIGNMENT);

		
		panelBoutons = new BoutonsJeu() {
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(menuWidth(),singleMenuHeight());
			}
			public Dimension getMaximumSize(){
				return getPreferredSize();
			}
		};
		panelBoutons.setAlignmentY(CENTER_ALIGNMENT);


		//			Adding components
		this.add(hiddenCombiPanel);
		this.add(paletteCouleurs);
		this.add(gameStats);
		this.add(panelBoutons);


	}

	public Dimension getPreferredSize() {
		return new Dimension(menuWidth(), Mastermind.generalHeight());
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
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



