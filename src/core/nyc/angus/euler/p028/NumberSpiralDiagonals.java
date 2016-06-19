package nyc.angus.euler.p028;

import java.math.BigInteger;

/**
 * Solution for Project Euler #24.
 */
public class NumberSpiralDiagonals {

	/**
	 * Returns the sum of the diagonals on an n x n spiral matrix;
	 */
	public String sumOfDiagonals(final long n) {
		if (n == 1) {
			return modResult(BigInteger.ONE);
		}

		BigInteger sum = BigInteger.ONE;
		BigInteger val = BigInteger.ONE;

		BigInteger adder = BigInteger.valueOf(2);

		for (long i = 3; i <= n; i += 2) {
			for (int x = 0; x < 4; x++) {
				val = val.add(adder);
				sum = sum.add(val);
			}
			adder = adder.add(BigInteger.valueOf(2));
		}

		return modResult(sum);
	}

	private String modResult(final BigInteger result) {
		if (result == null) {
			return "1";
		}

		return result.mod(BigInteger.valueOf(10).pow(9).add(BigInteger.valueOf(7))).toString();
	}
}
