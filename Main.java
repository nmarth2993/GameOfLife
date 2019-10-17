import java.awt.Dimension;

import javax.swing.*;

public class Main {
	JFrame frame;
	GamePanel panel;

	public Main() {
		frame = new JFrame();
		panel = new GamePanel();
		panel.setPreferredSize(new Dimension(400, 400));

		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame.setDefaultLookAndFeelDecorated(true);
			new Main();
		});
	}
}
