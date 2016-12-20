package projects.tetris;

import java.awt.Color;

public class Bar {

	private TetrisBoard _board;

	private Field[] fields = new Field[4];

	private Color _color;

	private boolean isHorizontal = true;

	public Bar(TetrisBoard board, Color color) {
		_color = color;
		_board = board;
		fields[0] = board.getField(0, 3);
		fields[0].setColor(color);
		fields[1] = board.getField(0, 4);
		fields[1].setColor(color);
		fields[2] = board.getField(0, 5);
		fields[2].setColor(color);
		fields[3] = board.getField(0, 6);
		fields[3].setColor(color);
	}

	public void show() {
		for (int i = 0; i < fields.length; i++) {
			fields[i].show();
		}

	}

	public void moveDown() {
		if (isMovalbleDown()) {
			hide();
			for (int i = 0; i < fields.length; i++) {
				fields[i] = _board.getDownFieldOf(fields[i]);
				fields[i].setColor(_color);
			}

			show();
		}
	}

	public void moveLeft() {
		if (isMovalbleLeft()) {
			hide();
			for (int i = 0; i < fields.length; i++) {
				fields[i] = _board.getLeftFieldOf(fields[i]);
				fields[i].setColor(_color);
			}
			show();
		}

	}

	public void moveRight() {
		if (isMovalbleRight()) {
			hide();
			for (int i = 0; i < fields.length; i++) {
				fields[i] = _board.getRightFieldOf(fields[i]);
				fields[i].setColor(_color);
			}

			show();
		}

	}

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

	public boolean isMovalbleDown() {
		boolean isMovalbleDown = true;
		for (int i = 0; i < fields.length; i++) {
			Field downField = _board.getDownFieldOf(fields[i]);
			if (downField == null || !_board.getDownFieldOf(fields[i]).isFree()) {
				isMovalbleDown = false;
			}
		}
		return isMovalbleDown;
	}

	public boolean isMovalbleLeft() {
		boolean isMovalbleLeft = true;
		for (int i = 0; i < fields.length; i++) {
			Field leftField = _board.getLeftFieldOf(fields[i]);
			if (leftField == null || !leftField.isFree()) {
				isMovalbleLeft = false;
			}
		}
		return isMovalbleLeft;
	}

	public boolean isMovalbleRight() {
		boolean isMovalbleRight = true;
		for (int i = 0; i < fields.length; i++) {
			Field rightField = _board.getRightFieldOf(fields[i]);
			if (rightField == null || !rightField.isFree()) {
				isMovalbleRight = false;
			}
		}
		return isMovalbleRight;
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

	private void hide() {
		for (int i = 0; i < fields.length; i++) {
			fields[i].hide();
		}
	}

	public Color getColor() {
		return _color;

	}

	public void engageFields() {
		for (int i = 0; i < fields.length; i++) {
			fields[i].setFree(false);
		}

	}

}
