import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class plateauJeu extends JPanel implements ActionListener{




	public plateauJeu(){
		this.setLayout(null);
		this.setBackground(Color.yellow);


	}


	public static void main(String[] args) {
		JFrame general = new JFrame();
		general.setTitle("Mastermind");

		// dimensionnement et affichage de la fenêtre

		//		plein écran
		//general.setExtendedState(general.MAXIMIZED_BOTH);
		//general.setUndecorated(true);		//pour ne pas avoir de bords
		//general.pack();

		//		taille max
		Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		Insets insets = general.getInsets();
		int width = (int)((bounds.width-(insets.left+insets.right))*0.8);
		int height = bounds.height-(insets.top+insets.bottom);
		general.setSize(new Dimension(width, height));
		general.setLocation(0,0);
		
		// paramètres fenetre
		general.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//general.setResizable(false);
		

		plateauJeu grilleJeu = new plateauJeu();
		grilleJeu.setSize(new Dimension(width, (int)(height*0.5)));
		grilleJeu.setLocation(0,height/2);
		
		
		//		ContentPane
		general.setContentPane(new JPanel());
		general.getContentPane().setLayout(null);
		general.getContentPane().setBackground(Color.blue);
		general.getContentPane().add(grilleJeu);

		
		general.setVisible(true);


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

	/*
	public void boutonCirculaire(int x_pos, int y_pos) {
		JButton addBtn = new JButton("+");
		addBtn.setBounds(x_pos, y_pos, 30, 25);
		addBtn.setBorder(new RoundedBorder(10)); //10 is the radius
		addBtn.setForeground(Color.BLUE);
	}
	 */


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

/*
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
 */
