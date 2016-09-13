package projects.minesweeper;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class AbstractItem implements Item {
	
	private final int _row;
	
	private final int _col;
	
	private MineSweeperModel _model;
	
	protected boolean _isOpen;
	
	private BoardPanel _boardPanel;
	
	private boolean _isFlagged;
	
	protected JPanel _currentPanel;

	public AbstractItem (int row, int col, MineSweeperModel model, BoardPanel boardPanel) {
		_row = row;
		_col = col;
		_model = model;
		_isOpen = false;
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
	
	@Override
	public List<Item> neighbours() {
		List<Item> neighboursList = new ArrayList<Item>();

		
		int upRow = _row - 1;
		int bottomRow = _row + 1;
		int leftCol = _col - 1;
		int rightCol = _col + 1;
		if (upRow >= 0) {
			if (leftCol >= 0) {
				neighboursList.add(_model.getItem(upRow, leftCol));
			}
			
			neighboursList.add(_model.getItem(upRow, _col));
			
			if (rightCol < _model.cols()) {
				neighboursList.add(_model.getItem(upRow, rightCol));
			}
			
		}
		
		if (bottomRow < _model.rows()) {
			if (leftCol >= 0) {
				neighboursList.add(_model.getItem(bottomRow, leftCol));
			}
			
			neighboursList.add(_model.getItem(bottomRow, _col));
			
			if (rightCol < _model.cols()) {
				neighboursList.add(_model.getItem(bottomRow, rightCol));
			}
			
		}
		
		if(leftCol >= 0) {
			neighboursList.add(_model.getItem(_row, leftCol));
		}
		
		if(rightCol < _model.cols()) {
			neighboursList.add(_model.getItem(_row, rightCol));
		}
		
		return neighboursList;
	}

	@Override
	public boolean isOpen() {
		return _isOpen;
	}
	
	@Override
	public void putFlag(boolean flagged) {
	  _isFlagged  = flagged;
	  if (flagged) {
		  _boardPanel.markMine();
	  } else {
		  _boardPanel.unMarkMine();
	  }
	  
	}
	
	@Override
	public boolean isFlagged() {
	  return _isFlagged;
	}
	
	@Override
	public void setPanel(JPanel panel) {
	  _currentPanel = panel;
	}
	
	@Override
	public void select() {
		_currentPanel.setBorder(BorderFactory.createEtchedBorder());
	}
	
	@Override
    public void unselect() {
		_currentPanel.setBorder(BorderFactory.createRaisedBevelBorder());
    }
	
	protected final void simpleOpenField() {
		_boardPanel.asPanel().remove(row()*_boardPanel.get_cols() + col());
		_currentPanel = new JPanel ();
		_currentPanel.setBorder(BorderFactory.createEtchedBorder());
		setBackGround(_currentPanel);
		_currentPanel.add(label());
		_boardPanel.asPanel().add(_currentPanel, row()*_boardPanel.get_cols() + col());
		_boardPanel.asPanel().revalidate();
		_boardPanel.asPanel().repaint();
		_isOpen = true;
		_boardPanel.openField(_row, _col);
	}
	
	protected void setBackGround (JPanel panel) {}
 
}
