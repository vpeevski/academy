package projects.tetris;

import java.awt.Color;

public abstract class AbstractElement implements Element {

	protected TetrisBoard _board;

	protected Field[] fields = new Field[4];

	protected Color _color;

	public AbstractElement(TetrisBoard board, Color color) {
		_board = board;
		_color = color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#show()
	 */
	@Override
	public void show() {
		for (int i = 0; i < fields.length; i++) {
			fields[i].show();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#moveDown()
	 */
	@Override
	public void moveDown() {
		if (isMovableDown()) {
			for (int i = fields.length - 1; i >= 0; i--) {
				fields[i] = fields[i].moveDown();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#moveLeft()
	 */
	@Override
	public void moveLeft() {
		if (isMovableLeft()) {
			for (int i = 0; i < fields.length; i++) {
				fields[i] = fields[i].moveLeft();
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
			for (int i = fields.length - 1; i >= 0; i--) {
				fields[i] = fields[i].moveRight();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#isMovalbleDown()
	 */
	@Override
	public boolean isMovableDown() {
		boolean isMovalbleDown = true;
		for (int i = 0; i < fields.length; i++) {
			Field downField = _board.getDownFieldOf(fields[i]);
			if (downField == null || !_board.getDownFieldOf(fields[i]).isFree()) {
				isMovalbleDown = false;
			}
		}
		return isMovalbleDown;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#isMovalbleLeft()
	 */
	@Override
	public boolean isMovableLeft() {
		boolean isMovalbleLeft = true;
		for (int i = 0; i < fields.length; i++) {
			Field leftField = _board.getLeftFieldOf(fields[i]);
			if (leftField == null || !leftField.isFree()) {
				isMovalbleLeft = false;
			}
		}
		return isMovalbleLeft;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#isMovalbleRight()
	 */
	@Override
	public boolean isMovableRight() {
		boolean isMovalbleRight = true;
		for (int i = 0; i < fields.length; i++) {
			Field rightField = _board.getRightFieldOf(fields[i]);
			if (rightField == null || !rightField.isFree()) {
				isMovalbleRight = false;
			}
		}
		return isMovalbleRight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#getColor()
	 */
	@Override
	public Color getColor() {
		return _color;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#engageFields()
	 */
	@Override
	public void engageFields() {
		for (int i = 0; i < fields.length; i++) {
			fields[i].setFree(false);
		}

	}

	protected void hide() {
		for (int i = 0; i < fields.length; i++) {
			fields[i].hide();
		}
	}

}
