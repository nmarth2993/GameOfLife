
public class GenerationCalculator {
	private CellStateArray currentGen;
	private CellStateArray nextGen;

	public GenerationCalculator(CellStateArray currentGen) {
		this.currentGen = currentGen;
		nextGen = null;
		calculateNextGen();
	}

	public CellStateArray getCurrentGen() {
		return currentGen;
	}

	public CellStateArray getNextGen() {
		return nextGen;
	}

	public CellStateArray calculateNextGen() {
		CellStateArray nextGen = new CellStateArray(false);
		int[][] cellStates = new int[100][100];
		int liveNeighbors;
		for (int i = 0; i < currentGen.getCellStates().length; i++) {
			for (int j = 0; j < currentGen.getCellStates()[0].length; j++) {
				liveNeighbors = checkNeighbors(i, j);
				if (liveNeighbors == 2 || liveNeighbors == 3) {
					cellStates[i][j] = CellStateArray.ALIVE;
				} else {
					cellStates[i][j] = CellStateArray.DEAD;
				}

				/*
				 * if (liveNeighbors < 2) { cellStates[i][j] = CellStateArray.DEAD; } else if
				 * (liveNeighbors == 2 || liveNeighbors == 3) { cellStates[i][j] =
				 * CellStateArray.ALIVE; } else { cellStates[i][j] = CellStateArray.DEAD; }
				 */

//				if (live) {
//					if (liveNeighbors < 2) {
//						cellStates[i][j] = CellStateArray.DEAD;
//					} else if (liveNeighbors == 2 || liveNeighbors == 3) {
//						// nothing happens except it lives on
//					} else {
//						cellStates[i][j] = CellStateArray.DEAD;
//					}
//				} else {
//					if (liveNeighbors == 3) {
//						cellStates[i][j] = CellStateArray.ALIVE;
//					}
//				}

				/*
				 * Any live cell with fewer than two live neighbours dies, as if by
				 * underpopulation. Any live cell with two or three live neighbours lives on to
				 * the next generation. Any live cell with more than three live neighbours dies,
				 * as if by overpopulation. Any dead cell with exactly three live neighbours
				 * becomes a live cell, as if by reproduction.
				 */
			}
		}

		nextGen.setCellStates(cellStates);

		this.nextGen = nextGen;
		return nextGen;
	}

	public int indexCheck(int index) {
		if (index < 0) {
			index = currentGen.getCellStates().length - 1;
		} else if (index > currentGen.getCellStates().length - 1) {
			index = 0;
		}
		return index;
	}

	public int checkNeighbors(int l1, int l2) {
		int liveNeighbors = 0;

		for (int i = l1 - 1; i < l1 + 2; i++) {
			for (int j = l2 - 1; j < l2 + 2; j++) {
				if (i == l1 && j == l2) {
					continue;
				} else {
					if (currentGen.getCellStates()[indexCheck(i)][indexCheck(j)] == 1) {
						liveNeighbors++;
					}
				}
			}
		}
		return liveNeighbors;
	}
}
