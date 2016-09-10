package projects.minesweeper;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class BoardPanel {

	private boolean isFirstClick = true;

	private JPanel _innerBoardPanel;
	
	private FieldButton[][] _fieldsGrid;
	
	private int _rows;
	
	private int _cols;
	
	private int _minesCount;

	public BoardPanel(int rows, int cols, int minesCount) {
		_innerBoardPanel = new JPanel(new GridLayout(rows, cols));
		_fieldsGrid = new FieldButton[rows][cols];
		_rows = rows;
		_cols = cols;
		_minesCount = minesCount;
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

	public void addField(int row, int col, FieldButton fieldButton) {
		_innerBoardPanel.add(fieldButton.asComponent());
		_fieldsGrid[row][col] = fieldButton;
	}
	
	public FieldButton getField (int row, int col) {
		return _fieldsGrid[row][col];
	}

}
