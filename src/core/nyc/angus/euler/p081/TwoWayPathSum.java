package nyc.angus.euler.p081;

/**
 * Solution for Project Euler #81.
 */
public class TwoWayPathSum {

	/**
	 * Get the minimum path sum from top-left element to the bottom-right element.
	 */
	public long getMinimumPathSum(final long[][] matrix) {
		final long[][] dp = new long[matrix.length][matrix[0].length];

		/*
		 * Fill out the dp array with the values from the right column and bottom row, as there is nowhere else to go
		 * but down and right respectively.
		 */
		dp[matrix.length - 1][matrix[0].length - 1] = matrix[matrix.length - 1][matrix[0].length - 1];

		for (int y = matrix.length - 2; y >= 0; y--) {
			dp[y][matrix[0].length - 1] = matrix[y][matrix[0].length - 1] + dp[y + 1][matrix[0].length - 1];
		}

		for (int x = matrix[0].length - 2; x >= 0; x--) {
			dp[matrix.length - 1][x] = matrix[matrix.length - 1][x] + dp[matrix.length - 1][x + 1];
		}

		/*
		 * Iterate through the remainder of the matrix, picking the lowest possible down or right neighbor.
		 */
		for (int y = matrix.length - 2; y >= 0; y--) {
			for (int x = matrix[0].length - 2; x >= 0; x--) {
				dp[y][x] = Math.min(dp[y + 1][x], dp[y][x + 1]) + matrix[y][x];
			}
		}

		return dp[0][0];
	}
}