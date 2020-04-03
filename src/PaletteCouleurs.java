import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

@SuppressWarnings("serial")
public class PaletteCouleurs extends JPanel{

	JLabel titre;
	JPanel boutonsPannel;
	FlowLayout boutonsLayout = new FlowLayout(FlowLayout.CENTER, 20, 10);

	private Thread t;

	public PaletteCouleurs(){
		//			Panel Setup
		this.setLayout(new BorderLayout());
		this.setBackground(Color.pink);
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				t = new Thread(new Resized());
				t.start();

			}
		});


		//		Components creation
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



		//Boutons Pannel
		boutonsPannel = new JPanel();
		boutonsPannel.setBackground(Color.yellow);
		boutonsPannel.setLayout(boutonsLayout);
		boutonsPannel.setOpaque(true);
		for(int i=0; i<Mastermind.nbrCouleurs; i++) {
			boutonsPannel.add(new RoundButton(Mastermind.couleurs[i]));
		}



		//			Adding components
		this.add(titre, BorderLayout.PAGE_START);
		this.add(boutonsPannel, BorderLayout.CENTER);


	}


	public void adjustContraints() {

		//			Adjust Constraints


		int hInset = hInset();
		int vInset = (BarreMenu.singleMenuHeight()-3*RoundButton.boutonRadius())/4;

		boutonsLayout.setVgap(vInset);
		boutonsLayout.setHgap(hInset);
		this.setBorder(BorderFactory.createEmptyBorder(vInset,0,0,0));
		titre.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(0, titre.getHeight()*3/2, 0, titre.getHeight()*3/2), BorderFactory.createLineBorder(Color.red)));
		//boutonsPannel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

		//System.out.println(hInset);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.repaint();


	}



	public int hInset() {
		int boutonPerLine = (int)Math.round(Mastermind.nbrCouleurs/2.0);
		int hInset = (BarreMenu.menuWidth()-RoundButton.boutonRadius()*boutonPerLine)/(boutonPerLine+1);
		return hInset;
	}


	class Resized implements Runnable{
		public void run() {
			adjustContraints();                   
		}               
	}    


}



