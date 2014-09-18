package cuki.example;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Draw {

	public static void main(String[] args) {
		new Draw();
	}

	public Draw() {
		Janela janela = new Janela();
		janela.setEnd(100, 100);
		janela.setVisible(true);
	}

	private class Janela extends JFrame implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Surface panel = null;
		private JMenuBar menuBar = null;
		private JButton btn = null;

		public Janela() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(450, 450);
			setLocationRelativeTo(null);

			menuBar = new JMenuBar();
			setJMenuBar(menuBar);

			btn = new JButton("Next");
			btn.addActionListener(this);
			menuBar.add(btn);

			panel = new Surface(this.getSize());
			panel.setEnd(1, 100);
			add(panel);

		}

		public void setEnd(int x, int y) {
			panel.setEnd(x, y);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn) {
				Point2D aux = panel.getEnd();
				int xAux = (int) (aux.getX() + 10);
				int yAux = (int) (aux.getY() + 3);
				panel.setEnd(xAux, yAux);
				repaint();
			}

		}
	}

	private class Surface extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Point2D center = null;
		private Point2D end = null;

		public Surface(Dimension size) {
			center = new Point2D.Double(size.width / 2, size.height / 2);
		}

		public void setEnd(int d, int e) {
			end = new Point2D.Double(d, e);
			repaint();
		}

		public Point2D getEnd() {
			return this.end;
		}

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			Line2D line = new Line2D.Double(center.getX(), center.getY(),
					end.getX(), end.getY());
			g2.draw(line);
		}

	}

}
