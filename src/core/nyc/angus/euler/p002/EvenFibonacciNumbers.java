package nyc.angus.euler.p002;

/**
 * Solution for Project Euler #2.
 */
public class EvenFibonacciNumbers {

	public static long calc(final long n) {

		long prev2 = 1;
		long prev = 1;

		long sum = 0;

		while (prev + prev2 <= n) {
			final long next = prev + prev2;

			sum += (next % 2 == 0) ? next : 0;

			prev2 = prev;
			prev = next;
		}

		return sum;
	}
}
