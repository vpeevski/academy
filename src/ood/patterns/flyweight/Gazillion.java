package ood.patterns.flyweight;

public class Gazillion {
	private int row;
	
	public static int OBJECT_COUNTER = 0;

	public Gazillion(int theRow) {
		row = theRow;
		OBJECT_COUNTER++;
	}

	void report(int theCol) {
		System.out.print(" " + row + theCol);
	}
}