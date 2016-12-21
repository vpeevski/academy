package projects.tetris;

import java.awt.Color;

public interface Element {

	public void show();
	
	public void hide();

	public void moveDown();

	public void moveLeft();

	public void moveRight();

	public void rotate();

	public boolean isMovableDown();

	public boolean isMovableLeft();

	public boolean isMovableRight();

	public Color getColor();

	public void engageFields();
	
	public Element moveToBoard (AbstractBoard board);
	
	public void checkFields ();

}