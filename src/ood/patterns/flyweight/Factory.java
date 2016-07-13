package ood.patterns.flyweight;

public class Factory {
	private Gazillion[] pool;

	public Factory(int maxRows) {
		pool = new Gazillion[maxRows];
	}

	public Gazillion getFlyweight(int theRow) {
		if (pool[theRow] == null)
			pool[theRow] = new Gazillion(theRow);
		return pool[theRow];
	}
}