package nyc.angus.euler.p030;

import java.util.stream.IntStream;

/**
 * Solution for Project Euler #30.
 */
public class DigitNthPowers {

	public long getTotalOfDigitNthPowers(final int n) {
		return IntStream.range(2, 600000).filter(i -> (sumDigits(i, n) == i)).sum();
	}

	private int sumDigits(int i, final int n) {
		int sum = 0;

		while (i > 0) {
			sum += (int) Math.pow(i % 10, n);
			i /= 10;
		}

		return sum;
	}
}
