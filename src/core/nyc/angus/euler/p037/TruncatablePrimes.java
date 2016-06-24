package nyc.angus.euler.p037;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Solution for Project Euler #37.
 */
public class TruncatablePrimes {

	public long sumTruncatablePrimesBelowN(final int n) {
		final Set<Integer> primes = getSetOfAllPrimesBelowN(n);

		long sum = 0L;

		for (final int i : primes) {
			sum += isTruncatable(i, primes) ? i : 0;
		}

		return sum;
	}

	private static boolean isTruncatable(final int n, final Set<Integer> primes) {
		if (n < 10) {
			return false;
		}

		final char[] num = Integer.toString(n).toCharArray();

		String s = "";

		for (final char element : num) {
			s += element;
			if (!primes.contains(Integer.parseInt(s))) {
				return false;
			}
		}

		s = "";

		for (int i = num.length - 1; i >= 0; i--) {
			s = num[i] + s;
			if (!primes.contains(Integer.parseInt(s))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Creates a prime sieve to find all prime numbers below n.
	 */
	private static Set<Integer> getSetOfAllPrimesBelowN(final int n) {
		return convertToStream(createSieve(n)).collect(Collectors.toSet());
	}

	/**
	 * Create a prime sieve for all numbers from 1-n inclusive.
	 */
	private static boolean[] createSieve(final int n) {
		final boolean[] primes = new boolean[n + 1];

		// Set all potential prime elements to true:
		for (int i = 2; i < primes.length; i++) {
			primes[i] = true;
		}

		// Eliminate composite numbers:
		for (int i = 2; i * i <= n; i++) {
			if (primes[i]) {
				for (int j = i; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}

		return primes;
	}

	private static Stream<Integer> convertToStream(final boolean[] primes) {
		return IntStream.range(2, primes.length - 1).filter(i -> primes[i]).boxed();
	}
}
