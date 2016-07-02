package nyc.angus.euler.p063;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution for Project Euler #63.
 */
public class PowerfulDigitCounts {

	public List<BigInteger> getNthPowers(final int digits) {
		final List<BigInteger> nthPowers = new LinkedList<>();

		// Get the smallest and largest posible digit-length numbers.
		final BigInteger maxDig = getNumberOfLength(digits, 9);
		final BigInteger minDig = getNumberOfLength(digits, 0);

		for (int i = 0; i <= Integer.MAX_VALUE; i++) {
			final BigInteger res = BigInteger.valueOf(i).pow(digits);

			if (res.compareTo(minDig) > 0 && res.compareTo(maxDig) < 0) {
				nthPowers.add(res);
			} else if (res.compareTo(maxDig) >= 0) {
				break;
			}
		}

		return nthPowers;
	}

	private static BigInteger getNumberOfLength(final int digits, final int num) {
		String maxNum = "";

		for (int i = 0; i < digits; i++) {
			if (num == 0 && i == 0) {
				maxNum += "1";
			} else {
				maxNum += num;
			}
		}

		return new BigInteger(maxNum);
	}
}
