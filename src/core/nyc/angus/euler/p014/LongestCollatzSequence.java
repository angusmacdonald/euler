/*
 * Copyright 2016, Angus Macdonald 
 */

package nyc.angus.euler.p014;

/**
 * Solution for Project Euler #14.
 */
public class LongestCollatzSequence {

	public long longestSequence(final int most) {
		long biggestSoFar = 0L;
		long biggestIdx = 0L;

		for (long j = 1; j <= most; j += 2) {
			final long result = calculateLengthOfSequence(j);

			if (result >= biggestSoFar) {
				biggestSoFar = result;
				biggestIdx = j;
			}
		}

		return biggestIdx;
	}

	private int calculateLengthOfSequence(final long n) {
		if (n == 1) {
			return 0;
		}

		final long next = ((n & 1) == 0) ? n / 2 : 3 * n + 1;

		final int steps = calculateLengthOfSequence(next) + 1;

		return steps;
	}
}