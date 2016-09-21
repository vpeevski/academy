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
	
	public void generateRandom (int rowExcl, int colExcl, BoardPanel boardPanel) {
		
		for (int i = 0; i < _minesCount; i++) {
			
			Mine mine;
			int randRow;
			int randCol;
			do {
				randRow = randomRow();
				randCol = randomCol();
				
				mine = new Mine(randRow, randCol, boardPanel);
				
			} while ((rowExcl == randRow && colExcl == randCol) || boardPanel.getField(randRow, randCol).isMine()); 
			
			boardPanel.getField(randRow, randCol).setItem(mine);
		}
		
	}
	
	private int randomRow () {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(_rows);
	}
	
	private int randomCol () {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(_cols);
	}
	
}
