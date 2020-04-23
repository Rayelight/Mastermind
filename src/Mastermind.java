import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Mastermind extends JFrame implements ComponentListener{

	//Fenetre
	private static Mastermind general = new Mastermind();
	
	//Paramètres
	protected static int nbrCouleurs = 10;
	protected static int tailleCombinaison = 4;
	protected static boolean multiColor = false;
	protected static int nbrTentatives=(tailleCombinaison+1)*2;
	protected static Color[] couleurs = {	Color.red, Color.green, 
											Color.yellow, Color.blue, 
											Color.orange, Color.gray, 
											Color.pink, Color.white,
											Color.magenta, Color.cyan};
	
	//Panneaux
	static PanneauAccueil accueil = new PanneauAccueil();
	static PanneauJeu panneauJeu = new PanneauJeu();
	static PanneauOptions options= new PanneauOptions();
	static FenetreFin finJeu = new FenetreFin(true);


	public static void main(String[] args) {
		

		//general.setContentPane(panneauJeu);
		//general.setContentPane(accueil);
		general.setContentPane(options);

		general.setVisible(true);
		general.setExtendedState(Frame.MAXIMIZED_BOTH);
		panneauJeu.lancerJeu();
		
		//System.out.println(ModeOrdinateur.generationCombis().size());
		
		
		//finJeu.setVisible(true);
		finJeu.setLocationRelativeTo(Mastermind.general);
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
		int width = bounds.width;
		int height = bounds.height;
		this.setPreferredSize(new Dimension(width, height));
		//this.setSize(800,600);
		this.setMinimumSize(new Dimension(800,600));
		this.setLocation(0,0);

		//		paramètres fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Mastermind");
		Toolkit.getDefaultToolkit().setDynamicLayout( false );
		//this.setResizable(false);
		this.pack();


		//		ContentPane
		this.getContentPane().setBackground(Color.blue);
		this.addComponentListener(this);

	}




	//			PanneauJeu Récupération
	public static PanneauJeu getPanneauJeu() {
		return panneauJeu;
	}


	public void placementBoutons(){
		final int difficulte = 5;
		JButton[] lesBoutons =new JButton[(int) Math.pow(difficulte, 2)];
		
		for(int i=0; i<lesBoutons.length; i++) {
			int xEspace = 5;
			int yEspace = 5;
			
			int x0 = 10;
			int y0 = 10;
			
			int tailleX = 500;
			int tailleY = 500;
			
			int x=x0+(tailleX+xEspace)*(i%difficulte);
			int y=y0+(tailleY+yEspace)*(i/difficulte);
			
			lesBoutons[i].setBounds(x,y,tailleX,tailleY);
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
		double maxRatio = 16.8/9.0;
		double maxHeight=general.getHeight();
		double maxWidth =maxHeight*maxRatio;
		if((double)general.getWidth()/(double)general.getHeight()>maxRatio)
			this.setSize(new Dimension((int)maxWidth, (int)maxHeight));

		//minimum ratio set to 1
		double minRatio = 8.0/6.0;
		double minWidth=general.getWidth();
		double minHeight =minWidth/minRatio;
		if((double)general.getWidth()/(double)general.getHeight()<minRatio)
			this.setSize(new Dimension((int)minWidth, (int)minHeight));

		
		//testingSizes
		//System.out.println(general.getWidth());
		//System.out.println(general.getHeight());
		//System.out.println((double)general.getWidth()/(double)general.getHeight());

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

	//			Parametres Getters
	public static int getNbrCouleurs() {
		return nbrCouleurs;
	}


	public static int getTailleCombinaison() {
		return tailleCombinaison;
	}


	public static boolean isMultiColor() {
		return multiColor;
	}


	public static int getNbrTentatives() {
		return nbrTentatives;
	}


	public static Color[] getCouleurs() {
		return couleurs;
	}


	//			Parametres Setters
	public static void setNbrCouleurs(int nbrCouleurs) {
		Mastermind.nbrCouleurs = nbrCouleurs;
	}


	public static void setTailleCombinaison(int tailleCombinaison) {
		Mastermind.tailleCombinaison = tailleCombinaison;
	}


	public static void setMultiColor(boolean multiColor) {
		Mastermind.multiColor = multiColor;
	}


	public static void setNbrTentatives(int nbrTentatives) {
		Mastermind.nbrTentatives = nbrTentatives;
	}


	public static void setCouleurs(Color[] couleurs) {
		Mastermind.couleurs = couleurs;
	}
	

}


