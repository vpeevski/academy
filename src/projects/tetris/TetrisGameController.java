package projects.tetris;

import javax.swing.JOptionPane;

public final class TetrisGameController {
	
	private static TetrisGameController _instance;
	
	private TetrisGameController () {}
	
	public static final TetrisGameController instance () {
		if (_instance == null) {
			_instance = new TetrisGameController();
		}
		
		return _instance;
	}
	
	private TetrisGame tetrisGame;

	public void startNewGame() {
		if (tetrisGame != null) {
			tetrisGame.closeFrame();
		}
		tetrisGame = new TetrisGame();
		tetrisGame.createAndShowGui();
		
	}
	
	public void gameOver() {
		int option = JOptionPane.showConfirmDialog(null, "Game Over ! \n Do you want to play again ?", "Tetris", JOptionPane.YES_NO_OPTION);
		if (option == 0) {
			startNewGame();
		}
	}
}
		
		
	
	