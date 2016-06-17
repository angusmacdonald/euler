package nyc.angus.euler.p007;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution for Project Euler #7.
 */
public class NthPrime {

	private final List<Long> primes = new LinkedList<>();

	public long getNthPrime(final int n) {
		if (n <= primes.size()) {
			return primes.get(n - 1);
		}

		int count = primes.size();
		long val = primes.get(primes.size() - 1) + 2;

		while (count < n) {
			if (isPrime(val)) {
				count++;
				primes.add(val);
			}
			val += 2;
		}

		return val - 2;
	}

	public static boolean isPrime(final long n) {
		if (n % 2 == 0) {
			return n == 2;
		}
		if (n % 3 == 0) {
			return n == 3;
		}

		int step = 4; // 6k +- 1, to remove numbers divisible by 2 and 3, alternate between jumping 4 and 2.
		for (int i = 5; i < Math.sqrt(n) + 1; step = 6 - step, i += step) {

			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
