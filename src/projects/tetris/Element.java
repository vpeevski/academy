package projects.tetris;

import java.awt.Color;

public interface Element {

	public abstract void show();

	public abstract void moveDown();

	public abstract void moveLeft();

	public abstract void moveRight();

	public abstract void rotate();

	public abstract boolean isMovableDown();

	public abstract boolean isMovableLeft();

	public abstract boolean isMovableRight();

	public abstract Color getColor();

	public abstract void engageFields();

}