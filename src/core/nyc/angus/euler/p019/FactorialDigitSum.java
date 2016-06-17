package nyc.angus.euler.p019;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for Project Euler #19.
 */
public class FactorialDigitSum {

	public static Map<Integer, BigInteger> factorials = new HashMap<>();

	/**
	 * Find the sum of the digits of n!
	 */
	public long sumFactorialDigits(final int n) {
		if (n == 0) {
			return 1;
		}

		return sumDigits(sumFactorial(n));
	}

	private BigInteger sumFactorial(final int n) {
		BigInteger fact = BigInteger.valueOf(n);

		for (int i = n - 1; i > 0; i--) {
			if (factorials.containsKey(i)) {
				fact = fact.multiply(factorials.get(i));
				break;
			} else {
				fact = fact.multiply(BigInteger.valueOf(i));
			}
		}

		factorials.put(n, fact);
		return fact;
	}

	private long sumDigits(final BigInteger fact) {
		long sum = 0;

		for (final char c : fact.toString().trim().toCharArray()) {
			sum += Character.getNumericValue(c);
		}

		return sum;
	}
}
