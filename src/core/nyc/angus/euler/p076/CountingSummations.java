package nyc.angus.euler.p076;

/**
 * Solution for Project Euler #76.
 */
public class CountingSummations {

	public long sum(final int target) {
		final long[] memo = new long[target + 1];

		memo[0] = 1;
		for (int c = 1; c < target; c++) {
			for (int i = c; i <= target; i++) {
				memo[i] += memo[i - c];
				memo[i] = mod(memo[i]);
			}
		}

		return memo[memo.length - 1];
	}

	private static long modBy = ((long) Math.pow(10, 9) + 7L);

	private static long mod(final long l) {
		// The hackerrank solution uses such large numbers that the result should be modded.
		return l % modBy;
	}
}