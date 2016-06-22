package nyc.angus.euler.p058;

import java.math.BigInteger;

/**
 * Solution for Project Euler #58.
 */
public class SpiralPrimes {

	/**
	 * Returns the size of the grid (the n in n x n) that is required before the threshold of primes to non-primes on
	 * diagonals is less than the provided parameter.
	 * <p>
	 * {@link BigInteger#isProbablePrime(int)} is used because for low thresholds (e.g. 8) values go above what can be
	 * stored in a prime sieve.
	 */
	public long getGridSizeForPrimeThreshold(final long threshold) {

		BigInteger val = BigInteger.valueOf(1);

		final BigInteger two = BigInteger.valueOf(2);

		BigInteger adder = two;

		final long n = Long.MAX_VALUE;

		long primes = 0;
		long total = 1;

		/*
		 * Diagonals are on the corners of an ever increasing matrix. Starting with a matrix of size 3, go to each
		 * corner. Corners start being a series increasing by 2, and every time the matrix is expanded this increment is
		 * increased by another two.
		 */
		for (long i = 3; i <= n; i += 2) {
			for (int x = 0; x < 4; x++) {
				val = val.add(adder);

				if (val.isProbablePrime(8)) {
					primes++;
				}
				total++;

			}

			if (isThresholdBroken(threshold, primes, total)) {
				return i;
			}

			adder = adder.add(two);
		}

		return -1;
	}

	private boolean isThresholdBroken(final long threshold, final long primes, final long total) {
		return ((primes * 100) / total) < threshold;
	}
}
