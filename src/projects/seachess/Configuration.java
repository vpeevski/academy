package projects.seachess;

import java.util.ArrayList;
import java.util.List;

public final class Configuration {
	
	private static Configuration _instance;
	
	public final int _boardSize;
	
	public Player _playerInTurn;
	
	public Player _player1;
	
	public Player _player2;
	
	public boolean gameOver = false;
	
	private List<PlayerSwitchListener> _playerSwitchListeners;
	
	private List<PlayerMoveListener> _playerMoveListeners;
	
	private Configuration (int boardSize) {
		_player1 = new Player("Ivan", 1, "projects/seachess/circle_green.png");
		_player2 = new Player("Georgi", 2, "projects/seachess/cross_red.png");
		_playerInTurn = _player1;
		_boardSize = boardSize;
		_playerSwitchListeners = new ArrayList<PlayerSwitchListener>();
		_playerMoveListeners = new ArrayList<PlayerMoveListener>();
	}
	
	public static Configuration getConfiguration (int boardSize) {
		if (_instance == null) {
			_instance = new Configuration(boardSize);
		}
		
		return _instance;
	}
	
	public static Configuration getConfiguration () {
		return getConfiguration(3);
	}
	
	public void switchPlayers (int row, int column) {
		Player playerThatMoved = _playerInTurn;
		if (_playerInTurn == _player1) {
			_playerInTurn = _player2;
		} else {
			_playerInTurn = _player1;
		}
		
		for (PlayerMoveListener playerMoveListener : _playerMoveListeners) {
			gameOver = playerMoveListener.firePlayerMove(new PlayerMoveEvent(playerThatMoved, row, column));
		}
		
		for (PlayerSwitchListener playerSwitchListener : _playerSwitchListeners) {
			playerSwitchListener.fireSwitchPlayers();//new PlayerMoveEvent(_playerInTurn, row, column));
		}
	}
	
	public void addPlayerSwitchListener (PlayerSwitchListener listener) {
		_playerSwitchListeners.add(listener);
	}
	
	public void addPlayerMoveListener (PlayerMoveListener listener) {
		_playerMoveListeners.add(listener);
	}
	
	
	

}
