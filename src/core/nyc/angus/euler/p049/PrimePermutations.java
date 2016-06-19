package nyc.angus.euler.p049;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Solution for Project Euler #49.
 */
public class PrimePermutations {

	/**
	 * Get the largest prime sequence where the starting number is less than n, and the sequence is of length k.
	 */
	public long getLargestSequence(final int n, final int k) {
		final ArrayList<Integer> primes = getPrimes(n * 2, 1000);
		return findProgression(k, primes, n).last();
	}

	private Long combine(final List<Integer> l) {
		final StringBuilder sb = new StringBuilder();

		for (final int i : l) {
			sb.append(i);
		}

		return Long.parseLong(sb.toString());
	}

	private TreeSet<Long> findProgression(final int length, final ArrayList<Integer> primes, final int max) {
		final Set<Integer> primeSet = new HashSet<>(primes);

		final TreeSet<Long> results = new TreeSet<>();

		for (final int num : primes) {
			if (num > max) {
				break;
			}

			final TreeSet<Integer> permutations = getPrimePermutations(num, primeSet);

			final List<Integer> progression = findProgression(permutations, length);

			if (!progression.isEmpty()) {
				results.add(combine(progression));
			}
		}

		return results;
	}

	private List<Integer> findProgression(final TreeSet<Integer> perms, final int length) {
		if (perms.size() < length) {
			return Collections.emptyList();
		}

		final int first = perms.pollFirst();

		final List<Integer> entries = new LinkedList<>();

		for (final int p : perms) {
			entries.clear();
			entries.add(first);
			entries.add(p);

			final int diff = p - first;

			int next = p;

			do {
				next += diff;

				if (perms.contains(next)) {
					entries.add(next);
				} else {
					break;
				}
			} while (entries.size() < length);

			if (entries.size() == length) {
				return entries;
			}
		}

		return new LinkedList<>();
	}

	private TreeSet<Integer> getPrimePermutations(final int num, final Set<Integer> primeSet) {
		final TreeSet<Integer> results = new TreeSet<>();

		results.add(num);

		perm("", num + "", results, num, primeSet);

		return results;
	}

	private void perm(final String current, String remaining, final TreeSet<Integer> result, final int min, final Set<Integer> primeSet) {

		if (remaining.length() == 0) {
			final int num = Integer.parseInt(current);
			if (primeSet.contains(num) && num > min) {
				result.add(Integer.parseInt(current));
			}
			return;
		}

		final char next = remaining.charAt(0);
		remaining = remaining.substring(1);

		for (int i = 0; i <= current.length(); i++) {
			final String before = current.substring(0, i);
			final String after = current.substring(i);

			perm(before + next + after, remaining, result, min, primeSet);
		}
	}

	private ArrayList<Integer> getPrimes(final int max, final int min) {
		final boolean[] isPrime = new boolean[max + 1];

		for (int i = 2; i < isPrime.length; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i < max; i++) {
			if (isPrime[2]) {
				for (int j = i * i; j <= max; j += i) {
					isPrime[j] = false;
				}
			}
		}

		final ArrayList<Integer> primes = new ArrayList<>();

		for (int i = min; i < isPrime.length; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}

		return primes;
	}

}
