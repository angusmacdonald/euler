package nyc.angus.euler.p013;

import java.math.BigInteger;

/**
 * Solution for Project Euler #13.
 */
public class LargeSum {

	/**
	 * Get the first 10 digits of the sum of the numbers represented as strings.
	 */
	public String sumNumbers(final String[] numbers) {

		BigInteger sum = BigInteger.ZERO;

		for (final String n : numbers) {
			sum = sum.add(new BigInteger(n));
		}

		return sum.toString().substring(0, 10);
	}

}
