package cuki;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;

import javax.swing.*;

public class Draw extends JApplet {

	private static final long serialVersionUID = 1L;
	public static int tamanhoCaixaHeight;
	public static int tamanhoCaixaWidth;

	public void init() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
	}

	public void paint(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		Double x, y, rad;
		int hip, angulo = -45;

		tamanhoCaixaHeight = getSize().height;
		tamanhoCaixaWidth = getSize().width;
		if (tamanhoCaixaHeight <= tamanhoCaixaWidth)
			hip = tamanhoCaixaHeight;
		else
			hip = tamanhoCaixaWidth;
		rad = angulo * Math.PI / 180;
		y = Math.sin(rad) * hip;
		y += tamanhoCaixaHeight / 2;
		x = Math.cos(rad) * hip;
		x += tamanhoCaixaWidth / 2;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.draw(new Line2D.Double(tamanhoCaixaWidth / 2,
				tamanhoCaixaHeight / 2, x, y));
		g2.draw(new Ellipse2D.Double((tamanhoCaixaWidth - hip) / 2,
				(tamanhoCaixaHeight - hip) / 2, hip - 1, hip - 1));

		g2.drawString("X: " + x, 0, 10);
		g2.drawString("Y: " + y, 0, 20);
		g2.drawString("Hip: " + hip, 0, 30);
		g2.drawString("Ang: " + angulo, 0, 40);
		g2.drawString("Height: " + tamanhoCaixaHeight, 0, 50);
		g2.drawString("Width: " + tamanhoCaixaWidth, 0, 60);
		g2.drawString("Centro: " + tamanhoCaixaWidth / 2 + " "
				+ tamanhoCaixaHeight / 2, 0, 70);
		// g2.draw(new Ellipse2D.Double(0, 0, 50, 50));
	}
}
