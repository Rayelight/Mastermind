import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class  FenetreFin extends JDialog implements ActionListener{

	private JPanel panneauFin;
	private JLabel msgFin;
	private JButton accueil;
	private JButton retry;
	protected SpringLayout layout = new SpringLayout();;
	private boolean gagnant;

	public  FenetreFin(boolean gagnant){
		this.gagnant = gagnant;
		//			Parametrage JDialog
		this.setResizable(false);
		this.setBackground(Color.blue);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
			}
		});	
		
		
		//			 Création du panneau
		panneauFin=new JPanel();
		panneauFin.setLayout(layout);
		panneauFin.setBackground(Color.blue);
		
		//			Creation Widgets
		//		Création du msgFin
		if(this.gagnant) {
			msgFin= new JLabel("Vous avez gagné en temps avec n tentatives :)");
		}else {
			msgFin= new JLabel("Vous avez perdu :(");
		}
		msgFin.setOpaque(true);
		msgFin.setForeground(Color.red);
		msgFin.setBackground(Color.white);

		//		Création Boutons
		accueil = boutonGagnant("Accueil");
		retry = boutonGagnant("Retry");

		
		//			Ajout Widgets
		panneauFin.add(msgFin);
		panneauFin.add(accueil);
		panneauFin.add(retry);

		
		this.add(panneauFin);
		this.setSize(400,400);
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


	public void adjustContraints() {
		//			Adjust Constraints

		//msgFin Constrains
		layout.putConstraint(SpringLayout.NORTH,  msgFin, 100, SpringLayout.NORTH, panneauFin);
		layout.putConstraint(SpringLayout.SOUTH, msgFin, -200,SpringLayout.SOUTH, panneauFin);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, msgFin, 0, SpringLayout.HORIZONTAL_CENTER, panneauFin);
		
		//boutonGagnant Constrains
		layout.putConstraint(SpringLayout.NORTH, accueil, 300, SpringLayout.NORTH, panneauFin);
		layout.putConstraint(SpringLayout.SOUTH,  accueil, -30, SpringLayout.SOUTH, panneauFin);
		layout.putConstraint(SpringLayout.WEST,  accueil, 30, SpringLayout.WEST, panneauFin);

		layout.putConstraint(SpringLayout.NORTH, retry, 300, SpringLayout.NORTH, panneauFin);
		layout.putConstraint(SpringLayout.SOUTH, retry, -30, SpringLayout.SOUTH, panneauFin);
		layout.putConstraint(SpringLayout.EAST, retry, -30, SpringLayout.EAST, panneauFin);


	}
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}