import java.awt.*;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	CellStateArray generation;
	GenerationCalculator gc;
	final static int TIME_INTERVAL = 500;
	public final static int WIDTH = 4;
	public final static int HEIGHT = 4;

	private int cellCount;
	private int generationCount;
	private boolean mouseDown;

	public GamePanel(CellStateArray gen) {
		cellCount = 0;
		generationCount = 0;
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

	public void setMouseDown(boolean m) {
		mouseDown = m;
	}

	public void startUpdateThread() {
		new Thread(() -> {
			generationCount = 0;
			for (;;) {
				try {
					Thread.sleep(mouseDown ? 20 : TIME_INTERVAL);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				generation = gc.calculateNextGen();
				setGenerationCalculator(generation);
				for (int i = 0; i < generation.getCellStates().length; i++) {
					for (int j = 0; j < generation.getCellStates()[0].length; j++) {
						if (generation.getCellStates()[i][j] == CellStateArray.ALIVE) {
							cellCount++;
						}
					}
				}
				generationCount++;
				repaint();
			}
		}).start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);

		g2d.setFont(new Font("Arial", Font.BOLD, 16));
		FontMetrics fm = g2d.getFontMetrics();
		g2d.drawString("Generation: " + generationCount, 10, 20);
		g2d.drawString("Cells: " + cellCount, 20 + fm.stringWidth("Generation: " + generationCount), 20);
		for (int i = 0; i < generation.getCellStates().length; i++) {
			for (int j = 0; j < generation.getCellStates()[0].length; j++) {
				if (generation.getCellStates()[i][j] == 1) {
					g2d.setColor(Color.GREEN);
				} else {
					g2d.setColor(Color.BLACK);
				}
				g2d.fillRect(i * 4, 50 + j * 4, WIDTH, HEIGHT);
			}
		}
		cellCount = 0;
	}
}
