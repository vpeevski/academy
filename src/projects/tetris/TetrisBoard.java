package projects.tetris;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class TetrisBoard extends AbstractBoard {

	public TetrisBoard() {
		_innerBoardPanel = new JPanel(new GridLayout(20, 10));
		_innerBoardPanel.setBorder(BorderFactory.createLineBorder(
				Color.LIGHT_GRAY, 5));
		_fieldsGrid = new Field[20][10];
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				final Field field = new Field(i, j, this);
				addField(i, j, field);
			}
		}

		_innerBoardPanel.setFocusable(true);
	}

	private void addField(int row, int col, Field field) {
		_innerBoardPanel.add(field.asComponent());
		_fieldsGrid[row][col] = field;
	}

	public void checkForCompletedRows() {
		for (int i = 0; i < _fieldsGrid.length; i++) {
			boolean isCompleted = true;
			for (int j = 0; j < _fieldsGrid[i].length; j++) {
				if (_fieldsGrid[i][j].isFree()) {
					isCompleted = false;
					break;
				}
			}

			if (isCompleted) {
				removeRow(i);
				pushDownUpperRows(i);
			}
		}

	}

	private void pushDownUpperRows(int rowRemoved) {
		for (int i = rowRemoved - 1; i >= 0; i--) {
			for (int j = 0; j < _fieldsGrid[i].length; j++) {
				_fieldsGrid[i][j].collapse();
			}
		}

	}

	private void removeRow(int i) {
		for (int j = 0; j < _fieldsGrid[i].length; j++) {
			_fieldsGrid[i][j].hide();
			_fieldsGrid[i][j].setFree(true);
		}
	}
	
	@Override
	public Field[] createLeftZFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(0, 6);
		resultFields[1] = getField(0, 5);
		resultFields[2] = getField(1, 5);
		resultFields[3] = getField(1, 4);
		
		return resultFields;
	}

	@Override
	public Field[] createBarFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(0, 3);
		resultFields[1] = getField(0, 4);
		resultFields[2] = getField(0, 5);
		resultFields[3] = getField(0, 6);
		
		return resultFields;
	}

	@Override
	public Field[] createSemiCrossFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(0, 4);
		resultFields[1] = getField(1, 4);
		resultFields[2] = getField(2, 4);
		resultFields[3] = getField(1, 5);
		return resultFields;
	}

	@Override
	public Field[] createCubeFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(0, 4);
		resultFields[1] = getField(0, 5);
		resultFields[2] = getField(1, 4);
		resultFields[3] = getField(1, 5);
		return resultFields;
	}

	@Override
	public Field[] createRightGFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(0, 4);
		resultFields[1] = getField(0, 5);
		resultFields[2] = getField(0, 6);
		resultFields[3] = getField(1, 6);
		return resultFields;
	}

	@Override
	public Field[] createLeftGFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(0, 4);
		resultFields[1] = getField(0, 5);
		resultFields[2] = getField(0, 6);
		resultFields[3] = getField(1, 4);
		return resultFields;
	}

	@Override
	public Field[] createRightZFields() {
		Field[] resultFields = new Field[4];
		resultFields[0] = getField(0, 4);
		resultFields[1] = getField(0, 5);
		resultFields[2] = getField(1, 5);
		resultFields[3] = getField(1, 6);
		return resultFields;
	}

}
