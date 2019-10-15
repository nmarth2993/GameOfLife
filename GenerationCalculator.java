
public class GenerationCalculator {
	private CellStateArray currentGen;
	private CellStateArray nextGen;

	public GenerationCalculator(CellStateArray currentGen) {
		this.currentGen = currentGen;
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


		//make sure the array is toroidal

		this.nextGen = nextGen;
		return nextGen;
	}

	private int checkNeighbors(int i, int j) {
		boolean live = getCurrentGen().getCellStates()[i][j] == 1;
		int neighbors = 0;

		
		
		/*
		Any live cell with fewer than two live neighbours dies, as if by underpopulation.
	    Any live cell with two or three live neighbours lives on to the next generation.
	    Any live cell with more than three live neighbours dies, as if by overpopulation.
	    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
		 */

		//		currentGen.getCellStates()[i - 1][];
		return 0;
	}
}
