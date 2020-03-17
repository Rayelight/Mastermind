import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CarreEval extends JPanel{
	CarreEval(){
		this.setLayout(new GridLayout(Mastermind.nbrTentatives, 1, 10, 10));
		this.setBackground(Color.yellow);

		JLabel[] tentatives = new JLabel[Mastermind.nbrTentatives];
		for(int i=0; i<Mastermind.nbrTentatives; i++) {
			this.add(tentatives[i]=new JLabel("A", JLabel.CENTER) );
			tentatives[i].setBackground(Color.blue);
			tentatives[i].setOpaque(true);
		}
	}
	@Override
	public Dimension getPreferredSize(){
		Insets insets = Mastermind.general.getInsets();
		int height = Mastermind.general.getHeight()-insets.top-insets.bottom;
		int carreEvalHeight = height-40;
		int boutonsRadius = (height-40-5*Mastermind.nbrTentatives)/Mastermind.nbrTentatives; 
		return new Dimension(boutonsRadius-5, carreEvalHeight);

	}
}
