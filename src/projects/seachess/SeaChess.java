package projects.seachess;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public final class SeaChess {

	public static void main(String[] args) {
		Configuration config = Configuration.getConfiguration(3);
		EndGameChecker gameChecker = new EndGameChecker();
		config.addPlayerMoveListener(gameChecker);
		buildFrame(config._boardSize);
	}
	
	private static JFrame buildFrame (int size) {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel boardPanel = new JPanel();
		boardPanel.setLayout(new BoxLayout(boardPanel, BoxLayout.Y_AXIS));
		
		
		for (int i = 0; i < size; i++) {
			LinePanel linePanel = new LinePanel(i, size);
			boardPanel.add(linePanel.asPanel());
		}
		
		PlayerNameLabel playerLabel = new PlayerNameLabel(Configuration.getConfiguration()._playerInTurn);
		Configuration.getConfiguration().addPlayerSwitchListener(playerLabel);
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		mainPanel.add(playerLabel, BorderLayout.SOUTH);
		
		JFrame mainFrame = new JFrame ("Sea Chess");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(mainPanel);
		
		mainFrame.setSize(size*100, size*100);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		return mainFrame;
	}
	
	private static class PlayerNameLabel extends JLabel implements PlayerSwitchListener {
		
		public PlayerNameLabel(Player player) {
			super (player.getName(), SwingConstants.CENTER);
		}

		@Override
		public void fireSwitchPlayers() {
			if(!Configuration.getConfiguration().gameOver) {
				setText(Configuration.getConfiguration()._playerInTurn.getName());
				repaint();
				revalidate();
			}
		}
		
	}

}
