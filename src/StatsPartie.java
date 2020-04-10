import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class StatsPartie extends JPanel{

	JLabel nbrCoupsLabel;
	TimerLabel timerLabel;
	JButton restartBouton;
	JButton devoileCombiBouton;
	SpringLayout  layout;

	public StatsPartie(){
		//			Panel Setup
		layout = new SpringLayout();
		this.setLayout(layout);
		this.setBackground(Color.green);
		this.setOpaque(true);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
				revalidate();
				repaint();

			}
		});



		//		Components creation
		//	Nombre de coup
		nbrCoupsLabel = new JLabel("Nombre de coups: ") {
			@Override
			public Dimension getPreferredSize() {


				return new Dimension(BarreMenu.menuWidth()-40,labelsHeight());
			}
		};
		nbrCoupsLabel.setBackground(Color.black);
		nbrCoupsLabel.setOpaque(true);
		nbrCoupsLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));



		//	Timer
		timerLabel = new TimerLabel(){

			@Override
			public Dimension getPreferredSize() {


				return new Dimension(BarreMenu.menuWidth()-40,labelsHeight());
			}
		};
		timerLabel.setBackground(Color.black);
		timerLabel.setOpaque(true);
		timerLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		timerLabel.setAlignmentX( Component.LEFT_ALIGNMENT );



		//	Bouton Restart
		restartBouton = new JButton("Restart") {
			@Override
			public Dimension getPreferredSize() {


				return new Dimension(boutonsWidth(),labelsHeight());
			}
		};
		restartBouton.setBackground(Color.black);
		restartBouton.setOpaque(true);
		restartBouton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		//	Bouton Devoile Combi
		devoileCombiBouton= new JButton("Reveal Code") {
			@Override
			public Dimension getPreferredSize() {


				return new Dimension(boutonsWidth(),labelsHeight());
			}
		};
		devoileCombiBouton.setBackground(Color.black);
		devoileCombiBouton.setOpaque(true);
		devoileCombiBouton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));


		//			Adding components
		this.add(nbrCoupsLabel);
		this.add(timerLabel);
		this.add(restartBouton);
		this.add(devoileCombiBouton);


	}


	public void adjustContraints() {
		//	nbrCoupsLabel
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nbrCoupsLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, nbrCoupsLabel, 20, SpringLayout.NORTH, this);
		
		//timerLabel
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, timerLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, timerLabel, 20, SpringLayout.SOUTH, nbrCoupsLabel);
		
		//restartBouton
		layout.putConstraint(SpringLayout.EAST, restartBouton, -10, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, restartBouton, 20, SpringLayout.SOUTH, timerLabel);
		
		//devoileCombiBouton
		layout.putConstraint(SpringLayout.WEST, devoileCombiBouton, 20, SpringLayout.EAST, restartBouton);
		layout.putConstraint(SpringLayout.NORTH, devoileCombiBouton, 20, SpringLayout.SOUTH, timerLabel);
	}

	public int labelsHeight() {
		int labelHeight = (int) Math.round((BarreMenu.singleMenuHeight()-20*4)/3.0);
		return labelHeight;
	}

	public int boutonsWidth() {
		int boutonWidth = (int) Math.round((BarreMenu.menuWidth()-40-20)/2.0);
		return boutonWidth;
	}

}
