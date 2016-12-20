package projects.tetris;

import java.awt.Color;

public class Cube extends AbstractElement {

	public Cube(TetrisBoard board, Color color) {
		super(board, color);
		fields[0] = board.getField(0, 4);
		fields[0].setColor(color);
		fields[1] = board.getField(0, 5);
		fields[1].setColor(color);
		fields[2] = board.getField(1, 4);
		fields[2].setColor(color);
		fields[3] = board.getField(1, 5);
		fields[3].setColor(color);
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub

	}

}
