import java.util.Random;

public class CellStateArray {
	private int[][] cellStates;
	
	public CellStateArray(boolean random) {
		cellStates = new int[100][100];
		if (random) {
			Random r = new Random();

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					cellStates[i][j] = r.nextInt(2);
				}
			}
		}
	}
	
	public int[][] getCellStates() {
		return cellStates;
	}
	
	public static void main(String[] args) {
		int[][] a = new CellStateArray(true).getCellStates();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
