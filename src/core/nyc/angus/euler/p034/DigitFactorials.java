package nyc.angus.euler.p034;

import java.util.stream.IntStream;

/**
 * Solution for Project Euler #34.
 * <p>
 * Note this problem differs quite substantially on hackerrank than it does on project euler itself. This is for the
 * hackerrank version, but it would be a trivial change for the euler one.
 */
public class DigitFactorials {

	public long getSumOfDigitFactorials(final int n) {
		return IntStream.range(10, n).filter(i -> (factorialOfDigits(i) % i == 0)).sum();
	}

	static long factorialOfDigits(int i) {
		long sum = 0;

		while (i > 0) {
			sum += factorial(i % 10);
			i /= 10;
		}

		return sum;
	}

	private static long[] factorials = new long[10];

	private static long factorial(final int n) {
		if (factorials[n] > 0) {
			return factorials[n];
		}

		long product = 1;

		for (int i = 2; i <= n; i++) {
			product *= i;
		}

		factorials[n] = product;

		return product;
	}
}