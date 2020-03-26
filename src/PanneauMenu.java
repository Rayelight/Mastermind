import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PanneauMenu extends JPanel{


	SpringLayout layout;


	public PanneauMenu(){
		//			Panel Setup
		layout = new SpringLayout();
		this.setLayout(layout);
		this.setBackground(Color.magenta);

		//		Components creation



		//			Adding components




	}
	
	public Dimension getPreferredSize() {
		return new Dimension((int) (Mastermind.generalWidth()*0.3),Mastermind.generalHeight());
	}

}



