package nyc.angus.euler.p009;

/**
 * Solution for Project Euler #9.
 */
public class SpecialPythagoreanTriple {

	public long getForSum(final int sum) {
		final long n = sum;

		long max = -1;
		for (int i = 3; i < sum; i++) {
			final long a = i;

			final long b = ((n - a) + ((a * a) / (a - n))) / 2;

			final long c = ((n - a) - ((a * a) / (a - n))) / 2;

			if ((c == StrictMath.hypot(a, b) && (a + b + c) == sum)) {
				max = Math.max(max, a * b * c);
			}

		}

		return max;
	}

}