package nyc.angus.euler.p028;

/**
 * Solution for Project Euler #24.
 */
public class NumberSpiralDiagonals {

	/**
	 * Returns the sum of the diagonals on an n x n spiral matrix. Result is modded by 10^9+7 for hackerrank solutions.
	 */
	public long sumOfDiagonals(final long n) {
		long sum = 1;

		for (long i = 3; i <= n; i += 2) {
			// Top right corner is a square of i, so use that and subtract difference:
			sum += (i * i * 4 - (i - 1) * 6) % 1000000007L;
		}

		return sum;
	}

}
