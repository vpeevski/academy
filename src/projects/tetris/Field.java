package projects.tetris;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public final class Field {

	private JPanel _currentPanel;

	private int _row;

	private int _col;

	private boolean isFree = true;
	
	private Color _color;

	private TetrisBoard _board;

	public Field(int row, int col, TetrisBoard board) {
		_currentPanel = new JPanel();
		_currentPanel.setBorder(BorderFactory
				.createLineBorder(Color.LIGHT_GRAY));
		_currentPanel.setBackground(Color.BLACK);
		_row = row;
		_col = col;
		_board = board;
	}

	public JPanel asComponent() {
		return _currentPanel;
	}

	public int getRow() {
		return _row;
	}

	public int getCol() {
		return _col;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	public void collapse () {
		Field downField = _board.getDownFieldOf(this);
		if(isFree) {
			downField.hide();
			downField.setFree(true);
		} else {
			downField.setColor(_color);
			downField.show();
			downField.setFree(false);
		}

	}
	
//	public Field moveDown () {
//		hide();
//		Field downField = _board.getDownFieldOf(this);
//		downField.setColor(_color);
//		downField.show();
//		return downField;
//	}

	public void hide() {
		_currentPanel.setBackground(Color.BLACK);
		_currentPanel.setBorder(BorderFactory
				.createLineBorder(Color.LIGHT_GRAY));
	}

	public void show() {
		_currentPanel.setBackground(_color);
		_currentPanel.setBorder(
				BorderFactory.createRaisedBevelBorder());
	}
	
	public void setColor (Color color) {
		_color = color;
	}

}
