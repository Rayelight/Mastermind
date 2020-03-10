import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;


@SuppressWarnings("serial")
class RoundButton extends JButton {
  public RoundButton(int radius) {
    Dimension size = getPreferredSize();
    //size.width = size.height = Math.max(size.width,size.height);
    size.width = size.height=radius;
    setPreferredSize(size);

    setContentAreaFilled(false);
  }

  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
      g.setColor(Color.lightGray);
    } else {
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width, getSize().height);
  }

  protected void paintBorder(Graphics g) {
    g.setColor(getForeground());
    g.drawOval(0, 0, getSize().width, getSize().height);
  }

  Shape shape;
  public boolean contains(int x, int y) {
    if (shape == null || !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }

}

