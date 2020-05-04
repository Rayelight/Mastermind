import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class BoutonsJeu extends GradientPanel implements ActionListener{

	private JButton[] boutonsJeu;
	static int nombreBoutons=4;

	public BoutonsJeu(){

		//			Components creation
		//		boutonsJeu
		boutonsJeu = new JButton[nombreBoutons];

		//	Creation Boutons
		boutonsJeu[0] = boutonJeu("Accueil");
		boutonsJeu[1] = boutonJeu("Mode Ordi.");
		boutonsJeu[2] = boutonJeu("Règles");
		boutonsJeu[3] = boutonJeu("Aides");

		boutonsJeu[3].setEnabled(Mastermind.activeAide);
		
		
		//			Adding Components
		//		Ajout des boutons centreaux
		for(JButton b : boutonsJeu) {
			this.add(b);
		}
		
		adjustContraints();

	}


	public void adjustContraints() {
		//			Adjust Constraints
		//		Boutons Constraints
		for(int i=0; i<nombreBoutons; i++) {
			int westPos = 20 + (boutonsWidth()+20)*(i%2);
			int northPos = vGap() + (boutonsHeight()+vGap())*(i/2);
			layout.putConstraint(SpringLayout.WEST, boutonsJeu[i], westPos, SpringLayout.WEST, this);
			//System.out.println(i*Mastermind.generalWidth()/(nombreBoutons+1));
			layout.putConstraint(SpringLayout.NORTH, boutonsJeu[i], northPos, SpringLayout.NORTH, this);
		}

	}

	private JButton boutonJeu(String texte) {
		JButton bouton = new GradientButton(texte){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(boutonsWidth(), boutonsHeight());
			}
		};
		
		bouton.addActionListener(this);
		
		bouton.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				bouton.setFont(new Font("Serif", Font.BOLD, boutonsHeight()*5/12));
				bouton.repaint();
			}
		});

		return bouton;
	}


	public static int boutonsWidth() {
		int boutonWidth = (int) Math.round((BarreMenu.menuWidth()-40-20)/2.0);
		return boutonWidth;
	}

	public static int boutonsHeight() {
		int boutonHeight = StatsPartie.labelsHeight();
		return boutonHeight;

	}
	
	public int vGap() {
		int vGap = (int) Math.round((BarreMenu.singleMenuHeight()-6-boutonsHeight()*2)/3.0);
		return vGap;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Accueil
		if(e.getSource()==boutonsJeu[0]) {
			Mastermind.setPanneauAccueil();
		}
		//Mode Ordi
		if(e.getSource()==boutonsJeu[1]) {
			Mastermind.panneauJeu.lancerOrdi();
			Mastermind.panneauJeu.tacheOrdi();
		}
		//Regles
		if(e.getSource()==boutonsJeu[2]) {

		}
		//Aides
		if(e.getSource()==boutonsJeu[3]&&!Mastermind.panneauJeu.fini) {
			Mastermind.panneauJeu.activationOrdi();
		}

	}
}