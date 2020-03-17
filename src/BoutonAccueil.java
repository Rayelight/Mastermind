import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BoutonAccueil extends JButton{

	public BoutonAccueil(String name){
		super(name);
		this.setBackground(Color.cyan);
		this.setForeground(Color.white);
		
	}
	
	@Override
	public Dimension getPreferredSize(){
		Insets insets = Mastermind.general.getInsets();
		int width = Mastermind.general.getWidth()-insets.right-insets.left;
		int boutonWidth = (int) (width/(PanneauAccueil.nombreBoutons*(1+PanneauAccueil.pourcentageEspace)+PanneauAccueil.pourcentageEspace));
		
		
		return new Dimension(boutonWidth,50);

	}
}
