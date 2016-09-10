package projects.minesweeper;

import javax.swing.JLabel;

public class EmptyItem extends AbstractItem {

	public EmptyItem(int row, int col, MineSweeperModel model) {
		super(row, col, model);
	}

	@Override
	public JLabel label() {
		return new JLabel();
	}

}
