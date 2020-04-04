import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StatsPartie extends JPanel{
	


	public StatsPartie(){
		//			Panel Setup
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.green);
		this.setOpaque(true);
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		//		Components creation
		JLabel titre = new JLabel("true") {
			public Dimension getMaximumSize() {
			    Dimension size = getPreferredSize();
			    size.width = Short.MAX_VALUE;
			    return size;
			}
		};
		titre.setBackground(Color.black);
		titre.setOpaque(true);
		titre.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		TimerLabel titre2 = new TimerLabel();
		titre2.setBackground(Color.black);
		titre2.setOpaque(true);
		titre2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		//			Adding components
		this.add(titre);
		this.add(titre2);


	}


	public void adjustContraints() {
		//			Adjust Constraints


	}
}
