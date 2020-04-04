import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.CompoundBorder;

@SuppressWarnings("serial")
public class PaletteCouleurs extends JPanel{

	JLabel titre;
	JPanel boutonsPannel;
	SpringLayout layout;
	private RoundButton[] boutonsSelection= new RoundButton[Mastermind.nbrCouleurs];


	public PaletteCouleurs(){
		//			Panel Setup
		this.setLayout(new BorderLayout());
		this.setBackground(Color.pink);
		layout = new SpringLayout();
		this.setLayout(layout);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				adjustContraints();
				revalidate();
				repaint();

			}
		});


		//		Components creation and adding
		//Titre
		titre = new JLabel("Couleurs", JLabel.CENTER);
		titre.setOpaque(false);
		titre.setForeground(Color.red);
		titre.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				titre.setFont(new Font("Serif", Font.PLAIN, RoundButton.boutonRadius()));
				titre.repaint();
			}
		});

		this.add(titre);


		//Boutons Selection

		for(int i=0; i<Mastermind.nbrCouleurs; i++) {
			this.add(boutonsSelection[i] = new RoundButton(Mastermind.couleurs[i]));
		}




	}


	public void adjustContraints() {


		//			Adjust Constraints
		boutonsContraints();

		// 		carreValide Constrains
		//layout.putConstraint(SpringLayout.NORTH, carreValide, 25, SpringLayout.NORTH, this);
		//layout.putConstraint(SpringLayout.SOUTH, carreValide, -25, SpringLayout.SOUTH, this);
		//layout.putConstraint(SpringLayout.EAST, carreValide, -RoundButton.boutonRadius(), SpringLayout.WEST, grilleCouleurs);



		

		//boutonsLayout =new FlowLayout(FlowLayout.CENTER, hInset, vInset);
		this.setBorder(BorderFactory.createEmptyBorder(vInset(),0,0,0));
		titre.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, titre.getHeight()*3/2, 0, titre.getHeight()*3/2), BorderFactory.createLineBorder(Color.red)));
		//boutonsPannel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

	}
	
	public void boutonsContraints() {
		//			Boutons Constraints
		for(int i=0; i<Mastermind.nbrCouleurs; i++) {
			
			int vContraint = vInset()+(i/boutonsPerLine())*(vInset()+RoundButton.boutonRadius());
			int hContraint = hInset()+(i%boutonsPerLine())*(hInset()+RoundButton.boutonRadius());
			
			layout.putConstraint(SpringLayout.NORTH, boutonsSelection[i], vContraint, SpringLayout.SOUTH, titre);
			layout.putConstraint(SpringLayout.WEST, boutonsSelection[i], hContraint, SpringLayout.WEST, titre);
		}

	}




	public int hInset() {
		int hInset = (BarreMenu.menuWidth()-RoundButton.boutonRadius()*boutonsPerLine())/(boutonsPerLine()+1);
		return hInset;
	}
	
	public int vInset() {
		int vInset = (int) Math.round((BarreMenu.singleMenuHeight()-RoundButton.boutonRadius()*7.0/2.0)/4.0);
		return vInset;
	}
	
	public int boutonsPerLine() {
		int boutonsPerLine = (int)Math.round(Mastermind.nbrCouleurs/2.0);
		return boutonsPerLine;
	}




}



