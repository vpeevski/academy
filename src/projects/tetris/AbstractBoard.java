package projects.tetris;

import javax.swing.JPanel;

public abstract class AbstractBoard {
	
	protected JPanel _innerBoardPanel;

	protected Field[][] _fieldsGrid;

	public Field getField(int row, int col) {
		return _fieldsGrid[row][col];
	}

	public JPanel asPanel() {
		return _innerBoardPanel;
	}

	public Field getDownFieldOf(Field field) {
		int nextRow = field.getRow() + 1;
		if (nextRow < 20) {
			return _fieldsGrid[nextRow][field.getCol()];
		}

		return null;

	}

	public Field getLeftFieldOf(Field field) {
		int newLeftCol = field.getCol() - 1;
		if (newLeftCol >= 0) {
			return _fieldsGrid[field.getRow()][newLeftCol];
		}

		return null;
	}

	public Field getRightFieldOf(Field field) {
		int newRightCol = field.getCol() + 1;
		if (newRightCol < 10) {
			return _fieldsGrid[field.getRow()][newRightCol];
		}

		return null;
	}

	public Field getDiagonalFieldOf(Field field, int rowDistance,
			int colDistance) {
		int rotationRow = field.getRow() + rowDistance;
		int rotationColumn = field.getCol() + colDistance;
		boolean rotationFieldExists = true;
		if (0 > rotationRow || rotationColumn >= 20) {
			rotationFieldExists = false;
		}

		if (0 > rotationColumn || rotationColumn >= 10) {
			rotationFieldExists = false;
		}

		if (rotationFieldExists) {
			return _fieldsGrid[rotationRow][rotationColumn];
		}

		return null;
	}
	
	public abstract Field[] createLeftZFields();

	public abstract Field[] createBarFields();

	public abstract Field[] createSemiCrossFields();

	public abstract Field[] createCubeFields();

	public abstract Field[] createRightGFields();

	public abstract Field[] createLeftGFields();

	public abstract Field[] createRightZFields();

}