import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class StatsPartie extends JPanel{
	
	JLabel titre;
	JLabel titre2;
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
		titre = new JLabel("Nombre de coups: ") {
			@Override
			public Dimension getPreferredSize() {
			

			    return new Dimension(BarreMenu.menuWidth()-40,labelsHeight());
			}
		};
		titre.setBackground(Color.black);
		titre.setOpaque(true);
		titre.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		titre2 = new TimerLabel(){
			
			@Override
			public Dimension getPreferredSize() {
			

			    return new Dimension(BarreMenu.menuWidth()-40,labelsHeight());
			}
		};
		titre2.setBackground(Color.black);
		titre2.setOpaque(true);
		titre2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		titre2.setAlignmentX( Component.LEFT_ALIGNMENT );

		//			Adding components
		this.add(titre);
		this.add(titre2);


	}


	public void adjustContraints() {
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titre, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, titre, 20, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titre2, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, titre2, 20+20+labelsHeight(), SpringLayout.NORTH, this);


	}
	
	public int labelsHeight() {
		int labelHeight = (int) Math.round((BarreMenu.singleMenuHeight()-20*4)/3.0);
		return labelHeight;
	}
}
