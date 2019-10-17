import java.awt.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	CellStateArray generation;
	GenerationCalculator gc;
	final static int TIME_INTERVAL = 500;
	public final static int WIDTH = 4;
	public final static int HEIGHT = 4;

	public GamePanel(CellStateArray gen) {
		setGeneration(gen);
		setGenerationCalculator(gen);
	}

	private void setGenerationCalculator(CellStateArray gen) {
		gc = new GenerationCalculator(gen);
	}

	public void setGeneration(CellStateArray gen) {
		this.generation = gen;
	}

	public CellStateArray getGeneration() {
		return generation;
	}

	public void startUpdateThread() {
		new Thread(() -> {
			for (;;) {
				try {
					Thread.sleep(TIME_INTERVAL);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				generation = gc.calculateNextGen();
				setGenerationCalculator(generation);
				repaint();
			}
		}).start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		for (int i = 0; i < 100; i++) {
			g.drawLine(i * 10, 0, i * 10, getHeight());
		}
		for (int i = 0; i < 100; i++) {
			g.drawLine(0, i * 10, getWidth(), i * 10);
		}
		g.setColor(Color.BLACK);
		for (int i = 0; i < generation.getCellStates().length; i++) {
			for (int j = 0; j < generation.getCellStates()[0].length; j++) {
				if (generation.getCellStates()[i][j] == 1) {
					g.setColor(Color.RED);
				} else {
					g.setColor(Color.BLACK);
				}
				g.fillRect(i * 4, j * 4, WIDTH, HEIGHT);
			}
		}
	}
}
