import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HiddenCombiPanel extends JPanel{
	


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
		this.adjustContraints();
		

		//		Components creation
		Combinaison hiddenCombi=new Combinaison();
		
		

		//			Adding components
		this.add(hiddenCombi, BorderLayout.CENTER);


	}


	public void adjustContraints() {
		//			Adjust Constraints
		int vInset = (BarreMenu.menuWidth()-GrilleCouleurs.gridColorWidth())/2;
		int hInset = (this.getHeight()-Combinaison.combinaisonHeight())/2;
		this.setBorder(BorderFactory.createEmptyBorder(hInset,vInset,hInset,vInset));

	}
}
