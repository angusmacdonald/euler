package nyc.angus.euler.p077;

/**
 * Solution for Project Euler #77.
 */
public class PrimeSummations {

	public long sum(final int target) {
		final long[] memo = new long[target + 1];
		final boolean[] isPrime = createPrimeSieveToN(target);

		memo[0] = 1;
		for (int p = 0; p <= target; p++) {
			if (isPrime[p]) {
				for (int i = p; i <= target; i++) {
					memo[i] += memo[i - p];
				}
			}
		}

		return memo[memo.length - 1];

	}

	private static boolean[] createPrimeSieveToN(final int n) {
		final boolean[] primes = new boolean[n + 1];

		for (int i = 2; i < primes.length; i++) {
			primes[i] = true;
		}

		for (int i = 2; i * i <= n; i++) {

			if (primes[i]) {
				for (int j = i; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}

		return primes;
	}
}
