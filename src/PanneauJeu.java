import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanneauJeu extends JPanel implements ActionListener{


	public PanneauJeu(){
		//			Panel Setup
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.setBackground(Color.orange);
		
		//			Components creation
		PlateauJeu plateauJeu = new PlateauJeu();
		BareMenu bareMenu = new BareMenu();
		
		//			Adding components
		this.add(plateauJeu);
		this.add(bareMenu);
		

		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Mastermind.generalWidth(),Mastermind.generalHeight());
	}
	



}

