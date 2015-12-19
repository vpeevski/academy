package recursion;

import java.util.List;

import util.RefHolder;

public class Fibonachi {

	public static long generateRec(int index) {

		if (index <= 0) {
			throw new IllegalArgumentException(
					"Fibonachi number index can be defined only for Natural numbers. Not for : "
							+ index);
		}

		if (index == 1) {
			return 0;
		}

		if (index == 2) {
			return 1;
		}

		return generateRec(index - 1) + generateRec(index - 2);

	}
	
	public static long generateRec(int index, List<Long> fibNumbers) {

		if (index <= 0) {
			throw new IllegalArgumentException(
					"Fibonachi number index can be defined only for Natural numbers. Not for : "
							+ index);
		}

		if (index == 1) {
			return 0;
		}

		if (index == 2) {
			return 1;
		}

		long prePrev = generateRec(index - 2, fibNumbers);
		long prev = generateRec(index - 1, fibNumbers);
		long fib = prePrev + prev;
		addUnique(fibNumbers, fib);
		return fib;

	}
	
	private static void addUnique (List<Long> list, Long value) {
		if (!list.contains(value)) {
			list.add(value);
//			System.out.println("Fibonachi [" + list.size() + "] - " + value); // Not reliabe for printing
		}
	}

	public static long printFibonachiRec(int index) {
		RefHolder<Long> fibNum = new RefHolder<Long>(1L);
		System.out.println("############## Print Fibonachi Recursive - ("+ index +") ################");
		printFibRec(-1L, fibNum, 1, index);
		return fibNum.getRef();
	}

	private static void printFibRec(long prev, RefHolder<Long> fibNumber, int currentIndex,
			int finalIndex) {

		if (currentIndex > finalIndex) {
			return;
		}

		long fibNext = prev + fibNumber.getRef();
		prev = fibNumber.getRef();
		fibNumber.setRef(fibNext);
		System.out.println("Fibonachi [" + currentIndex + "] - " + fibNext);
		printFibRec(prev, fibNumber, ++currentIndex, finalIndex);
	}

	public static long generateIter(int index) {
		if (index <= 0) {
			throw new IllegalArgumentException(
					"Fibonachi number index can be defined only for Natural numbers. Not for : "
							+ index);
		}
		
		System.out.println("############## Iterative Fibonachi - ("+ index +") ################");

		if (index == 1) {
			System.out.println("Fibonachi [1] - " + 0);
			return 0;
		}

		if (index == 2) {
			System.out.println("Fibonachi [1] - " + 0);
			System.out.println("Fibonachi [2] - " + 1);
			return 1;
		}

		int prePrev = 0;
		int prev = 1;
		System.out.println("Fibonachi [1] - " + 0);
		System.out.println("Fibonachi [2] - " + 1);
		int fibonachiNumber = 0;
		for (int i = 3; i <= index; i++) {
			fibonachiNumber = prePrev + prev;
			System.out.println("Fibonachi [" + i + "] - " + fibonachiNumber);
			prePrev = prev;
			prev = fibonachiNumber;
		}

		return fibonachiNumber;
	}

	public static void print(int index) {
		System.out.println("############## Print Fibonachi - ("+ index +") ################");
		for (int i = 1; i <= index; i++) {
			System.out.println("Fibonachi [" + i + "] - " + generateRec(i));
		}
	}

}
