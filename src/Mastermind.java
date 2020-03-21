import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Mastermind extends JFrame implements ActionListener, ComponentListener{

	static Mastermind general = new Mastermind();
	static int nbrCouleurs = 8;
	static int tailleCombinaison = 4;
	static int nbrTentatives=(tailleCombinaison+1)*2;
	static PlateauJeu plateauJeu = new PlateauJeu();
	static PanneauAccueil accueil = new PanneauAccueil();;


	public static void main(String[] args) {


		plateauJeu.adjustContraints();
		//general.setContentPane(plateauJeu);


		accueil.adjustContraints();
		accueil.boutonsContraints();
		general.setContentPane(accueil);


		//Options simon2 = new Options();
		//simon2.setVisible(true);

		general.setVisible(true);

	}


	public Mastermind(){

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
		this.setTitle("Mastermind");
		Toolkit.getDefaultToolkit().setDynamicLayout( false );
		//this.setResizable(false);



		//		ContentPane
		//this.getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.blue);
		this.addComponentListener(this);


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


	public static int generalWidth() {
		Insets insets = Mastermind.general.getInsets();
		int width = Mastermind.general.getWidth()-insets.right-insets.left;
		return width;

	}

	public static int generalHeight() {
		Insets insets = Mastermind.general.getInsets();
		int height = Mastermind.general.getHeight()-insets.top-insets.bottom;
		return height;

	}




	@Override
	public void componentResized(ComponentEvent e) {
		//maximum ratio
		double maxRatio = 16.0/9.0;
		double maxHeight=general.getHeight();
		double maxWidth =maxHeight*maxRatio;
		if(general.getWidth()/general.getHeight()>maxRatio)
			this.setSize(new Dimension((int)maxWidth, (int)maxHeight));

		//minimum ratio set to 1
		double minRatio = 1.0;
		double minWidth=general.getWidth();
		double minHeight =minWidth/minRatio;
		if(general.getWidth()/general.getHeight()<minRatio)
			this.setSize(new Dimension((int)minWidth, (int)minHeight));

		//accueil layout Resize
		accueil.adjustContraints();
		accueil.revalidate();


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

}


