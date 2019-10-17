import java.awt.Dimension;

import javax.swing.*;

public class Main {
	JFrame frame;
	GamePanel panel;

	public Main() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new GamePanel(new CellStateArray(true));
		panel.setPreferredSize(new Dimension(400, 400));
		panel.startUpdateThread();
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	public void startUpdateGenerationThread() {
		new Thread(() -> {
			for (;;) {
				System.out.println("do something");
			}
		}).start();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame.setDefaultLookAndFeelDecorated(true);
			Main m = new Main();
			GenerationCalculator gc = new GenerationCalculator(m.panel.getGeneration());
			m.panel.setGeneration(gc.calculateNextGen());

		});

	}
}
