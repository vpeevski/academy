package projects.seachess;

public final class PlayerMoveEvent {
	
	private Player _player;
	
	private int _row;
	
	private int _column;
	
	public PlayerMoveEvent (Player player, int row, int column) {
		_player = player;
		_row = row;
		_column = column;
	}
	
	public Player getPlayer() {
		return _player;
	}
	
	public int getColumn() {
		return _column;
	}
	
	public int getRow() {
		return _row;
	}
	
	

}
