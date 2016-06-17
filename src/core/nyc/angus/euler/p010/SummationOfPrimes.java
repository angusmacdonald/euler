/*
 * Copyright 2016, Angus Macdonald 
 */

package nyc.angus.euler.p010;

/**
 * Solution for Project Euler #10.
 */
public class SummationOfPrimes {

	/**
	 * Get the sum of all primes less than N.
	 */
	public long sumPrimesToN(final int n) {
		return sum(createPrimeSieveToN(n), n);
	}

	public long sum(final boolean[] primes, final int n) {
		long sum = 0L;

		for (int i = 0; i <= n; i++) {
			if (primes[i]) {
				sum += i;
			}
		}

		return sum;
	}

	public boolean[] createPrimeSieveToN(final int n) {
		final boolean[] primes = new boolean[n + 1];

		for (int i = 2; i < primes.length; i++) {
			primes[i] = true;
		}

		for (int i = 2; i * i <= n; i++) {

			if (primes[i]) {
				for (int j = i; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}

		return primes;
	}
}