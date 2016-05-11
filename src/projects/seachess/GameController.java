package projects.seachess;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public final class GameController {
	
	public int _boardSize;
	
	public Player _playerInTurn;
	
	public Player _player1;
	
	public Player _player2;
	
	public boolean gameOver;
	
	private SeaChess seeChessGui;
	
	private List<PlayerSwitchListener> _playerSwitchListeners;
	
	private List<PlayerMoveListener> _playerMoveListeners;
	
	public GameController () {}
	
	public void startNewGame (int size) {
		if (seeChessGui != null) {
			seeChessGui.closeFrame();
		}
		
		_boardSize = size;
		_player1 = new Player("Ivan", 1, "projects/seachess/circle_green.png");
		_player2 = new Player("Georgi", 2, "projects/seachess/cross_red.png");
		_playerInTurn = _player1;
		gameOver = false;
		_playerSwitchListeners = new ArrayList<PlayerSwitchListener>();
		_playerMoveListeners = new ArrayList<PlayerMoveListener>();
		
		
		EndGameChecker gameChecker = new EndGameChecker(this);
		addPlayerMoveListener(gameChecker);
		seeChessGui = new SeaChess(this);
		seeChessGui.buildFrame(size);
	}
	
	public void switchPlayers () {
		if (_playerInTurn == _player1) {
			_playerInTurn = _player2;
		} else {
			_playerInTurn = _player1;
		}
		
		for (PlayerSwitchListener playerSwitchListener : _playerSwitchListeners) {
			playerSwitchListener.fireSwitchPlayers();
		}
	}
	
	public void gameOver (boolean hasWinner) {
		gameOver = true;
		
		for (PlayerSwitchListener playerSwitchListener : _playerSwitchListeners) {
			playerSwitchListener.fireGameFinish();
		}
		
		if (hasWinner) {
			JOptionPane.showMessageDialog(null, "Game Over: Winner is " + _playerInTurn.getName());
		} else {
			JOptionPane.showMessageDialog(null, "Game Over: No winner");
		}
		
		int answer = JOptionPane.showConfirmDialog(null, "Do you want to start a new game ?");
		if(answer == 0) {
			startNewGame(3);
		}
	
		
	}
	
	public void addPlayerSwitchListener (PlayerSwitchListener listener) {
		_playerSwitchListeners.add(listener);
	}
	
	public void addPlayerMoveListener (PlayerMoveListener listener) {
		_playerMoveListeners.add(listener);
	}

	public void move(int row, int column) {
		for (PlayerMoveListener playerMoveListener : _playerMoveListeners) {
			playerMoveListener.firePlayerMove(new PlayerMoveEvent(_playerInTurn, row, column));
		}
		
	}
	
	
	

}
