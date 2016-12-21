package projects.tetris;

import java.awt.Color;

public class Cube extends AbstractElement {
	

	public Cube(AbstractBoard board) {
		this(board, Color.GREEN);
	}
	
	public Cube(AbstractBoard board, Color color) {
		super(board, color);
		fields = board.createCubeFields();
		setColor();
	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub

	}

	@Override
	public Element moveToBoard(AbstractBoard board) {
		return new Cube(board);
	}

}
