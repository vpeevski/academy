package projects.minesweeper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractItem implements Item {
	
	private final int _row;
	
	private final int _col;
	
	private MineSweeperModel _model;
	
	private boolean _isOpen;

	public AbstractItem (int row, int col, MineSweeperModel model) {
		_row = row;
		_col = col;
		_model = model;
		_isOpen = false;
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
	public void open() {
		_isOpen = true;
		
	}
}
