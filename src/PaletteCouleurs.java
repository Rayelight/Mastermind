import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PaletteCouleurs extends JPanel{


	SpringLayout layout;


	public PaletteCouleurs(){
		//			Panel Setup
		this.setLayout(new BorderLayout());
		this.setBackground(Color.pink);

		//		Components creation
		JLabel titre = new JLabel("Couleurs:", JLabel.CENTER){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(RoundButton.boutonRadius()*4,RoundButton.boutonRadius());
			}
		};
		titre.setOpaque(false);
		titre.setForeground(Color.red);
		titre.setBorder(BorderFactory.createLineBorder(Color.red));
		titre.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
            	titre.setFont(new Font("Serif", Font.PLAIN, RoundButton.boutonRadius()));
                titre.repaint();
            }
        });
		
		
		
		JPanel boutonsPannel = new JPanel();
		boutonsPannel.setLayout(new FlowLayout());
		boutonsPannel.setOpaque(false);
		for(int i=0; i<Mastermind.nbrCouleurs; i++) {
			boutonsPannel.add(new RoundButton(Mastermind.couleurs[i]));
		}
		boutonsPannel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


		//			Adding components
		this.add(titre, BorderLayout.PAGE_START);
		this.add(boutonsPannel, BorderLayout.CENTER);


	}


	public void adjustContraints() {
		//			Adjust Constraints


	}


	


}

