package nyc.angus.euler.p024;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for Project Euler #24.
 */
public class LexicographicPermutations {

	private static Map<Integer, BigInteger> factorials = new HashMap<>();

	private static char[] word = "abcdefghijklm".toCharArray();

	public String perm(long n) {
		final List<Integer> positions = new ArrayList<>(word.length);

		for (int i = 0; i < word.length; i++) {
			positions.add(i);
		}

		final StringBuilder sb = new StringBuilder();
		int remaining = word.length - 1;

		while (n > 0 && remaining > 0) {
			final long fact = factorial(remaining);

			final int timesInto = timesInto(fact, n);

			final int pos = positions.get(timesInto);
			positions.remove(timesInto);

			sb.append(word[pos]);

			n -= (fact * timesInto);
			remaining--;

		}
		for (final int pos : positions) {
			sb.append(word[pos]);
		}

		return sb.toString();

	}

	private int timesInto(final long fact, final long n) {
		long num = 0;

		int count = 0;
		while (num < n) {
			num += fact;
			count++;
		}

		return count - 1;
	}

	private long factorial(final int n) {

		if (n == 0) {
			return 1;
		}

		BigInteger fact = BigInteger.valueOf(n);

		for (int i = n - 1; i > 0; i--) {
			if (factorials.containsKey(i)) {
				fact = fact.multiply(factorials.get(i));
				break;
			} else {
				fact = fact.multiply(BigInteger.valueOf(i));
			}
		}

		factorials.put(n, fact);

		return fact.longValue();
	}
}
