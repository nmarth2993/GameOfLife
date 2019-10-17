import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class Main {
	JFrame frame;
	GamePanel panel;

	public Main() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int[][] a = new int[100][100];
//		a[0][0] = 1;
//		a[0][1] = 1;
//		a[1][0] = 1;
		// XXX: test data
		a[0][2] = 1;
		a[1][1] = 1;
		a[1][3] = 1;
		a[2][2] = 1;

		panel = new GamePanel(new CellStateArray(a));
		panel.setPreferredSize(new Dimension(400, 400));
		panel.startUpdateThread();
		panel.addMouseListener(new MListen());
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	class MListen implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			panel.setMouseDown(true);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setMouseDown(false);
		}

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

		});

	}
}
