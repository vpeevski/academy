package projects.minesweeper;

import java.util.Random;

public final  class MinePosRandomGen {
	
	private int _rows;

	private int _cols;

	private int _minesCount;
	
	public MinePosRandomGen (int rows, int cols, int minesCount) {
		_rows = rows;
		_cols = cols;
		_minesCount = minesCount;
	}
	
	public Mine[] generateRandom (int rowExcl, int colExcl, BoardPanel boardPanel) {
		Mine[] mines = new Mine[_minesCount];
		for (int i = 0; i < mines.length; i++) {
			
			Mine mine;
			int randRow;
			int randCol;
			do {
				randRow = randomRow();
				randCol = randomCol();
				
				mine = new Mine(randRow, randCol, boardPanel);
				
			} while ((rowExcl == randRow && colExcl == randCol) || allreadyExists(mine, mines)); 
			
			
			mines[i] = mine;
		}
		return mines;
	}
	
	private int randomRow () {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(_rows);
	}
	
	private int randomCol () {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(_cols);
	}
	
	private boolean allreadyExists (Mine mine, Mine[] mines) {
		boolean exists = false;
		for (int i = 0; i < mines.length; i++) {
			if (mine.equals(mines[i])) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	

}
