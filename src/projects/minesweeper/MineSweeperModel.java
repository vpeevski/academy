package projects.minesweeper;

public class MineSweeperModel {
	
	private Item[][] _model;
	
	private final int _minesCount;
	
	public MineSweeperModel (int rowExcl, int colExcl, BoardPanel boardPanel) {
		_model = new Item [boardPanel.get_rows()][boardPanel.get_cols()];
		MinePosRandomGen minesGenerator = new MinePosRandomGen(boardPanel.get_rows(), boardPanel.get_cols(), boardPanel.get_minesCount());
		Mine[] mines = minesGenerator.generateRandom(rowExcl, colExcl, boardPanel);
		putMinesInModel(mines, boardPanel);
		calculateFullModel(boardPanel);
		_minesCount = boardPanel.get_minesCount();
		
	}
	
	private void calculateFullModel(BoardPanel boardPanel) {
		for (int i = 0; i < _model.length; i++) {
			for (int j = 0; j < _model[0].length; j++) {
				if(_model[i][j] == null) {
				        Item newItem = new NumericItem(i, j, boardPanel);
						_model[i][j] = newItem;	
						boardPanel.getField(i, j).setItem(newItem);
				}
			}
		}
		
	}

	private void putMinesInModel (Mine[] mines, BoardPanel boardPanel) {
		for (int i = 0; i < mines.length; i++) {
			Mine currentMine = mines[i];
			_model[currentMine.row()][currentMine.col()] = currentMine;
			boardPanel.getField(currentMine.row(), currentMine.col()).setItem(currentMine);
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
