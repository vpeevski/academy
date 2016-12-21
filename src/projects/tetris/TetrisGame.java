package projects.tetris;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TetrisGame {

	private JFrame mainFrame;

	private Element _fallingElement;

	private Element _nextElement;

	private Timer _timer;

	private TetrisBoard _mainBoard;

	private ResultBoard _resultBoard;

	private int _currentDelay = 1000;

	public static void main(String[] args) {
		TetrisGameController.instance().startNewGame();
	}

	public void createAndShowGui() {
		mainFrame = new JFrame("Tetris");
		_mainBoard = new TetrisBoard();
		_fallingElement = generateElement(_mainBoard);

		mainFrame.add(_mainBoard.asPanel());
		_mainBoard.asPanel().addKeyListener(new KeyboardListener());
		_resultBoard = new ResultBoard();
		_nextElement = generateElement(_resultBoard);
		_resultBoard.showNextElement(_nextElement);
		mainFrame.add(_resultBoard.asPanel(), BorderLayout.EAST);
		mainFrame.setSize(450, 600);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		startTimer(_currentDelay);

	}

	public void closeFrame() {
		mainFrame.dispose();
	}

	public class TetrisTimerListener implements ActionListener {

		boolean showNewElement = true;

		@Override
		public void actionPerformed(ActionEvent e) {
			if (showNewElement) {
				_fallingElement.show();
				_timer.setDelay(_currentDelay);
				showNewElement = false;
			} else if (_fallingElement.isMovableDown()) {
				_fallingElement.moveDown();
			} else {
				_fallingElement.engageFields();
				int rowsCompleted = _mainBoard.checkForCompletedRows();
				int allRowsCompleted = 0;
				if (rowsCompleted > 0) {
					allRowsCompleted = _resultBoard
							.rowsCompleted(rowsCompleted);
					_resultBoard.gainPonts(calculatePoints(rowsCompleted));
				}

				if (allRowsCompleted > 0 && allRowsCompleted % 10 == 0) {
					nextLevel();
				}
				try {
					_fallingElement = _nextElement.moveToBoard(_mainBoard);
					_fallingElement.checkFields();
					_nextElement = generateElement(_resultBoard);
					_resultBoard.showNextElement(_nextElement);
					showNewElement = true;
				} catch (IllegalStateException ise) {
					_fallingElement.show();
					_timer.stop();
					TetrisGameController.instance().gameOver();
				}

			}

		}

	}

	public void startTimer(int delay) {
		_timer = new Timer(delay, new TetrisTimerListener());
		_timer.start();
	}
	
	private void nextLevel() {
		_resultBoard.nextLevel();
		_currentDelay = _currentDelay - 100;
		_timer.setDelay(_currentDelay);
	}

	private int calculatePoints(int rowsCompleted) {
		switch (rowsCompleted) {
		case 1:
			return 20;
		case 2:
			return 60;
		case 3:
			return 100;
		case 4:
			return 200;
		}
		return 0;
	}

	private Element generateElement(AbstractBoard onBoard) {
		Element result = new RightZ(onBoard);
		double random = Math.random();
		if (random < 0.143) {
			result = new Bar(onBoard);
		} else if (random < 0.286) {
			result = new SemiCross(onBoard);
		} else if (random < 0.428) {
			result = new Cube(onBoard);
		} else if (random < 0.572) {
			result = new RightG(onBoard);
		} else if (random < 0.715) {
			result = new LeftG(onBoard);
		} else if (random < 0.858) {
			result = new RightZ(onBoard);
		} else {
			result = new LeftZ(onBoard);
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
				while (_fallingElement.isMovableDown()) {
					_fallingElement.moveDown();
				}
			} else if (keyCode == KeyEvent.VK_UP) {
				_fallingElement.rotate();
			}
		}
		
	}
}
