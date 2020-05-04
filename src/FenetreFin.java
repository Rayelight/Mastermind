import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class  FenetreFin extends JDialog{
	
	private boolean gagnant;
	private String temps;
	private int coups;

	

	public  FenetreFin(boolean gagnant, String temps, int coups){

		super(Mastermind.getGeneral(), "Scores", true);

		this.gagnant = gagnant;
		this.temps = temps;
		this.coups = coups;
		//			Parametrage JDialog
		this.setResizable(true);
		this.setBackground(Color.red);
		this.setContentPane(new PanneauFin());
		this.setSize(Mastermind.generalHeight()/2, Mastermind.generalHeight()/4);
		this.setLocationRelativeTo(Mastermind.getGeneral());


		this.setVisible(true);
	}

	
	private class PanneauFin extends GradientPanel implements ActionListener{
		
		private JLabel msgFin;
		private JButton accueil;
		private JButton retry;
		
		PanneauFin(){
			//			Creation Widgets
			//		Création du msgFin
			msgFin= new JLabel();
			if(gagnant) {
				msgFin.setText("Vous avez gagné en "+temps+ " avec "+coups+" tentatives!!!");
			}else {
				msgFin.setText("Vous avez perdu :(");
			}

			//		Création Boutons
			accueil = boutonGagnant("Accueil");
			retry = boutonGagnant("Retry");


			//			Ajout Widgets
			this.add(msgFin);
			this.add(accueil);
			this.add(retry);

		}
		
		
		public void adjustContraints() {
			//			Adjust Constraints

			//msgFin Constrains
			layout.putConstraint(SpringLayout.NORTH,  msgFin, 100, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, msgFin, -200,SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, msgFin, 0, SpringLayout.HORIZONTAL_CENTER, this);

			//boutonGagnant Constrains
			layout.putConstraint(SpringLayout.NORTH, accueil, 280, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH,  accueil, -50, SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.WEST,  accueil, 70, SpringLayout.WEST, this);

			layout.putConstraint(SpringLayout.NORTH, retry, 280, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.SOUTH, retry, -50, SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.EAST, retry, -70, SpringLayout.EAST, this);
			


		}

		//Création des Boutons 
		private JButton boutonGagnant (String texte) {
			JButton bouton = new JButton(texte){
			};
			bouton.setBackground(Color.red);
			bouton.setForeground(Color.white);
			bouton.addActionListener(this);

			return bouton;
		}


		
		@Override
		public void actionPerformed(ActionEvent e) {

		}

	}

}