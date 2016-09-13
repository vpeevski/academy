package projects.minesweeper;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class BoardPanel {

	private boolean isFirstClick = true;

	private JPanel _innerBoardPanel;
	
	private Field[][] _fieldsGrid;
	
	private int _rows;
	
	private int _cols;
	
	private int _minesCount;
	
	private int _minesLeft;
	
	private GameController _gameController;

	public BoardPanel(int rows, int cols, int minesCount, GameController gameController) {
		_innerBoardPanel = new JPanel(new GridLayout(rows, cols));
		_fieldsGrid = new Field[rows][cols];
		_rows = rows;
		_cols = cols;
		_minesCount = minesCount;
		_minesLeft = minesCount;
		_gameController = gameController;
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
	
	public Field getField (int row, int col) {
		return _fieldsGrid[row][col];
	}
	
	public void markMine () {
		_minesLeft--;
	}
	
	public void unMarkMine () {
		_minesLeft++;
	}
	
	public int getMinesLeft () {
		return _minesLeft;
	}
	
	public void openField (int row, int col) {
		_fieldsGrid[row][col].open();
		if (getUnOpenedFieldsCount() == _minesCount) {
			_gameController.endGame();
		}
	}
	
	
	private int getUnOpenedFieldsCount () {
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

}
