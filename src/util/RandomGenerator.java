package util;

public final class RandomGenerator {
	
	private RandomGenerator () {};
	
	public static Integer[] genRandomArray () {
		int len =  randomInt_0_To_1000();
		Integer[] resultArr = new Integer[len];
		for (int i = 0; i < len; i++) {
			resultArr[i] = randomInt_0_To_1000();
		}
		
		return resultArr;
	}
	
	private static int randomInt_0_To_1000 () {
		return (int) (Math.random() * 1000 + Math.random() * 100 + Math.random() * 10 + 1);
	}
	
	private static int randomInt_0_To_10 () {
		return (int) (Math.random() * 10 + 1);
	}

}
