import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	public final static int WIDTH = 4;
	public final static int HEIGHT = 4;

	public void startUpdateThread() {
		new Thread(() -> {
			for (;;) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillRect(4, 4, WIDTH, HEIGHT);
	}
}
