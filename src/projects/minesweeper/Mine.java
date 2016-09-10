package projects.minesweeper;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public final class Mine extends AbstractItem {
	
	public Mine(int row, int col, MineSweeperModel model) {
		super(row, col, model);
	}

	@Override
	public JLabel label() {
		URL imageURL = getClass().getClassLoader().getResource("projects/minesweeper/mine.png");
		return new JLabel(new ImageIcon(imageURL));
	}
	
}
