import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.LinearGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Point2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CarreEval extends JPanel{

	JLabel[] tentatives;
	boolean typePresence;

	CarreEval(boolean typePresence){
		this.setLayout(new GridLayout(Mastermind.nbrTentatives, 1, 10, 10));
		this.setBackground(Color.yellow);
		this.setOpaque(false);

		this.typePresence = typePresence;

		tentatives = new JLabel[Mastermind.nbrTentatives];
		for(int i=Mastermind.nbrTentatives-1; i>=0; i--) {
			this.add(tentatives[i]=new Carre());
		}
	}

	@Override
	public Dimension getPreferredSize(){
		return new Dimension(RoundButton.boutonRadius()-5, GrilleCouleurs.gridColorHeight());
	}

	class Carre extends JLabel {
		Carre(){
			super("", JLabel.CENTER);
			this.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					setFont(new Font("Serif", Font.BOLD, getHeight()*5/12));
					repaint();
				}
			});
			this.setBorder(BorderFactory.createLineBorder(Color.black));
			this.setOpaque(false);
		}


		@Override
		public Color getBackground() {
			if(typePresence) {
				return Color.red;
			}
			return Color.green;
		}
		protected void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			//LinearGradientPaint
			Point2D start = new Point2D.Float(getWidth()/4, getHeight()/4);
			Point2D end = new Point2D.Float(getWidth()*5/4, getHeight()*5/4);
			float[] dist = {0.25f, 1.0f};
			Color[] colors = {getBackground(), new HSLColor(getBackground()).adjustTone(80)};
			LinearGradientPaint p =
					new LinearGradientPaint(start, end, dist, colors);

			g2d.setPaint(p);
			g2d.fillRect(0, 0, getWidth(), getHeight()); 
			super.paintComponent(g);
		}


	}
}
