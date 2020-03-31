import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CarreEval extends JPanel{
	CarreEval(){
		this.setLayout(new GridLayout(Mastermind.nbrTentatives, 1, 10, 10));
		this.setBackground(Color.yellow);
		this.setOpaque(false);

		JLabel[] tentatives = new JLabel[Mastermind.nbrTentatives];
		for(int i=Mastermind.nbrTentatives-1; i>=0; i--) {
			this.add(tentatives[i]=new JLabel("A", JLabel.CENTER) );
			tentatives[i].setBackground(Color.blue);
			tentatives[i].setOpaque(true);
		}
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(RoundButton.boutonRadius()-5, GrilleCouleurs.gridColorHeight());
	}
}
