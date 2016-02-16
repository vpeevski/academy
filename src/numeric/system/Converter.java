package numeric.system;

import java.math.BigDecimal;

/**
 * @author vpeevski
 * 
 *         use this site for check :
 *         http://www.exploringbinary.com/floating-point-converter/
 *
 */
public class Converter {

	private int d;

	public static final String decToBin(int decNum) {
		StringBuilder binNumBuffer = new StringBuilder();

		char sign = ' ';

		if (decNum < 0) {
			sign = '-';
		}

		while (Math.abs(decNum) > 0) {
			int rest = Math.abs(decNum) % 2;
			decNum = decNum / 2;
			binNumBuffer.append(rest);
		}
		return sign + binNumBuffer.reverse().toString();
	}

	public static final String decToBin(double decNum, double accuracy) {
		char sign = ' ';

		if (decNum < 0) {
			sign = '-';
		}

		int decNumMantis = (int) Math.floor(decNum);
		double fractionPart = decNum - decNumMantis;
		StringBuilder binFractionBuffer = new StringBuilder();
		while (fractionPart > accuracy) {
			fractionPart = fractionPart * 2;
			if (fractionPart < 1) {
				binFractionBuffer.append(0);
			} else {
				binFractionBuffer.append(1);
				fractionPart = fractionPart - 1;
			}
		}

		StringBuilder binNumBuffer = new StringBuilder();
		while (Math.abs(decNumMantis) > 0) {
			int rest = Math.abs(decNumMantis) % 2;
			decNumMantis = decNumMantis / 2;
			binNumBuffer.append(rest);
		}

		return sign + binNumBuffer.reverse().toString() + ","
				+ binFractionBuffer.toString();
	}

	public static final String decToBin(double decNum) {
		return Long.toBinaryString(Double.doubleToLongBits(decNum));

	}

	public static final int binToDec(String bin) {
		int dec = 0;
		char[] chars = bin.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if ('1' == chars[chars.length - i - 1]) {
				dec = dec + (int) Math.pow(2.0, i);
			}
		}
		return dec;
	}

	public static String decToHex(int decNum) {
		StringBuilder binNumBuffer = new StringBuilder();

		char sign = ' ';

		if (decNum < 0) {
			sign = '-';
		}

		while (Math.abs(decNum) > 0) {
			int rest = Math.abs(decNum) % 16;
			decNum = decNum / 16;
			binNumBuffer.append(Character.forDigit(rest, 16));
		}
		return sign + binNumBuffer.reverse().toString();
	}

	public static void main(String[] args) {
		Converter.decToBin(21.34);
	}

}
