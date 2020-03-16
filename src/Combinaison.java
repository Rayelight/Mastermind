import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Combinaison extends JPanel{
	private int n=4;
	private RoundButton[] couleurs = new RoundButton[n];

	public Combinaison(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		//this.setOpaque(false);
		this.setBackground(Color.green);
		//this.setSize(4*(10+50)+10,60);
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		for(int i=0; i<n; i++) {
			couleurs[i] = new RoundButton(50);
			couleurs[i].setBackground(Color.gray);
			this.add(couleurs[i]);
		}

	}
}
