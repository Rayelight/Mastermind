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
		Color[] couleurs = {Color.red, Color.red, Color.yellow, Color.green};
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
	
}
