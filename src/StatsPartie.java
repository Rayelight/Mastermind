import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class StatsPartie extends GradientPanel implements ActionListener{

	
	JLabel nbrCoupsLabel;
	TimerLabel timerLabel;
	JButton restartBouton;
	JButton devoileCombiBouton;
	

	public StatsPartie(){

		//		Components creation
		//	Nombre de coup
		nbrCoupsLabel = new GradientLabel() {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(BarreMenu.menuWidth()-40,labelsHeight());
			}

			@Override
			public String getText() {
				int tentatives;
				try {
					tentatives =Mastermind.getPanneauJeu().getTentativeActif()+1;
					//System.out.println(tentatives);
				}catch(Exception e) {
					tentatives=1;
				}
				return "Nombre de coups: "+tentatives;

			}
		};




		//	Timer
		timerLabel = new TimerLabel(){
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(BarreMenu.menuWidth()-40,labelsHeight());
			}
		};

		
		//	Bouton Restart
		restartBouton = boutonJeu("Restart");
		
		//	Bouton Devoile Combi
		devoileCombiBouton= boutonJeu("Reveal Code");


		//			Adding components
		this.add(nbrCoupsLabel);
		this.add(timerLabel);
		this.add(restartBouton);
		this.add(devoileCombiBouton);


	}
	
	private JButton boutonJeu(String texte) {
		JButton bouton = new GradientButton(texte){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(boutonsWidth(), labelsHeight());
			}
		};
		
		bouton.addActionListener(this);

		return bouton;
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

	public static int labelsHeight() {
		int labelHeight = (int) Math.round((BarreMenu.singleMenuHeight()-20*4)/3.0);
		return labelHeight;
	}

	public static int boutonsWidth() {
		int boutonWidth = (int) Math.round((BarreMenu.menuWidth()-40-20)/2.0);
		return boutonWidth;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==restartBouton) {
			Mastermind.setPanneauJeu();
		}
		//Mode Ordi
		if(e.getSource()==devoileCombiBouton) {
			Mastermind.panneauJeu.reveal();
		}
		
	}

}
