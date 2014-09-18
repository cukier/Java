package cuki.example;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeel {

	public static void main(String[] args) {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
				System.out.println(info.getName());
			}
		} catch (Exception e) {
		}

		JFrame frame = new JFrame();
		frame.setSize(450, 300);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		frame.setContentPane(contentPane);

		for (int cont = 0; cont < 5; cont++) {

			JLabel label = new JLabel("Label");
			contentPane.add(label);

			JButton btn = new JButton("Botao");
			contentPane.add(btn);
		}
		frame.setSize(116, 200);
		// frame.pack();
		frame.setVisible(true);

	}
}
