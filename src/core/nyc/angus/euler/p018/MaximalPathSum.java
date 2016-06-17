package nyc.angus.euler.p018;

/**
 * Solution for Project Euler #18.
 */
public class MaximalPathSum {

	public int calculateMaxPathSum(final int[][] triangle, final int r, final int c) {

		if (r == triangle.length || c < 0 || c == triangle[r].length) {
			return 0;
		}

		final int left = calculateMaxPathSum(triangle, r + 1, c);
		final int right = calculateMaxPathSum(triangle, r + 1, c + 1);

		return Math.max(left, right) + triangle[r][c];
	}
}
