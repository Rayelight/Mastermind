import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Mastermind extends JFrame implements ActionListener, HierarchyBoundsListener, ComponentListener{

	static Mastermind general = new Mastermind();
	static int nbrCouleurs = 8;
	static int tailleCombinaison = 4;
	static int nbrTentatives=(tailleCombinaison+1)*2;
	static PlateauJeu plateauJeu;
	

	public static void main(String[] args) {
		
		plateauJeu = new PlateauJeu();
		general.setContentPane(plateauJeu);
		plateauJeu.adjustContraints();
		general.setVisible(true);

		//FenetreJeu simon = new FenetreJeu();
		//simon.setVisible(true);

		//Options simon2 = new Options();
		//simon2.setVisible(true);

	}


	public Mastermind(){
		this.setTitle("Mastermind");

		// dimensionnement et affichage de la fenêtre

		//		plein écran
		//this.setExtendedState(this.MAXIMIZED_BOTH);
		//this.setUndecorated(true);		//pour ne pas avoir de bords
		this.pack();

		//		taille max
		Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		//Insets insets = this.getInsets();
		int width = bounds.width*7/10;
		int height = bounds.height;
		this.setSize(new Dimension(width, height));
		//this.setSize(800,600);
		this.setMinimumSize(new Dimension(800,600));
		this.setLocation(0,0);

		//		paramètres fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);



		//		ContentPane
		//this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.blue);


	}






	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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


	@Override
	public void componentResized(ComponentEvent e) {
			plateauJeu.adjustContraints();
            Dimension d=this.getSize();
            Dimension minD=this.getMinimumSize();
            if(d.width<minD.width)
                d.width=minD.width;
            if(d.height<minD.height)
                d.height=minD.height;
            this.setSize(d);
		
	}


	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ancestorMoved(HierarchyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ancestorResized(HierarchyEvent e) {
		// TODO Auto-generated method stub
		
	}

}


