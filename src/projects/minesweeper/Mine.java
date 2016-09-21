package projects.minesweeper;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class Mine extends AbstractItem {
	
	public Mine(int row, int col, BoardPanel boardPanel) {
		super(row, col, boardPanel);
	}

	@Override
	public JLabel label() {
		URL imageURL = getClass().getClassLoader().getResource("projects/minesweeper/mine.png");
		_boardPanel.getField(_row, _col).asComponent().setBackground(Color.RED);
		return new JLabel(new ImageIcon(imageURL));
	}
	
	
	@Override
	public void open() {
	    simpleOpenField();
	    _boardPanel.showAllMines();
        GameController.instance().gameOverLoose();
	  }

	
	@Override
	protected void setBackGround(JPanel panel) {
		panel.setBackground(Color.RED);
	}
	
	@Override
	public boolean isMine() {
		return true;
	}
}
