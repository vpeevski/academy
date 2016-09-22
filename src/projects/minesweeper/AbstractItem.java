package projects.minesweeper;

public abstract class AbstractItem implements Item {
	
	protected final int _row;
	
	protected final int _col;
	
	protected BoardPanel _boardPanel;

	public AbstractItem (int row, int col, BoardPanel boardPanel) {
		_row = row;
		_col = col;
		_boardPanel = boardPanel;
	}
 
}
