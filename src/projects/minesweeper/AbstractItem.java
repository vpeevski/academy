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
	
	protected final void simpleOpenField() {
		_boardPanel.getField(_row, _col).openField();
	}
	
	protected void setBackGround (JPanel panel) {}
 
}
