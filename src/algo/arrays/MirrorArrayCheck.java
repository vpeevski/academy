package algo.arrays;

import util.IOUtil;

public class MirrorArrayCheck {

	public static void main(String[] args) {
		int[] array = IOUtil.readArray();
		if(SimetricCheck.isSimetricWithBreak(array)) {
			System.out.println("Масивът е огледален ");
		} else {
			System.out.println("Масивът не е огледален");
		}
		IOUtil.print(array);
	}

}
