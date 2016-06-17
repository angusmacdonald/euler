package nyc.angus.euler.p023;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Solution for Project Euler #23.
 */
public class NonAbundantSums {

	public String getForN(final int n) {
		final TreeSet<Integer> abundantNums = precompute(n);

		return find(n, abundantNums);
	}

	private TreeSet<Integer> precompute(final int n) {
		final TreeSet<Integer> abundantNums = new TreeSet<>();

		final int[] sums = new int[n];

		for (int i = 2; i < n; i++) {
			for (int j = i * 2; j < n; j += i) {
				sums[j] += i;
			}
		}

		for (int i = 2; i < n; i++) {
			if (sums[i] > i) {
				abundantNums.add(i);
			}
		}
		return abundantNums;
	}

	private String find(final int n, final TreeSet<Integer> abundantNums) {
		final SortedSet<Integer> possibleNums = abundantNums.headSet(n);

		final Set<Integer> subtractions = new HashSet<>();

		for (final int num : possibleNums) {
			subtractions.add(n - num);
		}

		for (final int num : possibleNums) {
			if (subtractions.contains(num)) {
				return "YES";
			}
		}

		return "NO";
	}
}
