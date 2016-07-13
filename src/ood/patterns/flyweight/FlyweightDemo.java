package ood.patterns.flyweight;

public class FlyweightDemo {
	public static final int ROWS = 100, COLS = 100;

	public static void main(String[] args) {
		Factory theFactory = new Factory(ROWS);
		
		for (int k = 0; k < 100; k++) {
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j < COLS; j++)
					theFactory.getFlyweight(i).report(j);
				System.out.println();
			}
		}
		
		System.out.println("Number of objects created : " + Gazillion.OBJECT_COUNTER);
	}
}
