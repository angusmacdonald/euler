package nyc.angus.euler.p082;

/**
 * Solution for Project Euler #82.
 */
public class ThreeWayPathSum {

	/**
	 * Get the minimum path sum needed to go from the left column to the right column.
	 */
	public long getMinimumPathSum(final long[][] matrix) {
		final long[] dp = new long[matrix.length];

		// Set last column values:
		for (int y = 0; y < matrix.length; y++) {
			dp[y] = matrix[y][matrix.length - 1];
		}

		// Go through columns from right to left.
		for (int x = matrix.length - 2; x >= 0; x--) {
			// Go down column, determining if it is better to go up or right.
			// It is always better to go right at the top.
			dp[0] += matrix[0][x];
			for (int y = 1; y < matrix.length; y++) {
				dp[y] = Math.min(dp[y - 1] + matrix[y][x], dp[y] + matrix[y][x]);
			}

			// Go up column, determining if it is better to use previous val, or go down.
			for (int y = matrix.length - 2; y >= 0; y--) {
				dp[y] = Math.min(dp[y], dp[y + 1] + matrix[y][x]);
			}
		}

		return getMinimum(matrix, dp);
	}

	private long getMinimum(final long[][] matrix, final long[] dp) {
		long min = Long.MAX_VALUE;

		for (int y = 0; y < matrix.length; y++) {
			min = Math.min(min, dp[y]);
		}

		return min;
	}
}