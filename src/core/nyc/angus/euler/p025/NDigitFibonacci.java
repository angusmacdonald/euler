package nyc.angus.euler.p025;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for Project Euler #24.
 */
public class NDigitFibonacci {

	private static Map<Integer, Long> results = new HashMap<>();

	public long getNumber(final int d) {
		return calc(d);
	}

	private long calc(final int n) {
		if (n == 1) {
			return 1;
		}

		if (results.containsKey(n)) {
			return results.get(n);
		}

		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;

		BigInteger fib = BigInteger.ZERO;
		final BigInteger minSize = BigInteger.valueOf(10).pow(n - 1);

		final BigInteger ten = BigInteger.valueOf(10);

		// Next num digits to record.
		BigInteger nextIncrease = BigInteger.valueOf(10);
		int length = 2;

		long count = 2;

		while (fib.compareTo(minSize) < 0) {
			fib = a.add(b);

			a = b;
			b = fib;

			count++;

			if (fib.compareTo(nextIncrease) >= 0) {
				nextIncrease = nextIncrease.multiply(ten);
				results.put(length, count);
				length++;
			}
		}

		results.put(n, count);

		return count;

	}
}