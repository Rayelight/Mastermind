import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyBoundsListener;
import java.awt.event.HierarchyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlateauJeu extends JPanel implements ActionListener, HierarchyBoundsListener{




	public PlateauJeu(){
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
		this.setBackground(Color.yellow);
		
		Combinaison[] tentatives = new Combinaison[10];
		for(int i=0; i<10; i++) {
			this.add(tentatives[i]=new Combinaison());
			
		}
		
	}
	
	static JFrame general = new JFrame();

	public static void main(String[] args) {
		
		general.setTitle("Mastermind");

		// dimensionnement et affichage de la fenêtre

		//		plein écran
		//general.setExtendedState(general.MAXIMIZED_BOTH);
		//general.setUndecorated(true);		//pour ne pas avoir de bords
		general.pack();

		//		taille max
		Rectangle bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		//Insets insets = general.getInsets();
		int width = bounds.width*7/10;
		int height = bounds.height;
		general.setSize(new Dimension(width, height));
		general.setLocation(0,0);
		
		// paramètres fenetre
		general.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//general.setResizable(false);
		
		
		
//		ContentPane
		//general.setContentPane(new JPanel());
		general.getContentPane().setLayout(null);
		general.getContentPane().setBackground(Color.blue);
		
		
		
		
		PlateauJeu grilleJeu = new PlateauJeu();
		grilleJeu.setSize(new Dimension( general.getContentPane().getWidth()/4, general.getContentPane().getHeight()-80*2) );
		grilleJeu.setLocation((general.getContentPane().getWidth()-grilleJeu.getWidth())/2,80);
		general.getContentPane().add(grilleJeu);
		

		
		general.setVisible(true);
		
		FenetreJeu simon = new FenetreJeu();
		//simon.setVisible(true);
		
		Options simon2 = new Options();
		simon2.setVisible(true);
		

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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void ancestorMoved(HierarchyEvent e) {
		general.pack();
		general.setVisible(true);
		
	}


	@Override
	public void ancestorResized(HierarchyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

