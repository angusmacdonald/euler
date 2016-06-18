/*
 * Copyright 2016, Angus Macdonald 
 */

package nyc.angus.euler.p062;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Solution for Project Euler #62.
 */
public class CubicPermutations {

	/**
	 * Find all cubes, where there are k permutations of the cube of some number less than n.
	 */
	public List<Long> findCubesWithKPermutations(final int n, final int k) {

		final List<Long> result = findSmallestCube(n, k);

		Collections.sort(result);

		return result;
	}

	private List<Long> findSmallestCube(final int n, final int k) {

		final long[] cubesArr = calculateCubes(n);

		final Map<String, PermEntry> count = new HashMap<>();

		for (int i = 0; i < n; i++) {
			final long cubeOfi = cubesArr[i];

			final String sorted = sort(Long.toString(cubeOfi));

			if (count.containsKey(sorted)) {
				final PermEntry entry = count.get(sorted);
				entry.addNew(cubeOfi);
			} else {
				count.put(sorted, new PermEntry(1, cubeOfi));
			}
		}

		return reduce(count, k);
	}

	private List<Long> reduce(final Map<String, PermEntry> count, final int k) {
		final List<Long> results = new LinkedList<>();

		for (final Entry<String, PermEntry> ent : count.entrySet()) {
			final PermEntry entry = ent.getValue();

			if (entry.occurences == k) {
				results.add(entry.smallest);
			}
		}

		return results;
	}

	private String sort(final String original) {
		final char[] chars = original.toCharArray();
		Arrays.sort(chars);
		return new StringBuilder(new String(chars)).reverse().toString();
	}

	private long[] calculateCubes(final int n) {
		final long[] cubesArr = new long[n];

		for (int i = 0; i < n; i++) {
			final long cube = (long) Math.pow(i, 3);
			cubesArr[i] = cube;
		}

		return cubesArr;

	}

	private class PermEntry {
		int occurences;
		long smallest;

		public PermEntry(final int o, final long s) {
			this.occurences = o;
			this.smallest = s;
		}

		public void addNew(final long val) {
			occurences++;

			if (val < smallest) {
				smallest = val;
			}
		}
	}
}
