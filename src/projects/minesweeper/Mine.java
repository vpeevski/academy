package projects.minesweeper;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public final class Mine extends AbstractItem {
	
	private GameController _gameController;
	
	public Mine(int row, int col, MineSweeperModel model, BoardPanel boardPanel, GameController gameController) {
		super(row, col, model, boardPanel);
		_gameController = gameController;
	}

	@Override
	public JLabel label() {
		URL imageURL = getClass().getClassLoader().getResource("projects/minesweeper/mine.png");
		return new JLabel(new ImageIcon(imageURL));
	}
	
	
	@Override
	public void open() {
		simpleOpenField();
		JOptionPane.showMessageDialog(null, "GAME OVER !");
		_gameController.startNewGame(3, 4, 3);
	}
	
	@Override
	protected void setBackGround(JPanel panel) {
		panel.setBackground(Color.RED);
	}
}
