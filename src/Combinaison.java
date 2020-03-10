import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Combinaison extends JPanel{
	//private JButton monBouton1;

	public Combinaison(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		//this.setOpaque(false);
		this.setBackground(Color.green);
		this.setBounds(0,0,600,300);
		
		//monBouton1 = new RoundBouton(20);
		//monBouton1.setSize(40,40);
		//this.add(monBouton1);
		
		JButton button = new RoundButton(100);
	    button.setBackground(Color.gray);
	    this.add(button);
	    
	    JButton button2 = new RoundButton(100);
	    button2.setBackground(Color.gray);
	    this.add(button2);
	    
	    JButton button3 = new RoundButton(100);
	    button3.setBackground(Color.gray);
	    this.add(button3);
		
		
	}
}
