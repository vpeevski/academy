package projects.minesweeper;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public final class NumericItem extends AbstractItem {

	private final int _minesNeigboursCount;

	public NumericItem(int row, int col, BoardPanel boardPanel) {
		super(row, col, boardPanel);
		List<Item> neighbours = BoardUtil.neighbours(row, col, boardPanel);
		_minesNeigboursCount = countMinesNeighbours(neighbours);
	}

	@Override
	public JLabel label() {
		JLabel label = new JLabel(_minesNeigboursCount + "");
		switch (_minesNeigboursCount) {
		case 0: {
			label = new JLabel();
			break;
		}
		case 1: {
			label.setForeground(Color.blue);
			break;
		}
		case 2: {
			label.setForeground(Color.green);
			break;
		}

		case 3: {
			label.setForeground(Color.red);
			break;
		}

		case 4: {
			label.setForeground(Color.red);
			break;
		}

		case 5: {
			label.setForeground(Color.yellow);
			break;
		}

		case 6: {
			label.setForeground(Color.pink);
			break;
		}

		case 7: {
			label.setForeground(Color.darkGray);
			break;
		}

		case 8: {
			label.setForeground(Color.cyan);
			break;
		}

		}

		return label;
	}

	@Override
	public void open() {
		if (_minesNeigboursCount == 0) {
			openSectorRec();
		} else {
			simpleOpenField();
			checkEndGame();
			_boardPanel.getField(_row, _col).addMouseListener(new FlaggedNumberRevealListener());
		}

	}

	private void openSectorRec() {
		if (!isOpen()) {
			simpleOpenField();

			List<Item> neighbours = BoardUtil.neighbours(_row, _col, _boardPanel);
			for (Item neighbour : neighbours) {
				if (neighbour!= null && !neighbour.isOpen() && !neighbour.isMine()) {
					_isOpen = true;
					neighbour.open();
					
				}
			}
		}
	}
	
	private void checkEndGame() {
		if (_boardPanel.getUnOpenedFieldsCount() == _boardPanel.get_minesCount()) {
			_boardPanel.showAllMines();
			GameController.instance().gameOverWin();
		}
	}

	private int countMinesNeighbours(List<Item> neighbours) {
		int minesCount = 0;
		for (Item item : neighbours) {
			if(item != null && item.isMine()) {
				minesCount++;
			}
		}

		return minesCount;
	}

	private int countFlaggedNeighbours(List<Item> neighbours) {
		int minesCount = 0;
		for (Item item : neighbours) {
			if (!item.isOpen() && _boardPanel.getField(item.row(), item.col()).isFlagged()) {
				minesCount++;
			}
		}

		return minesCount;
	}

	private void revealFlaggedField() {
		List<Item> neighbours = BoardUtil.neighbours(_row, _col, _boardPanel);
		for (Item neighbour : neighbours) {
			if (!neighbour.isOpen() && !_boardPanel.getField(neighbour.row(), neighbour.col()).isFlagged()) {
				_isOpen = true;
				neighbour.open();
			}
		}
	}
	
	@Override
	public boolean isMine() {
		return false;
	}

	public class FlaggedNumberRevealListener extends MouseAdapter {

		private boolean isLeftPressed;
		private boolean isRightPressed;

		private boolean isIn;

		@Override
		public void mousePressed(MouseEvent e) {
			if (SwingUtilities.isLeftMouseButton(e)) {
				isLeftPressed = true;
			} 
			
			if (SwingUtilities.isRightMouseButton(e)) {
				isRightPressed = true;
			}

			List<Item> neighbours = BoardUtil.neighbours(_row, _col, _boardPanel);
			if (_minesNeigboursCount <= countFlaggedNeighbours(neighbours) && isIn && isLeftPressed && isRightPressed) {
				for (Item item : neighbours) {
					if (!_boardPanel.getField(item.row(), item.col()).isFlagged() && !item.isOpen()) {
						_boardPanel.getField(item.row(), item.col()).select();
					}

				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			if (_minesNeigboursCount <= countFlaggedNeighbours(BoardUtil.neighbours(_row, _col, _boardPanel)) && isIn && isLeftPressed	&& isRightPressed) {
				revealFlaggedField();
			}
			
			if (SwingUtilities.isLeftMouseButton(e)) {
				isLeftPressed = false;
			} 
			
			if (SwingUtilities.isRightMouseButton(e)) {
				isRightPressed = false;
			}

		}

		@Override
		public void mouseExited(MouseEvent e) {
			for (Item item : BoardUtil.neighbours(_row, _col, _boardPanel)) {
				if (!_boardPanel.getField(item.row(), item.col()).isFlagged() && !item.isOpen()) {
					_boardPanel.getField(item.row(), item.col()).unselect();
				}

			}
			isIn = false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			isIn = true;
			List<Item> neighbours = BoardUtil.neighbours(_row, _col, _boardPanel);
			if (isLeftPressed && isRightPressed &&_minesNeigboursCount <= countFlaggedNeighbours(neighbours) && isIn) {
				for (Item item : neighbours) {
					if (!_boardPanel.getField(item.row(), item.col()).isFlagged() && !item.isOpen()) {
						_boardPanel.getField(item.row(), item.col()).select();
					}

				}
			} 
		}

	}

}
