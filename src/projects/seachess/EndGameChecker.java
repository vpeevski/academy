package projects.seachess;

import javax.swing.JOptionPane;

public class EndGameChecker implements PlayerMoveListener {
	
	private int[][] _model;
	
	public EndGameChecker () {
		Configuration config = Configuration.getConfiguration();
		_model = new int[config._boardSize][config._boardSize];
	}

	@Override
	public boolean firePlayerMove(PlayerMoveEvent moveEvent) {
		int playerId = moveEvent.getPlayer().getId();
		int row = moveEvent.getRow();
		int column = moveEvent.getColumn();
		_model[row][column] = playerId;
		
		boolean gameOver = false;
		if (isBoardFilled()) {
			JOptionPane.showMessageDialog(null, "Game Over: No winner");
			gameOver = true;
		} else {
			int winnerId = chechForWinner(row, column);
			if (winnerId != 0) {
				JOptionPane.showMessageDialog(null, "Game Over: Winner is " + moveEvent.getPlayer().getName());
				gameOver = true;
			}
		}
		
		return gameOver;
	}
	
	public boolean isBoardFilled () {
		for (int i = 0; i < _model.length; i++) {
			for (int j = 0; j < _model[i].length; j++) {
				if(_model[i][j] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private int chechForWinner (int row, int col) {
		int winnerId = checkRow(row);
		if(winnerId != 0) {
			return winnerId;
		}	
		
		winnerId = checkColumn(col);
		if(winnerId != 0) {
			return winnerId;
		}
		
		if(row == col) {
			winnerId = checkMainDiagonal();
			if(winnerId != 0) {
				return winnerId;
			}
		}
		
		
		if(row + col ==_model.length - 1) {
			winnerId = checkSecondaryDiagonal();
			if(winnerId != 0) {
				return winnerId;
			}
		}
		
		return 0;
	}
	
	private int checkRow (int row) {
		int winnerId = _model[row][0];
		if (winnerId != 0) {
			for (int i = 1; i < _model[0].length; i++) {
				if(_model[row][i] != winnerId) {
					return 0;
				}
			}
		}
		return winnerId;
	}
	
	private int checkColumn (int column) {
		int winnerId = _model[0][column];
		if (winnerId != 0) {
			for (int i = 1; i < _model[0].length; i++) {
				if(_model[i][column] != winnerId) {
					return 0;
				}
			}
		}
		return winnerId;
	}
	
	private int checkMainDiagonal () {
		int winnerId = _model[0][0];
		if (winnerId != 0) {
			for (int i = 1; i < _model[0].length; i++) {
				if(_model[i][i] != winnerId) {
					return 0;
				}
			}
		}
		return winnerId;
	}
	
	private int checkSecondaryDiagonal () {
		int winnerId = _model[_model.length - 1][0];
		if (winnerId != 0) {
			for (int i = 1; i < _model[0].length; i++) {
				if(_model[_model.length - 1 - i][i] != winnerId) {
					return 0;
				}
			}
		}
		return winnerId;
	}

}
