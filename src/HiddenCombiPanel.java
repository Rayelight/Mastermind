import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class HiddenCombiPanel extends GradientPanel{

	Combinaison hiddenCombi;
	protected SpringLayout layout = new SpringLayout();

	public HiddenCombiPanel(){
		//			Panel Setup
		this.setLayout(layout);
		this.setBackground(Color.black);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
			}
		});


		//		Components creation
		Color[] couleurs = HiddenCombiPanel.combiAleatoire();
		hiddenCombi = new Combinaison(couleurs){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(GrilleCouleurs.gridColorWidth(), Combinaison.combinaisonHeight());
			}
			public Dimension getMaximumSize(){
				return getPreferredSize();
			}
		};



		//			Adding components
		this.add(hiddenCombi);


	}


	public void adjustContraints() {
		//			Adjust Constraints
		layout.putConstraint(SpringLayout.VERTICAL_CENTER, hiddenCombi, 0, SpringLayout.VERTICAL_CENTER, this);
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, hiddenCombi, 0, SpringLayout.HORIZONTAL_CENTER, this);
	}

	public static Color[] combiAleatoire() {
		int [] aleatoire = new int[Mastermind.tailleCombinaison];
		do {
			for(int i=0;i<Mastermind.tailleCombinaison;i++) {
				aleatoire[i]=(int)(Math.random()*Mastermind.nbrCouleurs);
			}				
		}while(!Mastermind.multiColor&&ModeOrdinateur.countDistinct(aleatoire)!=Mastermind.tailleCombinaison); 		

		return ModeOrdinateur.clone(aleatoire);
	}

}