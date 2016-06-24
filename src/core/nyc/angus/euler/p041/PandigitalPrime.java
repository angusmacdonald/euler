package nyc.angus.euler.p041;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

/**
 * Solution for Project Euler #41.
 */
public class PandigitalPrime {

	/**
	 * Get the longest pandigital prime smaller than the given number, or null if none exists.
	 */
	public long getLongestPandigitalPrime(final long n) {
		// 4 and 7 are the only pandigital lengths that are not divisible by 3, hence have prime nums.
		return getAllPrimePanNums(4, 7).floor(n);
	}

	private static TreeSet<Long> getAllPrimePanNums(final int min, final int max) {
		final TreeSet<Long> all = new TreeSet<>();

		for (int i = min; i <= max; i++) {
			all.addAll(getPermutationsOfNDigitNumbers(i));
		}

		return all;
	}

	private static Set<Long> getPermutationsOfNDigitNumbers(final int n) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(i);
		}

		final Set<Long> results = new TreeSet<>();
		getPermutations("", sb.toString(), results);
		return results;
	}

	private static void getPermutations(final String prefix, final String current, final Set<Long> results) {
		if (current.length() == 0) {
			final long num = Long.parseLong(prefix);
			if (BigInteger.valueOf(num).isProbablePrime(10)) {
				results.add(num);
			}
			return;
		}

		for (int i = 0; i < current.length(); i++) {
			final char next = current.charAt(i);
			final String newCurrent = current.substring(0, i) + current.substring(i + 1);
			getPermutations(prefix + next, newCurrent, results);
		}
	}
}