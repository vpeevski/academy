package util;

public final class MathUtil {

	private MathUtil() {
	};

	public static int max(int a, int b) {
		int max = a;
		if (b > max) {
			max = b;
		}

		return max;
	}

	public static int min(int a, int b) {
		int min = a;
		if (b < min) {
			min = b;
		}

		return min;
	}

}
