package projects.tetris;

import java.awt.Color;

public class LeftG extends AbstractElement {
	
	private boolean isDown = true;

	private boolean isLeft = false;

	private boolean isRight = false;

	private boolean isUp = false;

	public LeftG(TetrisBoard board) {
		this(board, Color.YELLOW);
	}
	
	public LeftG(TetrisBoard board, Color color) {
		super(board, color);
		fields[0] = board.getField(0, 4);
		fields[0].setColor(color);
		fields[1] = board.getField(0, 5);
		fields[1].setColor(color);
		fields[2] = board.getField(0, 6);
		fields[2].setColor(color);
		fields[3] = board.getField(1, 4);
		fields[3].setColor(color);
	}

	@Override
	public void rotate() {
		if (isRight && isRotatableDown()) {
			rotateToDown();
		} else if (isDown && isRotatableLeft()) {
			rotateToLeft();
		} else if (isLeft && isRotatableUp()) {
			rotateToUp();
		} else if (isUp && isRotatableRight()) {
			rotateToRight();
		}
	}
	
	private void rotateToRight() {
		hide();
		fields[0] = _board.getDiagonalFieldOf(fields[0], 1, -1);
		fields[0].setColor(_color);
		fields[2] = _board.getDiagonalFieldOf(fields[2], -1, 1);
		fields[2].setColor(_color);
		fields[3] = _board.getDiagonalFieldOf(fields[3], 2, 0);
		fields[3].setColor(_color);
		isRight = true;
		isUp = false;
		show();
		
	}

	private boolean isRotatableRight() {
		Field field0 = _board.getDiagonalFieldOf(fields[0], 1, -1);
		if (field0 == null || !field0.isFree()) {
			return false;
		}
		
		Field field2 = _board.getDiagonalFieldOf(fields[2], -1, 1);
		if (field2 == null || !field2.isFree()) {
			return false;
		}

		Field field3 = _board.getDiagonalFieldOf(fields[3], 2, 0);
		if (field3 == null || !field3.isFree()) {
			return false;
		}

		return true;
	}

	private void rotateToUp() {
		hide();
		fields[0] = _board.getDiagonalFieldOf(fields[0], 1, 1);
		fields[0].setColor(_color);
		fields[2] = _board.getDiagonalFieldOf(fields[2], -1, -1);
		fields[2].setColor(_color);
		fields[3] = _board.getDiagonalFieldOf(fields[3], 0, 2);
		fields[3].setColor(_color);
		isUp = true;
		isLeft = false;
		show();
	}

	private boolean isRotatableUp() {
		Field field0 = _board.getDiagonalFieldOf(fields[0], 1, 1);
		if (field0 == null || !field0.isFree()) {
			return false;
		}
		
		Field field2 = _board.getDiagonalFieldOf(fields[2], -1, -1);
		if (field2 == null || !field2.isFree()) {
			return false;
		}

		Field field3 = _board.getDiagonalFieldOf(fields[3], 0, 2);
		if (field3 == null || !field3.isFree()) {
			return false;
		}

		return true;
	}

	private void rotateToLeft() {
		hide();
		fields[0] = _board.getDiagonalFieldOf(fields[0], -1, 1);
		fields[0].setColor(_color);
		fields[2] = _board.getDiagonalFieldOf(fields[2], 1, -1);
		fields[2].setColor(_color);
		fields[3] = _board.getDiagonalFieldOf(fields[3], -2, 0);
		fields[3].setColor(_color);
		
		isLeft = true;
		isDown = false;
		show();
		
	}

	private boolean isRotatableLeft() {
		
		Field field0 = _board.getDiagonalFieldOf(fields[0], -1, 1);
		if (field0 == null || !field0.isFree()) {
			return false;
		}
		
		Field field2 = _board.getDiagonalFieldOf(fields[2], 1, -1);
		if (field2 == null || !field2.isFree()) {
			return false;
		}

		Field field3 = _board.getDiagonalFieldOf(fields[3], -2, 0);
		if (field3 == null || !field3.isFree()) {
			return false;
		}

		return true;
	}

	private void rotateToDown() {
		hide();
		fields[0] = _board.getDiagonalFieldOf(fields[0], -1, -1);
		fields[0].setColor(_color);
		fields[2] = _board.getDiagonalFieldOf(fields[2], 1, 1);
		fields[2].setColor(_color);
		fields[3] = _board.getDiagonalFieldOf(fields[3], 0, -2);
		fields[3].setColor(_color);
		
		isDown = true;
		isRight = false;
		show();
		
	}

	private boolean isRotatableDown() {
		Field field0 = _board.getDiagonalFieldOf(fields[0], -1, -1);
		if (field0 == null || !field0.isFree()) {
			return false;
		}
		
		Field field2 = _board.getDiagonalFieldOf(fields[2], 1, 1);
		if (field2 == null || !field2.isFree()) {
			return false;
		}

		Field field3 = _board.getDiagonalFieldOf(fields[3], 0, -2);
		if (field3 == null || !field3.isFree()) {
			return false;
		}

		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see projects.tetris.Element#moveDown()
	 */
	@Override
	public void moveDown() {
		if (isMovableDown()) {
			if (isDown || isLeft) {
				for (int i = fields.length - 1; i >= 0; i--) {
					fields[i] = fields[i].moveDown();
				}
			} else if (isRight || isUp) {
				for (int i = 0; i < fields.length; i++) {
					fields[i] = fields[i].moveDown();
				}
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
			if (isLeft || isUp) {
				for (int i = fields.length - 1; i >= 0; i--) {
					fields[i] = fields[i].moveLeft();
				}
			} else if (isDown || isRight){
				for (int i = 0; i < fields.length; i++) {
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
			if (isUp || isLeft) {
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
