package nyc.angus.euler.p006;

/**
 * Solution for Project Euler #6.
 */
public class SumSquareDifference {

	/**
	 * The absolute difference between the sum of the squares of the first n natural numbers and the square of the sum.
	 */
	public static long calculateDifference(final long n) {

		final long sumN = (n * (n + 1)) / 2;
		final long sumNSqr = sumN * sumN;

		long sumSqr = 0;
		for (int i = 1; i <= n; i++) {
			sumSqr += i * i;
		}

		return Math.abs(sumSqr - sumNSqr);
	}
}
