package nyc.angus.euler.p001;

/**
 * Solution for Project Euler #1.
 */
public class Multiples3And5 {

	public long calculateSumBelowN(final int n) {
		if (n <= 3) {
			return 0l;
		}

		long top3 = n / 3;

		if (n % 3 == 0) {
			top3--;
		}

		long top5 = n / 5;

		if (n % 5 == 0) {
			top5--;
		}

		long top15 = n / 15;

		if (n % 15 == 0) {
			top15--;
		}

		final long sum5 = (top5 * (top5 + 1)) / 2;
		final long sum3 = (top3 * (top3 + 1)) / 2;
		final long sum15 = (top15 * (top15 + 1)) / 2;

		return sum3 * 3 + sum5 * 5 - sum15 * 15;
	}
}