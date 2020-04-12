import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class PaletteCouleurs extends JPanel implements ActionListener{

	private JLabel titre;
	private SpringLayout layout;
	private RoundButton[] boutonsSelection= new RoundButton[Mastermind.nbrCouleurs];
	private ButtonGroup boutonsGroup = new ButtonGroup();


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
		titre = new JLabel("Palette Couleurs", JLabel.CENTER){
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(RoundButton.boutonRadius()*Mastermind.tailleCombinaison,RoundButton.boutonRadius());
			}
		};
		titre.setOpaque(false);
		titre.setForeground(Color.red);
		titre.setBorder(BorderFactory.createLineBorder(Color.red));
		titre.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				titre.setFont(new Font("Serif", Font.PLAIN, (int) (titre.getWidth()/8.0)));
				titre.revalidate();
				titre.repaint();
			}
		});

		this.add(titre);


		//Boutons Selection

		for(int i=0; i<Mastermind.nbrCouleurs; i++) {
			this.add(boutonsSelection[i] = new RoundButton(Mastermind.couleurs[i]));
			boutonsSelection[i].addActionListener(this);
			boutonsGroup.add(boutonsSelection[i]);
		}




	}


	public void adjustContraints() {
		
		//			Adjust Constraints
		boutonsContraints();

		// 		titre
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titre, 0, SpringLayout.HORIZONTAL_CENTER, this);
		layout.putConstraint(SpringLayout.NORTH, titre, vInset(), SpringLayout.NORTH, this);

	}
	
	public void boutonsContraints() {
		//			Boutons Constraints
		for(int i=0; i<Mastermind.nbrCouleurs; i++) {
			
			int vContraint = vInset()+(i/boutonsPerLine())*(vInset()+RoundButton.boutonRadius());
			int hContraint = hInset()+(i%boutonsPerLine())*(hInset()+RoundButton.boutonRadius());
			
			layout.putConstraint(SpringLayout.NORTH, boutonsSelection[i], vContraint, SpringLayout.SOUTH, titre);
			layout.putConstraint(SpringLayout.WEST, boutonsSelection[i], hContraint, SpringLayout.WEST, this);
		}

	}




	public int hInset() {
		int hInset = (BarreMenu.menuWidth()-RoundButton.boutonRadius()*boutonsPerLine())/(boutonsPerLine()+1);
		return hInset;
	}
	
	public int vInset() {
		int vInset = (int) Math.round((BarreMenu.singleMenuHeight()-RoundButton.boutonRadius()*3.0)/4.0);
		return vInset;
	}
	
	public int boutonsPerLine() {
		int boutonsPerLine = (int)Math.round(Mastermind.nbrCouleurs/2.0);
		return boutonsPerLine;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		RoundButton selectedBouton = (RoundButton)e.getSource();
		boutonsGroup.setSelected(selectedBouton.getModel(), true);
		Mastermind.getPanneauJeu().setSelectedColor(selectedBouton.getCouleur());
		
	}





}



