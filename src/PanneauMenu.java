import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanneauMenu extends JPanel{


	public PanneauMenu(){
		//			Panel Setup
		this.setBackground(Color.magenta);

		//		Components creation



		//			Adding components




	}
	
	public Dimension getPreferredSize() {
		return new Dimension((int) (Mastermind.generalWidth()*0.3),Mastermind.generalHeight());
	}

}



