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
public class  PanneauPerdant extends JDialog implements ActionListener{
	
	private JLabel perdu;
	private JButton accueil;
	private JButton retry;
	protected SpringLayout layout;
	private JPanel fin;
	
	public  PanneauPerdant(Mastermind f,String titre,boolean modal){
		layout = new SpringLayout();
		this.setResizable(false);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
            	adjustContraints();
            }
        });	

		// Création du Jpanel
	    fin=new JPanel();
		fin.setLayout(layout);
		fin.setBackground(Color.blue);

		
		//Création du texte 		
		perdu= new JLabel("Vous avez perdu :(");
		perdu.setOpaque(true);
		perdu.setForeground(Color.red);
		perdu.setBackground(Color.white);
		fin.add(perdu);
		
	
		//Boutons Gagnant
		//	Création Boutons
		accueil = boutonPerdant("Accueil");
		fin.add(accueil);
		retry = boutonPerdant("Retry");
		fin.add(retry);
		
		this.add(fin);
		this.setSize(400,400);
	}
	
	//Création des Boutons 
	private JButton boutonPerdant (String texte) {
		JButton bouton = new JButton(texte){
		};
		bouton.setBackground(Color.red);
		bouton.setForeground(Color.white);
		bouton.addActionListener(this);

		return bouton;
	}

	public void adjustContraints() {
		//			Adjust Constraints
		//Boutonperdant Constrains
		layout.putConstraint(SpringLayout.NORTH, accueil, 300, SpringLayout.NORTH, fin);
		layout.putConstraint(SpringLayout.SOUTH,  accueil, -30, SpringLayout.SOUTH, fin);
		layout.putConstraint(SpringLayout.WEST,  accueil, 30, SpringLayout.WEST, fin);
		
		layout.putConstraint(SpringLayout.NORTH, retry, 300, SpringLayout.NORTH, fin);
		layout.putConstraint(SpringLayout.SOUTH, retry, -30, SpringLayout.SOUTH, fin);
		layout.putConstraint(SpringLayout.EAST, retry, -30, SpringLayout.EAST, fin);
		
        //Perdu Constrains
		layout.putConstraint(SpringLayout.NORTH,  perdu, 100, SpringLayout.NORTH, fin);
		layout.putConstraint(SpringLayout.SOUTH, perdu, -200,SpringLayout.SOUTH, fin);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, perdu, 0, SpringLayout.HORIZONTAL_CENTER, fin);

}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
}