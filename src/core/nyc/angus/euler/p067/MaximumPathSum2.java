/*
 * Copyright 2016, Angus Macdonald 
 */

package nyc.angus.euler.p067;


/**
 * Solution for Project Euler #67.
 */
public class MaximumPathSum2 {

	public int getMaximumPathSum(final int[][] triangle) {

		final int[][] dp = new int[triangle.length][0];

		for (int y = 0; y < dp.length; y++) {
			dp[y] = new int[y + 1];
		}

		return getMaximumPathSumInternal(triangle, 0, 0, dp);

	}

	private int getMaximumPathSumInternal(final int[][] triangle, final int x, final int y, final int[][] dp) {
		if (y == triangle.length - 1) {
			return triangle[y][x];
		}

		if (dp[y][x] == 0) {
			final int a = getMaximumPathSumInternal(triangle, x, y + 1, dp);
			final int b = getMaximumPathSumInternal(triangle, x + 1, y + 1, dp);

			dp[y][x] = Math.max(a, b) + triangle[y][x];
		}

		return dp[y][x];
	}
}
