package projects.minesweeper;

import javax.swing.JPanel;

public abstract class AbstractItem implements Item {
	
	protected final int _row;
	
	protected final int _col;
	
	protected BoardPanel _boardPanel;

	public AbstractItem (int row, int col, BoardPanel boardPanel) {
		_row = row;
		_col = col;
		_boardPanel = boardPanel;
	}
	@Override
	public int row () {
		return _row;
	}
	@Override
	public int col () {
		return _col;
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || ! (obj instanceof Mine)) {
			return false;
		}
		
		AbstractItem that = (AbstractItem) obj;
		
		return that._col == _col && that._row == _row;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 1;
		hashCode = 31*hashCode + _col;
		hashCode = 31*hashCode + _row;
		return hashCode;
	}

	
	
	protected final void simpleOpenField() {
		_boardPanel.getField(_row, _col).openField();
	}
	
	protected void setBackGround (JPanel panel) {}
 
}
