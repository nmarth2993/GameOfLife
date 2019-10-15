
public class GenerationCalculator {
	private CellStateArray currentGen;
	private CellStateArray nextGen;
	
	public GenerationCalculator(CellStateArray currentGen) {
		this.currentGen = currentGen;
	}
	
	public CellStateArray calculateNextGen() {
		CellStateArray nextGen = new CellStateArray(false);
		
		
		this.nextGen = nextGen;
		return nextGen;
	}
	
	private int checkNeighbors() {
		
		return 0;
	}
}
