import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HiddenCombiPanel extends JPanel{

	Combinaison hiddenCombi;


	public HiddenCombiPanel(){
		//			Panel Setup
		this.setLayout(new BorderLayout());
		this.setBackground(Color.black);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
			}
		});


		//		Components creation
		Color[] couleurs = HiddenCombiPanel.combiAleatoire();
		hiddenCombi = new Combinaison(couleurs);



		//			Adding components
		this.add(hiddenCombi, BorderLayout.CENTER);


	}


	public void adjustContraints() {
		//			Adjust Constraints
		int hInset = (BarreMenu.menuWidth()-GrilleCouleurs.gridColorWidth())/2;
		int vInset = (this.getHeight()-Combinaison.combinaisonHeight())/2;
		this.setBorder(BorderFactory.createEmptyBorder(vInset,hInset,vInset,hInset));

	}

	public static Color[] combiAleatoire() {
		Color [] aleatoire = new Color[Mastermind.tailleCombinaison];
		if(Mastermind.multiColor) {
			//MultiColor actif
			for(int i=0;i<Mastermind.tailleCombinaison;i++) {
				aleatoire[i]=Mastermind.couleurs[(int)(Math.random()*Mastermind.nbrCouleurs)];
			}
		}else{
			//MultiColor inactif
			do {
				for(int i=0;i<Mastermind.tailleCombinaison;i++) {
					aleatoire[i]=Mastermind.couleurs[(int)(Math.random()*Mastermind.nbrCouleurs)];
				}				
			}while(aleatoire[0]!=aleatoire[1] && aleatoire[0]!=aleatoire[2] &&aleatoire[0]!=aleatoire[3] &&aleatoire[1]!=aleatoire[2] &&aleatoire[1]!=aleatoire[3] &&aleatoire[2]!=aleatoire[3] ); 		
		}
		return aleatoire;
	}

}