package nyc.angus.euler.p021;

/**
 * Solution for Project Euler #21.
 */
public class AmicableNumbers {
	/**
	 * Sum the amicable numbes below n.
	 */
	public long sumAmicableNumbers(final int n) {
		return findForN(n, precomputeSums(n));
	}

	private int[] precomputeSums(final int n) {
		final int[] sums = new int[n];

		for (int i = 2; i < n; i++) {
			for (int j = i * 2; j < n; j += i) {
				sums[j] += i;
			}
		}

		return sums;
	}

	private long findForN(final int n, final int[] sums) {
		long sum = 0L;

		for (int i = 0; i < n; i++) {
			final int a = sums[i] + 1;

			if (a < sums.length) {
				final int b = sums[a] + 1;

				if (b == i && a != i && i < n) {
					sum += i;
				}
			}
		}

		return sum;
	}
}