package projects.minesweeper;

import java.awt.Color;

import javax.swing.JLabel;

public final class NumericItem extends AbstractItem {
	
	private final int _minesNeigboursCount;

	public NumericItem(int row, int col, int minesNeigboursCount, MineSweeperModel model) {
		super(row, col, model);
		_minesNeigboursCount = minesNeigboursCount;
	}

	@Override
	public JLabel label() {
		JLabel label = new JLabel(_minesNeigboursCount + "");
		switch (_minesNeigboursCount) {
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

	

}
