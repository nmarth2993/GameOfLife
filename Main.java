import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class Main {

	JFrame frame;
	GamePanel panel;

	public Main() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int[][] pattern = setPattern("glider");

		panel = new GamePanel(new CellStateArray(true));
		panel.setPreferredSize(new Dimension(400, 450));
		panel.startUpdateThread();
		panel.addMouseListener(new MListen());
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

	private int[][] setPattern(String pattern) {
		int[][] grid = new int[100][100];

		if (pattern.equals("block")) {
			grid[0][0] = CellStateArray.ALIVE;
			grid[0][1] = CellStateArray.ALIVE;
			grid[1][0] = CellStateArray.ALIVE;
			grid[1][1] = CellStateArray.ALIVE;
		} else if (pattern.equals("beehive")) {
			grid[0][1] = CellStateArray.ALIVE;
			grid[1][0] = CellStateArray.ALIVE;
			grid[2][1] = CellStateArray.ALIVE;
			grid[0][2] = CellStateArray.ALIVE;
			grid[2][0] = CellStateArray.ALIVE;
			grid[1][3] = CellStateArray.ALIVE;
		} else if (pattern.equals("tub")) {
			grid[0][2] = 1;
			grid[1][1] = 1;
			grid[1][3] = 1;
			grid[2][2] = 1;
		} else if (pattern.equals("blinker")) {
			grid[0][1] = CellStateArray.ALIVE;
			grid[1][1] = CellStateArray.ALIVE;
			grid[2][1] = CellStateArray.ALIVE;
		} else if (pattern.equals("toad")) {
			grid[0][1] = CellStateArray.ALIVE;
			grid[0][2] = CellStateArray.ALIVE;
			grid[0][3] = CellStateArray.ALIVE;
			grid[1][0] = CellStateArray.ALIVE;
			grid[1][1] = CellStateArray.ALIVE;
			grid[1][2] = CellStateArray.ALIVE;
		} else if (pattern.equals("glider")) {
			grid[0][0] = CellStateArray.ALIVE;
			grid[1][1] = CellStateArray.ALIVE;
			grid[2][0] = CellStateArray.ALIVE;
			grid[2][1] = CellStateArray.ALIVE;
			grid[1][2] = CellStateArray.ALIVE;
		} else if (pattern.equals("pentaD")) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 8; j++) {
					if (i == 1 && j == 1) {
						continue;
					}
					if (i == 7 && j == 1) {
						continue;
					}
					grid[45 + i][45 + j] = CellStateArray.ALIVE;
				}
			}
		}

		return grid;
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
