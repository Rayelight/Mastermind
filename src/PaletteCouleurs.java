import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PaletteCouleurs extends JPanel implements ActionListener{


	SpringLayout layout;


	public PaletteCouleurs(){
		//			Panel Setup
		layout = new SpringLayout();
		this.setLayout(layout);
		this.setBackground(Color.magenta);

		//		Components creation
		JLabel titre = new JLabel("Couleurs:"){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(RoundButton.boutonRadius()*4,RoundButton.boutonRadius());
			}
		};
		titre.setOpaque(false);
		titre.setForeground(Color.orange);
		titre.setBorder(BorderFactory.createLineBorder(Color.orange));
		titre.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
            	titre.setFont(new Font("Serif", Font.BOLD, RoundButton.boutonRadius()));
                titre.repaint();
            }
        });
		
		
		
		JPanel boutonsPannel = new JPanel();
		boutonsPannel.setLayout(new FlowLayout());
		for(int i=0; i<Mastermind.nbrCouleurs; i++) {
			boutonsPannel.add(new RoundButton(Mastermind.couleurs[i]));
		}
		boutonsPannel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));


		//			Adding components




	}


	public void adjustContraints() {
		//			Adjust Constraints


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}

