package projects.minesweeper;

public class MineSweeperModel {
	
	private Item[][] _model;
	
	private final int _minesCount;
	
	public MineSweeperModel (int rows, int cols, int minesCount) {
		_model = new Item [rows][cols];
		MinePosRandomGen minesGenerator = new MinePosRandomGen(rows, cols, minesCount);
		Mine[] mines = minesGenerator.generateRandom();
		putMinesInModel(mines);
		calculateFullModel();
		_minesCount = minesCount;
		
	}
	
	private void calculateFullModel() {
		for (int i = 0; i < _model.length; i++) {
			for (int j = 0; j < _model[0].length; j++) {
				if(_model[i][j] == null) {
					int minesNeighboursCount = countMinesNeighbours(i, j);
					if (minesNeighboursCount > 0) {
						_model[i][j] = new NumericItem(i, j, minesNeighboursCount, this);
					} else {
						_model[i][j] = new EmptyItem(i, j, this);
					}
					
				}
			}
		}
		
	}

	private int countMinesNeighbours(int i, int j) { //TODO Refactor this method to use Item.neighbours()
		int minesCount = 0;
		
		int upRow = i - 1;
		int bottomRow = i + 1;
		int leftCol = j - 1;
		int rightCol = j + 1;
		if (upRow >= 0) {
			if (leftCol >= 0) {
				if (_model[upRow][leftCol] instanceof Mine) {
					minesCount ++;
				}
			}
			
			if (_model[upRow][j] instanceof Mine) {
				minesCount ++;
			}
			
			if (rightCol < _model[0].length) {
				if (_model[upRow][rightCol] instanceof Mine) {
					minesCount ++;
				}
			}
			
		}
		
		if (bottomRow < _model.length) {
			if (leftCol >= 0) {
				if (_model[bottomRow][leftCol] instanceof Mine) {
					minesCount ++;
				}
			}
			
			if (_model[bottomRow][j] instanceof Mine) {
				minesCount ++;
			}
			
			if (rightCol < _model[0].length) {
				if (_model[bottomRow][rightCol] instanceof Mine) {
					minesCount ++;
				}
			}
			
		}
		
		if(leftCol >= 0) {
			if (_model[i][leftCol] instanceof Mine) {
				minesCount ++;
			}
		}
		
		if(rightCol < _model[0].length) {
			if (_model[i][rightCol] instanceof Mine) {
				minesCount ++;
			}
		}
		
		return minesCount;
	}

	private void putMinesInModel (Mine[] mines) {
		for (int i = 0; i < mines.length; i++) {
			Mine currentMine = mines[i];
			_model[currentMine.row()][currentMine.col()] = currentMine;
		}
	}
	
	public int rows () {
		return _model.length;
	}
	
	public int cols () {
		return _model[0].length;
	}
	
	public int minesCount () {
		return _minesCount;
	}
	
	public Item getItem (int row, int col) {
		return _model[row][col];
	}
	

}
