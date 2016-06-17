/*
 * Copyright 2016, Angus Macdonald 
 */

package nyc.angus.euler.p044;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Solution for Project Euler #44.
 */
public class PentagonNumbers {
	public Long[] getNumbers(final int n, final int k) {

		final long[] pentagonals = new long[n];
		final Set<Long> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			final long c = i + 1L;
			pentagonals[i] = (c * ((3 * c) - 1)) / 2;
			set.add(pentagonals[i]);
		}

		final List<Long> result = new LinkedList<>();

		for (int i = k; i < n; i++) {
			if (set.contains(pentagonals[i] - pentagonals[i - k]) || set.contains(pentagonals[i] + pentagonals[i - k])) {
				result.add(pentagonals[i]);
			}
		}

		return result.toArray(new Long[0]);
	}
}
