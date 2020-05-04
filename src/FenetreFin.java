import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
		this.setUndecorated(true);
		this.setSize(Mastermind.generalHeight()/2, Mastermind.generalHeight()/4);
		this.setContentPane(new PanneauFin());
		this.setLocationRelativeTo(Mastermind.getGeneral());


		this.setVisible(true);
	}

	public void dispose() {
		this.setVisible(false);
	}


	private class PanneauFin extends GradientPanel implements ActionListener{

		private JLabel msgFin;
		private JButton accueil;
		private JButton newGame;

		PanneauFin(){

			//			Creation Widgets
			//		Création du msgFin
			msgFin= new JLabel(){
				@Override
				public Dimension getPreferredSize() {
					return new Dimension(hGap()*7, vGap()*2);
				}
				protected void paintComponent(Graphics grphcs) {

					Graphics2D g2d = (Graphics2D) grphcs;
					g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
					//GradientPaint gp = new GradientPaint(0, -getHeight()/2, getBackground().brighter().brighter(),
					// 		0, getHeight()/2,getBackground());
					GradientPaint gp = new GradientPaint (getWidth()/4, getHeight()/4, Color.blue, 
							getWidth()*5/4, getHeight()*5/4, Color.cyan); 
					g2d.setPaint(gp);
					if(Mastermind.darkMode) {
						g2d.setColor(Color.decode("#D3CEBA"));
					}
					g2d.fillRect(0, 0, getWidth(), getHeight()); 
					super.paintComponent(grphcs);

				}
				
				public String getText() {
					if(gagnant) {
						return "Vous avez gagné en "+temps+ " avec "+coups+" tentatives!!!";
					}
					return "Vous avez perdu :(";
				}
			};

			msgFin.setFont(new Font("Serif", Font.BOLD, msgFin.getPreferredSize().height*3/12));
			msgFin.setHorizontalAlignment(JLabel.CENTER);


			//		Création Boutons
			accueil = boutonGagnant("Accueil");
			newGame = boutonGagnant("New Game");


			//			Ajout Widgets
			this.add(msgFin);
			this.add(accueil);
			this.add(newGame);

		}


		public void adjustContraints() {
			//			Adjust Constraints

			//msgFin Constrains
			layout.putConstraint(SpringLayout.NORTH,  msgFin, vGap(), SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, msgFin, 0, SpringLayout.HORIZONTAL_CENTER, this);

			//boutonGagnant Constrains
			layout.putConstraint(SpringLayout.SOUTH, accueil, -vGap(), SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.WEST,  accueil, hGap(), SpringLayout.WEST, this);

			layout.putConstraint(SpringLayout.SOUTH, newGame, -vGap(), SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.EAST, newGame, -hGap(), SpringLayout.EAST, this);



		}

		//Création des Boutons 
		private JButton boutonGagnant (String texte) {
			JButton bouton = new GradientButton(texte){
				@Override
				public Dimension getPreferredSize() {
					return new Dimension(hGap()*3, vGap()*2);
				}
			};
			bouton.setBackground(Color.red);
			bouton.setForeground(Color.white);
			bouton.addActionListener(this);

			return bouton;
		}

		public int vGap() {
			return (Mastermind.generalHeight()/4)/7;
		}

		public int hGap() {
			return (Mastermind.generalHeight()/2)/9;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			//Accueil
			if(e.getSource()==accueil) {
				Mastermind.setPanneauAccueil();
			}

			//NewGame
			if(e.getSource()==newGame) {
				Mastermind.setPanneauJeu();
			}

			dispose();
		}

	}

}