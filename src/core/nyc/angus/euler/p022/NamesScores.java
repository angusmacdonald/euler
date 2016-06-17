package nyc.angus.euler.p022;

import java.util.TreeSet;

/**
 * Solution for Project Euler #22.
 */
public class NamesScores {

	public long getScoreSum(final String[] input) {

		final TreeSet<String> names = new TreeSet<>();

		for (final String name : input) {
			names.add(name);
		}

		long sum = 0L;

		for (final String name : names) {
			sum += getScore(name, names);
		}

		return sum;
	}

	private long getScore(final String name, final TreeSet<String> names) {
		final int sum = getSum(name);

		final int pos = getPos(name, names) + 1;

		return pos * sum;
	}

	private int getPos(final String name, final TreeSet<String> names) {
		return names.headSet(name).size();
	}

	private int getSum(final String name) {
		final char[] nameArr = name.toUpperCase().toCharArray();

		int sum = 0;

		for (final char c : nameArr) {
			sum += (c - 'A') + 1;
		}

		return sum;
	}
}
