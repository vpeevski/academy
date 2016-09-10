package projects.minesweeper;

public class GameController {
	
	private MineSweeper mineSweeperGui;

	public void startNewGame(int rows, int cols, int minesCount) {
		if (mineSweeperGui != null) {
			mineSweeperGui.closeFrame();
		}
		mineSweeperGui = new MineSweeper(this);
		mineSweeperGui.buildFrame(rows, cols, minesCount);
		
	}

}
