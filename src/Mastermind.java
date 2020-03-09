import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Mastermind extends JFrame{




	public Mastermind(){
		this.setTitle("Plateau de Jeu");
		// dimensionnement et affichage de la fenêtre
		this.setSize(400, 600);
		this.setLocation(300,200);
		this.setVisible(true);
		// quitter le programme lorsqu'on ferme la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel plateauJeu = new JPanel();
		plateauJeu.setLayout(null);
		plateauJeu.setBackground(Color.yellow);
		this.setContentPane(plateauJeu);

		this.setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Mastermind m = new Mastermind();



	}



	public void placementBoutons(){
		final int difficulte = 5;
		JButton[] lesBoutons;
		JPanel panneauDeBoutons = new JPanel();
		lesBoutons =new JButton[(int) Math.pow(difficulte, 2)];
		for(int i=0; i<lesBoutons.length; i++) {
			lesBoutons[i]= new JButton("");
			lesBoutons[i].addActionListener(this);
			panneauDeBoutons.add(lesBoutons[i]);
			int taille=(510-10*(difficulte+1))/difficulte;
			int x=10+(taille+10)*(i%5);
			int y=10+(taille+10)*((i-i%5)/5);
			lesBoutons[i].setBounds(x,y,taille,taille);
		}
	}

	public void boutonCirculaire(int x_pos, int y_pos) {
		JButton addBtn = new JButton("+");
		addBtn.setBounds(x_pos, y_pos, 30, 25);
		addBtn.setBorder(new RoundedBorder(10)); //10 is the radius
		addBtn.setForeground(Color.BLUE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

class RoundedBorder implements Border {

	private int radius;


	RoundedBorder(int radius) {
		this.radius = radius;
	}


	public Insets getBorderInsets(Component c) {
		return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	}


	public boolean isBorderOpaque() {
		return true;
	}


	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	}
}
