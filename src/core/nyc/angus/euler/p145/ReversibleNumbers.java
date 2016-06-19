package nyc.angus.euler.p145;

/**
 * Solution for Project Euler #145.
 */
public class ReversibleNumbers {

	public long countReversibleNumbersBelowN(final long n) {
		long count = 0;

		for (long i = 0; i < n; i++) {
			if (i % 10 != 0) {
				count += (isOdd(i + reverse(i))) ? 1 : 0;
			}
		}

		return count;
	}

	/**
	 * Reverse the provided number.
	 */
	private long reverse(long in) {
		long out = 0L;

		while (in != 0) {
			final long next = in % 10;

			out *= 10;
			out += next;

			in /= 10;
		}

		return out;
	}

	/**
	 * Check if every digit of the provided number is odd.
	 */
	private boolean isOdd(long num) {

		while (num != 0) {
			final long next = num % 10;

			if (next % 2 == 0) {
				return false;
			}

			num /= 10;
		}

		return true;
	}
}