package nyc.angus.euler.p008;

/**
 * Solution for Project Euler #8.
 */
public class LargestSeriesProduct {

	/**
	 * The greatest product of k consecutive digits in the n digit number.
	 */
	public long calc(final int k, final String num) {
		final char[] arr = num.toCharArray();

		long sum = getSumOfFirstKEntries(k, arr);
		long largest = sum;

		// Iterate through all sum possibilities.
		for (int i = k; i < arr.length; i++) {
			final int old = Character.getNumericValue(arr[i - k]);
			if (sum != 0) {
				sum /= old;
				sum *= Character.getNumericValue(arr[i]);
			} else if (old == 0) {
				sum = 1;
				for (int j = 0; j < k; j++) {
					sum *= Character.getNumericValue(arr[i - j]);
				}
			} else {
				sum = 0;
			}

			largest = Math.max(largest, sum);
		}

		return largest;
	}

	private long getSumOfFirstKEntries(final int k, final char[] arr) {
		long sum = 1;

		for (int i = 0; i < k; i++) {
			sum *= Character.getNumericValue(arr[i]);
		}
		return sum;
	}
}