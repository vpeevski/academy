package projects.tetris;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisBoard {

	private JPanel _innerBoardPanel;

	private Field[][] _fieldsGrid;

	private Element _fallingElement;

	private Timer _timer;

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

		_fallingElement = generateElement();

		_innerBoardPanel.setFocusable(true);
		_innerBoardPanel.addKeyListener(new KeyboardListener());
	}

	private void addField(int row, int col, Field fieldButton) {
		_innerBoardPanel.add(fieldButton.asComponent());
		_fieldsGrid[row][col] = fieldButton;
	}

	public Field getField(int row, int col) {
		return _fieldsGrid[row][col];
	}

	public JPanel asPanel() {
		return _innerBoardPanel;
	}

	public class TetrisTimerListener implements ActionListener {

		boolean showNewElement = true;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (showNewElement) {
				_fallingElement.show();
				_timer.setDelay(1000);
				showNewElement = false;
			} else if (_fallingElement.isMovableDown()) {
				_fallingElement.moveDown();
			} else {
				_fallingElement.engageFields();
				checkForCompletedRows();
				_fallingElement = generateElement();

				showNewElement = true;
			}

		}

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

	public void startTimer(int delay) {
		_timer = new Timer(delay, new TetrisTimerListener());
		_timer.start();
	}

	private void checkForCompletedRows() {
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

	private Element generateElement() {
		Element result = new LeftZ(TetrisBoard.this);
		double random = Math.random();
		if (random < 0.143) {
			result = new Bar(TetrisBoard.this, Color.BLUE);
		} else if (random < 0.286) {
			result = new SemiCross(TetrisBoard.this, Color.ORANGE);
		} else if (random < 0.428) {
			result = new Cube(TetrisBoard.this, Color.GREEN);
		} else if (random < 0.572) {
			result = new RightG(TetrisBoard.this);
		} else if (random < 0.715) {
			result = new LeftG(TetrisBoard.this);
		} else if (random < 0.858) {
			result = new RightZ(TetrisBoard.this);
		} else {
			result = new LeftZ(TetrisBoard.this);
		}

		return result;
	}

	private class KeyboardListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_LEFT) {
				_fallingElement.moveLeft();
			} else if (keyCode == KeyEvent.VK_RIGHT) {
				_fallingElement.moveRight();
			} else if (keyCode == KeyEvent.VK_DOWN) {
				_timer.setDelay(30);
			} else if (keyCode == KeyEvent.VK_UP) {
				_fallingElement.rotate();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_DOWN) {
				_timer.setDelay(1000);
			}
		}
	}

}
