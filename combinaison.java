import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class combinaison extends JPanel{
	private JButton monBouton1;

	public combinaison(){
		this.setLayout(null);
		this.setBackground(Color.yellow);
		
		
		monBouton1 = new JButton("Afficher");
		monBouton1.setBounds(30,10,110,40);
		monBouton1.setBackground(Color.green);
		monBouton1.addActionListener(this);
	}
}
