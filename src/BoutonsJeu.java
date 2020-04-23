import java.awt.Color;
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
	private SpringLayout layout;
	static int nombreBoutons=4;

	public BoutonsJeu(){

		//			Panel Setup 
		layout = new SpringLayout();
		this.setLayout(layout);
		this.setBackground(Color.blue);
		this.setOpaque(true);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
			}
		});



		//			Components creation



		//		boutonsJeu
		boutonsJeu = new JButton[nombreBoutons];

		//	Creation Boutons
		boutonsJeu[0] = boutonJeu("Mode Ordi.");
		boutonsJeu[1] = boutonJeu("Règles");
		boutonsJeu[2] = boutonJeu("Options");
		boutonsJeu[3] = boutonJeu("Aides");





		//				Adding Components
		//		Ajout des boutons centreaux
		for(JButton b : boutonsJeu) {
			this.add(b);
		}



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
		JButton bouton = new JButton(texte){
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(boutonsWidth(), boutonsHeight());
			}
		};
		bouton.setBackground(Color.cyan);
		bouton.setForeground(Color.black);
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


	public int boutonsWidth() {
		int boutonWidth = (int) Math.round((BarreMenu.menuWidth()-40-20)/2.0);
		return boutonWidth;
	}

	public int boutonsHeight() {
		int boutonWidth = (int) Math.round(BarreMenu.singleMenuHeight()/6.5);
		return boutonWidth;

	}
	
	public int vGap() {
		int boutonWidth = (int) Math.round(boutonsHeight()*1.5);
		return boutonWidth;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}