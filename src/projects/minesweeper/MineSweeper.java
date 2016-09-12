package projects.minesweeper;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public final class MineSweeper {
	
	private BoardPanel _boardPanel;
	
	private JFrame _mainFrame;
	
	private GameController _gameController;
	
	public MineSweeper (GameController gameController) {
		_gameController = gameController;
	}

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.startNewGame(8, 8, 10);
	}

	public JFrame buildFrame(int rows, int cols, int minesCount) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		_boardPanel = new BoardPanel(rows, cols, minesCount);
		
		for (int i = 0; i < rows; i++) {
			for(int j = 0 ; j < cols; j++) {
				Field fieldButton = new Field(i, j, _boardPanel, _gameController);
				_boardPanel.addField(i, j, fieldButton);
			}
			
		}
		mainPanel.add(_boardPanel.asPanel(), BorderLayout.CENTER);
		
		

		_mainFrame = new JFrame("MineSweeper");
		_mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_mainFrame.add(mainPanel);

		_mainFrame.setSize(cols*40, rows*40);
		_mainFrame.setLocationRelativeTo(null);
		_mainFrame.setResizable(false);
		_mainFrame.setVisible(true);
		return _mainFrame;
	}
	
	public void closeFrame() {
		_mainFrame.setVisible(false);
		_mainFrame = null;
		_gameController = null;
	}

	
}
