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
		//this.setBorder(BorderFactory.createLineBorder(Color.black));

		for(int i=0; i<n; i++) {
			couleurs[i] = new RoundButton(50);
			couleurs[i].setBackground(Color.gray);
			this.add(couleurs[i]);
		}

	}
	
    Combinaison[] tentatives = new Combinaison[Mastermind.nbrTentatives];
	for(int i=0; i<Mastermind.nbrTentatives; i++) {
		this.add(tentatives[i]=new Combinaison());
	}	
		
	public class test(Combinaison[] tentatives) {
	    for(int i=0;i<Mastermind.nbrTentatives; i++) {
	        if(tentatives[i].equals("combinaison exacte?")){
	        	//disparition du cache noir 
	
		
	        }
	    }
	}
}
