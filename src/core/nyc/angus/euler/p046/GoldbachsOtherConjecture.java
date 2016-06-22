package nyc.angus.euler.p046;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution for Project Euler #46.
 */
public class GoldbachsOtherConjecture {

	public long countVariations(final int n) {
		final List<Integer> primes = getAllPrimesBelowN(n);

		final Set<Integer> squares = getAllSquaresBelowN(n);

		return sum(n, primes, squares);
	}

	private long sum(final int target, final List<Integer> primes, final Set<Integer> squares) {
		return primes.stream().filter(prime -> squares.contains(target - prime)).count();
	}

	private List<Integer> getAllPrimesBelowN(final int n) {
		final boolean[] sieve = createPrimeSieveToN(n);

		final List<Integer> primes = new ArrayList<>(n / 2);

		for (int i = 0; i < sieve.length; i++) {
			if (sieve[i]) {
				primes.add(i);
			}
		}
		return primes;
	}

	private Set<Integer> getAllSquaresBelowN(final int target) {
		int s = 1;
		final Set<Integer> squares = new HashSet<>();

		while ((s * s * 2) < target) {
			squares.add(s * s * 2);
			s++;
		}
		return squares;
	}

	private static boolean[] createPrimeSieveToN(final int n) {
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
