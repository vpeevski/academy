package projects.minesweeper;

import javax.swing.JOptionPane;

public final class GameController {
	
	private static GameController _instance;
	
	private GameController () {}
	
	public static final GameController instance () {
		if (_instance == null) {
			_instance = new GameController();
		}
		
		return _instance;
	}
	
	private MineSweeper mineSweeperGui;

	public void startNewGame(int rows, int cols, int minesCount) {
		if (mineSweeperGui != null) {
			mineSweeperGui.closeFrame();
		}
		mineSweeperGui = new MineSweeper();
		mineSweeperGui.buildFrame(rows, cols, minesCount);
		
	}
	
	public void endGame() {
		int option = JOptionPane.showConfirmDialog(null, "You win !  Do you want to play again ?", "Minesweeper WINNER", JOptionPane.YES_NO_OPTION);
		if (option == 0) {
			startNewGame(8, 8, 10);
		}
		
		
	}

}
