import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Combinaison extends JPanel{
	private int n=4;
	private RoundButton[] couleurs = new RoundButton[n];

	public Combinaison(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//this.setOpaque(false);
		this.setBackground(Color.green);
		this.setBounds(0,0,n*(5+50)+5,60);


		for(int i=0; i<n; i++) {
			couleurs[i] = new RoundButton(50);
			couleurs[i].setBackground(Color.gray);
			this.add(couleurs[i]);
		}

	}
}
