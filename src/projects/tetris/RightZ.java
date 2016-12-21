package projects.tetris;

import java.awt.Color;

public class RightZ extends AbstractElement {

	private boolean isHorizontal = true;

	public RightZ(TetrisBoard board) {
		this(board, new Color(78, 108, 229));
	}

	public RightZ(TetrisBoard board, Color color) {
		super(board, color);
		fields[0] = board.getField(0, 4);
		fields[0].setColor(color);
		fields[1] = board.getField(0, 5);
		fields[1].setColor(color);
		fields[2] = board.getField(1, 5);
		fields[2].setColor(color);
		fields[3] = board.getField(1, 6);
		fields[3].setColor(color);
	}

	@Override
	public void rotate() {
		if (isHorizontal && isRotatableV()) {
			rotateV();
		} else if (!isHorizontal && isRotatableH()) {
			rotateH();
		}

	}

	private void rotateH() {
		hide();
		fields[3] = _board.getDiagonalFieldOf(fields[3], -1, 1);
		fields[3].setColor(_color);

		fields[1] = _board.getDiagonalFieldOf(fields[1], -1, -1);
		fields[1].setColor(_color);

		fields[0] = _board.getDiagonalFieldOf(fields[0], 0, -2);
		fields[0].setColor(_color);

		isHorizontal = true;
		show();

	}

	private boolean isRotatableH() {
		Field field3 = _board.getDiagonalFieldOf(fields[3], -1, 1);
		if (field3 == null || !field3.isFree()) {
			return false;
		}

		Field field1 = _board.getDiagonalFieldOf(fields[1], -1, -1);
		if (field1 == null || !field1.isFree()) {
			return false;
		}

		Field field0 = _board.getDiagonalFieldOf(fields[0], 0, -2);
		if (field0 == null || !field0.isFree()) {
			return false;
		}

		return true;
	}

	private void rotateV() {
		hide();
		fields[3] = _board.getDiagonalFieldOf(fields[3], 1, -1);
		fields[3].setColor(_color);

		fields[1] = _board.getDiagonalFieldOf(fields[1], 1, 1);
		fields[1].setColor(_color);

		fields[0] = _board.getDiagonalFieldOf(fields[0], 0, 2);
		fields[0].setColor(_color);

		isHorizontal = false;
		show();

	}

	private boolean isRotatableV() {

		Field field3 = _board.getDiagonalFieldOf(fields[3], 1, -1);
		if (field3 == null || !field3.isFree()) {
			return false;
		}

		Field field1 = _board.getDiagonalFieldOf(fields[1], 1, 1);
		if (field1 == null || !field1.isFree()) {
			return false;
		}

		Field field0 = _board.getDiagonalFieldOf(fields[0], 0, 2);
		if (field0 == null || !field0.isFree()) {
			return false;
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#moveLeft()
	 */
	@Override
	public void moveLeft() {
		if (isMovableLeft()) {
			if (isHorizontal) {
				for (int i = 0; i < fields.length; i++) {
					fields[i] = fields[i].moveLeft();
				}
			} else {
				for (int i = fields.length - 1; i >= 0; i--) {
					fields[i] = fields[i].moveLeft();
				}
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#moveRight()
	 */
	@Override
	public void moveRight() {
		if (isMovableRight()) {
			if (!isHorizontal) {
				for (int i = 0; i < fields.length; i++) {
					fields[i] = fields[i].moveRight();
				}
			} else {
				for (int i = fields.length - 1; i >= 0; i--) {
					fields[i] = fields[i].moveRight();
				}
			}

		}

	}

}
