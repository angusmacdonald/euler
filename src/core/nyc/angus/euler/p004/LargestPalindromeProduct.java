package nyc.angus.euler.p004;

/**
 * Solution for Project Euler #4.
 */
public class LargestPalindromeProduct {

	/**
	 * Largest prime product made from two three-digit palindromic numbers less than n.
	 */
	public static int getLargestPrimeProduct(final int n) {

		int largest = 0;

		for (int i = 999; i >= 100; i--) {
			for (int j = i; j >= 100; j--) {
				if (j > i) {
					break;
				}

				final int product = i * j;

				if (product >= n) {
					continue;
				}

				if (isPalindrome(product)) {
					largest = Math.max(largest, product);
					break;
				}
			}
		}

		return largest;
	}

	public static boolean isPalindrome(final int num) {
		final String s = Integer.toString(num);

		return s.equals(new StringBuilder(s).reverse().toString());
	}
}