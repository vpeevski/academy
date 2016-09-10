package projects.minesweeper;

import java.awt.Color;
import java.util.List;

import javax.swing.JLabel;

public final class NumericItem extends AbstractItem {
	
	private final int _minesNeigboursCount;

	public NumericItem(int row, int col, MineSweeperModel model, BoardPanel boardPanel) {
		super(row, col, model, boardPanel);
		List<Item> neighbours = neighbours();
		_minesNeigboursCount = countMinesNeighbours(neighbours);
	}

	@Override
	public JLabel label() {
		JLabel label = new JLabel(_minesNeigboursCount + "");
		switch (_minesNeigboursCount) {
		case 0 : {
			label = new JLabel();
			break;
		}
		case 1 : {
			label.setForeground(Color.blue);
			break;
		}
		case 2 : {
			label.setForeground(Color.green);
			break;
		}
		
		case 3 : {
			label.setForeground(Color.red);
			break;
		}
		
		case 4 : {
			label.setForeground(Color.red);
			break;
		}
		
		case 5 : {
			label.setForeground(Color.yellow);
			break;
		}
		
		case 6 : {
			label.setForeground(Color.pink);
			break;
		}
		
		case 7 : {
			label.setForeground(Color.darkGray);
			break;
		}
		
		case 8 : {
			label.setForeground(Color.cyan);
			break;
		}
			
		}
		
		return label;
	}
	
	@Override
	public void open() {
		if (_minesNeigboursCount == 0) {
			openField();
		} else {
			simpleOpenField();
		}
		
	}
	
	private void openField () {
		if (! isOpen()) {
			simpleOpenField();
		
			List<Item> neighbours = neighbours();
			for (Item neighbour : neighbours) {
				if(!neighbour.isOpen() && ! (neighbour instanceof Mine)) {
					neighbour.open();
					_isOpen = true;
				}
			}
		}
	}
	
	private int countMinesNeighbours(List<Item> neighbours) {
		int minesCount = 0;
		for (Item item : neighbours) {
			if (item instanceof Mine) {
				minesCount++;
			}
		}
		
		return minesCount;
	}

	

}
