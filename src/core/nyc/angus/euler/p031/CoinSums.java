package nyc.angus.euler.p031;

/**
 * Solution for Project Euler #31.
 */
public class CoinSums {

	public long sum(final int goal, final int[] coins) {
		final long[] memo = new long[goal + 1];

		memo[0] = 1;
		for (final int coin : coins) {
			for (int i = coin; i < goal + 1; i++) {
				memo[i] += mod(memo[i - coin]);
			}
		}

		return memo[goal];

	}

	private static long modBy = ((long) Math.pow(10, 9) + 7L);

	private static long mod(final long l) {
		// The hackerrank solution uses such large numbers that the result should be modded.
		return l % modBy;
	}
}