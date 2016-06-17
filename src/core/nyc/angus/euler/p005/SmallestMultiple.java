package nyc.angus.euler.p005;

/**
 * Solution for Project Euler #5.
 */
public class SmallestMultiple {

	/**
	 * Get the smallest multiple that can be evenly divided by all numbers from 1-n.
	 */
	public static void getSmallestMultiple(final int n) {

		long num = n;

		while (!divisible(num, n)) {
			num += n;
		}

		System.out.println(num);

	}

	public static boolean divisible(final long num, final int n) {
		for (int i = n; i > 0; i--) {
			if (num % i != 0) {
				return false;
			}
		}

		return true;
	}
}
