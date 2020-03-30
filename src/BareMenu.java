import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BareMenu extends JPanel{


	public BareMenu(){
		//			Panel Setup
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setBackground(Color.magenta);

		//		Components creation
		PaletteCouleurs paletteCouleurs = new PaletteCouleurs();


		//			Adding components
		this.add(paletteCouleurs);


	}
	
	public Dimension getPreferredSize() {
		return new Dimension((int) (Mastermind.generalWidth()*0.3),Mastermind.generalHeight());
	}

}



