package nyc.angus.euler.p056;

import java.math.BigInteger;

/**
 * Solution for Project Euler #56.
 */
public class PowerfulDigitSum {

	private static BigInteger TEN = BigInteger.valueOf(10);

	public long calculateSum(final int n) {
		long max = 0L;

		for (int i = n / 2; i < n; i++) {
			for (int j = n / 2; j < n; j++) {
				final BigInteger res = BigInteger.valueOf(i).pow(j);
				final long sum = sum(res);
				max = Math.max(max, sum);
			}
		}

		return max;
	}

	private long sum(BigInteger num) {

		long sum = 0;

		while (num.compareTo(BigInteger.ZERO) > 0) {
			sum += num.mod(TEN).longValue();
			num = num.divide(TEN);
		}

		return sum;
	}
}
