package projects.tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

public class TetrisGame {

	private JFrame mainFrame;

	private Element _fallingElement;
	
	private Element _nextElement;

	private Timer _timer;

	private TetrisBoard _mainBoard;
	
	private ResultBoard _resultBoard;

	public static void main(String[] args) {
		TetrisGameController tetrisGameController = TetrisGameController.instance();
		tetrisGameController.startNewGame();
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
		startTimer(1000);

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
				_timer.setDelay(1000);
				showNewElement = false;
			} else if (_fallingElement.isMovableDown()) {
				_fallingElement.moveDown();
			} else {
				_fallingElement.engageFields();
				_mainBoard.checkForCompletedRows();
				_fallingElement = _nextElement.moveToBoard(_mainBoard);
				_nextElement = generateElement(_resultBoard);
				_resultBoard.showNextElement(_nextElement);
				showNewElement = true;
			}

		}

	}

	public void startTimer(int delay) {
		_timer = new Timer(delay, new TetrisTimerListener());
		_timer.start();
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
