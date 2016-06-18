package nyc.angus.euler.p003;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Solution for Project Euler #3.
 */
public class LargestPrimeFactor {

	public long getLargestPrimeFactorOfN(long n) {
		final PriorityQueue<Long> factors = new PriorityQueue<Long>(100, Collections.reverseOrder());

		long d = 2;

		while (n > 1) {
			while (n % d == 0) {
				factors.add(d);
				n /= d;
			}

			d++;

			if (d * d > n) {
				if (n > 1) {
					factors.add(n);
				}
				break;
			}
		}

		return factors.poll();
	}
}