package projects.seachess;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public final class SeaChess {

	private GameController _gameController;

	private JFrame _mainFrame;

	public SeaChess(GameController gameController) {
		_gameController = gameController;
	}

	public static void main(String[] args) {
		GameController gameController = new GameController();
		gameController.startNewGame(3);
	}

	public JFrame buildFrame(int size) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.Y_AXIS));

		for (int i = 0; i < size; i++) {
			LinePanel linePanel = new LinePanel(_gameController, i, size);
			boardPanel.add(linePanel.asPanel());
		}

		PlayerNameLabel playerLabel = new PlayerNameLabel(
				_gameController._playerInTurn);
		_gameController.addPlayerSwitchListener(playerLabel);
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		mainPanel.add(playerLabel, BorderLayout.SOUTH);

		JFrame mainFrame = new JFrame("Sea Chess");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(mainPanel);

		mainFrame.setSize(size * 100, size * 100);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		
		_mainFrame = mainFrame;
		_mainFrame.setLocationRelativeTo(null);
		return mainFrame;
	}

	private class PlayerNameLabel extends JLabel implements
			PlayerSwitchListener {

		public PlayerNameLabel(Player player) {
			super(player.getName(), SwingConstants.CENTER);
		}

		@Override
		public void fireSwitchPlayers() {
			setText(_gameController._playerInTurn.getName());
			repaint();
			revalidate();

		}

		@Override
		public void fireGameFinish() {
			setText("Winner is: " + _gameController._playerInTurn.getName());
			repaint();
			revalidate();
		}

	}

	public void closeFrame() {
		_mainFrame.setVisible(false);
		_mainFrame = null;
		_gameController = null;
	}

}
