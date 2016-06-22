package nyc.angus.euler.p043;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for Project Euler #43.
 */
public class SubstringDivisibility {

	public long sumMatchingNDigitNums(final int n) {
		final Set<String> permutations = getPermutationsOfNDigitNumbers(n);

		long sum = 0;

		for (final String i : permutations) {
			final boolean isValid = isDivisible(i);

			if (isValid) {
				sum += Long.parseLong(i);
			}
		}

		return sum;
	}

	private boolean isDivisible(final String num) {

		final int[] divisors = { 2, 3, 5, 7, 11, 13, 17 };
		int divisorIdx = 0;

		int start = 1;

		while (start + 2 < num.length()) {
			final long a = Long.parseLong(num.substring(start, start + 3));

			if (a % divisors[divisorIdx++] != 0) {
				return false;
			}
			start++;
		}

		return true;
	}

	private Set<String> getPermutationsOfNDigitNumbers(final int n) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= n; i++) {
			sb.append(i);
		}

		final Set<String> results = new HashSet<>();
		getPermutations("", sb.toString(), results);
		return results;
	}

	private void getPermutations(final String prefix, final String current, final Set<String> results) {
		if (current.length() == 0) {
			results.add(prefix);
			return;
		}

		for (int i = 0; i < current.length(); i++) {
			final char next = current.charAt(i);
			final String newCurrent = current.substring(0, i) + current.substring(i + 1);
			getPermutations(prefix + next, newCurrent, results);
		}
	}
}
