import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class  Regles extends JDialog{




	public  Regles(){

		super(Mastermind.getGeneral(), "Régles", true);

		//			Parametrage JDialog
		this.setResizable(true);
		this.setBackground(Color.red);
		this.setSize(Mastermind.generalHeight()*2/3, Mastermind.generalHeight()/3);
		this.setContentPane(new PanneauRegles());
		this.setLocationRelativeTo(Mastermind.getGeneral());


		this.setVisible(true);
	}

	public void dispose() {
		this.setVisible(false);
	}

	public int height() {
		return Mastermind.generalHeight()*2/3;
	}

	public int width() {
		return Mastermind.generalHeight()/3;
	}


	private class PanneauRegles extends GradientPanel implements ActionListener{

		JTextArea texte;

		PanneauRegles(){


			texte = new JTextArea(){
				@Override
				public Dimension getPreferredSize() {
					return new Dimension(width(), height());
				}
			};

			texte.setWrapStyleWord(true);
			texte.setLineWrap(true);
			texte.setText("Le principe de fonctionnement du jeu est de trouver la combinaison de couleur cachée en haut à droite du panneau. "
					+ "Pour cela, vous pouvez jouer avec les différents boutons dans la palette de couleurs. "
					+ "\nL’utilisation des boutons se fait par un clic sur la couleur de votre choix puis vous cliquer sur le bouton en bas à gauche de la grille. "
					+ "\nEnsuite vous continuer avec ce même principe vers la droite. Vous obtiendriez votre première tentative lorsque vous auriez rempli toute la ligne de boutons. "
					+ "\nDe plus, avec les différents compteurs vous pourriez avoir des informations sur les couleurs présentes dans la combinaison cachée. "
					+ "\nDe plus, vous avez en bas à droite un panneau de boutons qui vous permet d’avoir des fonctionnalités comme le panneau règles, le mode options et le mode ordinateur que je vais vous expliquer."
					+ "\nVous avez le même principe dans le panneau juste au-dessus pour avoir des informations sur votre avancée et des fonctionnalités de boutons pour redémarrer une partie ou d’avoir la solution de la combinaison. "
					+ "\nLe mode ordinateur est une résolution de jeu de manière numérique. Si vous voulez utiliser ce mode il vous suffira de cliquer sur le bouton. Pour donner suite à cette appui le mode se mettra en route avec la résolution de la tentative. Vous auriez donc l’affichage des tentatives sur le panneau jeu. "
					+ "\nA la fin de votre partie, vous auriez un panneau de fin qui vous annonce votre résultat aux jeux avec des précisions si vous réussissez à trouver la combinaison cachée."
					);

			texte.setEditable(false);
			texte.setForeground(Mastermind.darkMode?Color.decode("#D3CEBA"):Color.black);
			texte.setBackground(Color.black);
			texte.setFont(new Font("Serif", Font.BOLD, 20));
			texte.setOpaque(false);
			Color borderColor = Mastermind.darkMode?Color.decode("#484321"):Color.white;
			texte.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(borderColor, 2, true),
					BorderFactory.createEmptyBorder(10,10,10,10)));
			

			this.add(texte);
		}




		public void adjustContraints() {
			//			Adjust Constraints
			layout.putConstraint(SpringLayout.NORTH,  texte, 10, SpringLayout.NORTH, this);
			layout.putConstraint(SpringLayout.EAST, texte, -10, SpringLayout.EAST, this);
			layout.putConstraint(SpringLayout.SOUTH, texte, -10, SpringLayout.SOUTH, this);
			layout.putConstraint(SpringLayout.WEST,  texte, 10, SpringLayout.WEST, this);



		}


		@Override
		public void actionPerformed(ActionEvent e) {


			dispose();
		}

	}

}