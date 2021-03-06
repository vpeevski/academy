package projects.tetris;

import java.awt.Color;

public class Bar extends AbstractElement {

	private boolean isHorizontal = true;

	public Bar(AbstractBoard board) {
		this(board, Color.BLUE);
	}
	
	public Bar(AbstractBoard board, Color color) {
		super(board, color);
		fields = board.createBarFields();
		setColor();
	}

	/* (non-Javadoc)
	 * @see projects.tetris.Element#rotate()
	 */
	@Override
	public void rotate() {
		if (isHorizontal && isRotatableV()) {
			rotateToVertial();
		} else if (isRotatableH()) {
			rotateToHorizontal();
		}
	}

	private void rotateToVertial() {
		hide();
		fields[0] = _board.getDiagonalFieldOf(fields[0], -1, 1);
		fields[0].setColor(_color);
		fields[2] = _board.getDiagonalFieldOf(fields[2], 1, -1);
		fields[2].setColor(_color);
		fields[3] = _board.getDiagonalFieldOf(fields[3], 2, -2);
		fields[3].setColor(_color);
		isHorizontal = false;
		show();
	}

	private void rotateToHorizontal() {
		hide();
		fields[0] = _board.getDiagonalFieldOf(fields[0], 1, -1);
		fields[0].setColor(_color);
		fields[2] = _board.getDiagonalFieldOf(fields[2], -1, 1);
		fields[2].setColor(_color);
		fields[3] = _board.getDiagonalFieldOf(fields[3], -2, 2);
		fields[3].setColor(_color);
		isHorizontal = true;
		show();
	}

	private boolean isRotatableV() {
		Field field0 = _board.getDiagonalFieldOf(fields[0], -1, 1);
		if (field0 == null || !field0.isFree()) {
			return false;
		}

		Field field2 = _board.getDiagonalFieldOf(fields[2], 1, -1);
		if (field2 == null || !field2.isFree()) {
			return false;
		}

		Field field3 = _board.getDiagonalFieldOf(fields[3], 2, -2);
		if (field3 == null || !field3.isFree()) {
			return false;
		}
		return true;
	}

	private boolean isRotatableH() {
		Field field0 = _board.getDiagonalFieldOf(fields[0], 1, -1);
		if (field0 == null || !field0.isFree()) {
			return false;
		}

		Field field2 = _board.getDiagonalFieldOf(fields[2], -1, 1);
		if (field2 == null || !field2.isFree()) {
			return false;
		}

		Field field3 = _board.getDiagonalFieldOf(fields[3], -2, 2);
		if (field3 == null || !field3.isFree()) {
			return false;
		}
		return true;
	}

	@Override
	public Element moveToBoard(AbstractBoard board) {
		return new Bar (board);
	}

}
