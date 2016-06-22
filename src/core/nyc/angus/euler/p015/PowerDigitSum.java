package nyc.angus.euler.p015;

import java.math.BigInteger;

/**
 * Solution for Project Euler #15.
 */
public class PowerDigitSum {

	private static BigInteger TWO = BigInteger.valueOf(2);

	public long digitSum(final int num) {
		final String power = TWO.pow(num).toString();
		return power.chars().map(i -> Character.getNumericValue(i)).sum();
	}
}