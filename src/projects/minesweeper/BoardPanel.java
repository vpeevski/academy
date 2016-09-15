package projects.minesweeper;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BoardPanel {

	private boolean isFirstClick = true;

	private JPanel _innerBoardPanel;
	
	private Field[][] _fieldsGrid;
	
	private int _rows;
	
	private int _cols;
	
	private int _minesCount;
	
	private int _minesLeft;
	
	private List<MineMarkListener> _markListeners;

	public BoardPanel(int rows, int cols, int minesCount) {
		_innerBoardPanel = new JPanel(new GridLayout(rows, cols));
		_fieldsGrid = new Field[rows][cols];
		_rows = rows;
		_cols = cols;
		_minesCount = minesCount;
		_minesLeft = minesCount;
		_markListeners = new ArrayList<MineMarkListener>();
	}

	public int get_rows() {
		return _rows;
	}

	public int get_cols() {
		return _cols;
	}

	public int get_minesCount() {
		return _minesCount;
	}

	public JPanel asPanel() {
		return _innerBoardPanel;
	}

	public boolean isFirstClick() {
		boolean result = isFirstClick;
		isFirstClick = false;
		return result;
	}

	public void populateGridItems(MineSweeperModel model) {
		for (int i = 0; i < _fieldsGrid.length; i++) {
			for (int j = 0; j < _fieldsGrid[0].length; j++) {
				_fieldsGrid[i][j].setItem(model.getItem(i, j));
			}
		}
		
	}

	public void addField(int row, int col, Field fieldButton) {
		_innerBoardPanel.add(fieldButton.asComponent());
		_fieldsGrid[row][col] = fieldButton;
	}
	
	public void markMine () {
		_minesLeft--;
		fireMineMarkChange();
	}
	
	private void fireMineMarkChange() {
		for (MineMarkListener listener : _markListeners) {
			listener.mineMarkeChange();;
		}
		
	}

	public void unMarkMine () {
		_minesLeft++;
		fireMineMarkChange();
	}
	
	public int getMinesLeft () {
		return _minesLeft;
	}
	
	
	public int getUnOpenedFieldsCount () {
		int count = 0;
		for (int i = 0; i <_rows; i++) {
			for (int j = 0; j < _cols; j++) {
				if (!_fieldsGrid[i][j].isOpened()) {
					count ++;
				}
			}
		}
		
		return count;
	}
	
	public void addMineMarkListener (MineMarkListener markListener) {
		_markListeners.add(markListener);
	}
	
	public void removeMineMarkListener (MineMarkListener markListener) {
		_markListeners.remove(markListener);
	}
	
	public Field getField (int row, int col) {
      return _fieldsGrid[row][col];
    }
	
	public void showAllMines () {
		for (int i = 0; i < _rows; i++) {
			for (int j = 0; j < _cols; j++) {
				Field currentField = _fieldsGrid[i][j];
				if(!currentField.isFlagged() && !currentField.isOpened() && currentField.isMine()) {
					currentField.putMine();
				}
			}
		}
		
		_innerBoardPanel.revalidate();
		_innerBoardPanel.repaint();
	}
	
	

}
