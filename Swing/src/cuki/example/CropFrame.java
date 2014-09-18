package cuki.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CropFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImagePane cropedPanel = null;
	private BufferedImage src = null;
	private BufferedImage cropedImage = null;
	private JButton btn = null;
	private Rectangle cropedRectangle = null;
	private JTextField distX;
	private JTextField distY;

	public static void main(String[] args) {
		new CropFrame(250, 250);
	}

	public CropFrame(int x, int y) {

		cropedRectangle = new Rectangle(x, y, 30, 30);

		try {
			src = ImageIO.read(this.getClass().getResource(
					"/brankic1979-icon-set.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 250);
		getContentPane().setLayout(new BorderLayout());

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);

		btn = new JButton("Next");
		btn.addActionListener(this);
		bar.add(btn);

		distX = new JTextField(String.valueOf(x));
		distX.addActionListener(this);
		bar.add(distX);
		distX.setColumns(10);

		distY = new JTextField(String.valueOf(y));
		distY.addActionListener(this);
		bar.add(distY);
		distY.setColumns(10);

		try {
			cropedImage = cropImage(src, cropedRectangle);
		} catch (Exception e) {
			e.printStackTrace();
		}

		cropedPanel = new ImagePane(cropedImage);
		cropedPanel.setBackground(Color.BLACK);
		getContentPane().add(cropedPanel);

		setLocationRelativeTo(null);
		setSize(200, 200);
		setVisible(true);

	}

	public BufferedImage cropImage(BufferedImage img, Rectangle rectangle)
			throws Exception {

		BufferedImage clipped = null;

		if (rectangle.width < img.getWidth()
				&& rectangle.height < img.getHeight()) {
			setRectange(rectangle.x, rectangle.y, rectangle.width,
					rectangle.height);
			try {
				clipped = img.getSubimage(rectangle.x, rectangle.y,
						rectangle.width, rectangle.height);
			} catch (RasterFormatException e) {
				throw new Exception();
			}
		} else
			throw new Exception();

		return clipped;
	}

	public void setRectange(int x, int y, int width, int height) {
		this.cropedRectangle.x = x;
		this.cropedRectangle.y = y;
		this.cropedRectangle.width = width;
		this.cropedRectangle.height = height;
	}

	private void setCropedImage(Rectangle rect) {
		BufferedImage img = null;
		try {
			img = cropImage(src, rect);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		cropedPanel.setImage(img);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Rectangle rect = null;

		if (e.getSource() == btn) {
			int x = cropedRectangle.x + 47;
			rect = new Rectangle(x, cropedRectangle.y, cropedRectangle.width,
					cropedRectangle.height);
			distX.setText(String.valueOf(x));
		} else if (e.getSource() == distX || e.getSource() == distY) {
			rect = new Rectangle(Integer.valueOf(distX.getText()),
					Integer.valueOf(distY.getText()), cropedRectangle.width,
					cropedRectangle.height);
		}

		if (rect != null) {
			setCropedImage(rect);
		}
	}

	private class ImagePane extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private BufferedImage image = null;

		public ImagePane(BufferedImage image) {
			this.image = image;
		}

		public void setImage(BufferedImage image) {
			this.image = image;
		}

		protected void paintComponent(Graphics g) {
			if (image != null) {
				g.drawImage(image, 0, 0, this);
			}
		}
	}

}