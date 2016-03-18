package numeric.system;

/**
 * @author vpeevski
 * 
 *         use this site for check :
 *         http://www.exploringbinary.com/floating-point-converter/
 *
 */
public class Converter {

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
		return toDec(bin, 2);
	}

	public static final int hexToDec(String hex) {
		return toDec(hex, 16);
	}

	public static final String decToHex(int decNum) {
		return decTo (decNum, 16);
	}
	
	public static final String decToBin(int decNum) {
		return decTo (decNum, 2);
	}
	
	private static final String decTo (int decNum, int radix) {
		StringBuilder binNumBuffer = new StringBuilder();

		String sign = "";

		if (decNum < 0) {
			sign = "-";
		}

		while (Math.abs(decNum) > 0) {
			int rest = Math.abs(decNum) % radix;
			decNum = decNum / radix;
			binNumBuffer.append(Character.forDigit(rest, radix));
		}
		return sign + binNumBuffer.reverse().toString();
	}

	private static int toDec(String number, int radix) {
		int dec = 0;
		char[] chars = number.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char currentChar = chars[chars.length - i - 1];
			if (currentChar != '0') {
				int currentCharAsInt = Integer.parseInt(String.valueOf(currentChar), radix);
				dec = dec + currentCharAsInt * (int) Math.pow(radix, i);
			}
		}
		return dec;
	}

	public static void main(String[] args) {
		System.out.println(Converter.decToBin(21.34));
	}

}
