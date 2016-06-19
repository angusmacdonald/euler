package nyc.angus.euler.p052;

import java.util.Arrays;

/**
 * Solution for Project Euler #52.
 */
public class PermutedMultiples {

	/**
	 * Find the smallest start to a k length series of permuted multiples, where the start is less than n.
	 */
	public long findPermutedMultipleSeries(final int n, final int k) {
		// 125874 is minimum possible
		for (int i = 125874; i <= n; i++) {
			final String str = Integer.toString(i);

			int count = 1;

			boolean match = true;

			int cur = i;

			do {
				cur = i * (count + 1);

				final String nextStr = Integer.toString(cur);

				if (str.length() != nextStr.length()) {
					break;
				}

				match = checkEquality(str, nextStr);

				if (match) {
					count++;
				}

			} while (count < k && match);

			if (count == k) {
				return i;
			}
		}

		return -1;
	}

	static boolean checkEquality(final String a, final String b) {
		final String aS = sort(a);
		final String bS = sort(b);

		return aS.equals(bS);
	}

	static String sort(final String str) {
		final char[] chars = str.toCharArray();
		Arrays.sort(chars);
		final String sorted = new String(chars);
		return sorted;
	}
}