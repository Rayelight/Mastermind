import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashSet;

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
		int [] aleatoire = new int[Mastermind.tailleCombinaison];
		if(Mastermind.multiColor) {
			//MultiColor actif
			for(int i=0;i<Mastermind.tailleCombinaison;i++) {
				aleatoire[i]=(int)(Math.random()*Mastermind.nbrCouleurs);
			}
		}else {
			//MultiColor inactif
			do {
				for(int i=0;i<Mastermind.tailleCombinaison;i++) {
					aleatoire[i]=(int)(Math.random()*Mastermind.nbrCouleurs);
				}				
			}while(ModeOrdinateur.countDistinct(aleatoire)==Mastermind.tailleCombinaison); 		
		}
		return ModeOrdinateur.clone(aleatoire);
	}
	
}