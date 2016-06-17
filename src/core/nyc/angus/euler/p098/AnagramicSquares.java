package nyc.angus.euler.p098;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Solution for Project Euler #98.
 */
public class AnagramicSquares {

	public long getLargestAnagramicSquareWithNDigits(final int length) {

		final long low = (long) Math.pow(10, length - 1);
		final long high = (long) Math.pow(10, length);

		final Map<String, Integer> count = new HashMap<>();
		final Map<String, Long> maxElement = new HashMap<>();

		for (long i = (long) Math.sqrt(low); i < (long) Math.sqrt(high) + 1; i++) {
			final long sq = i * i;

			final char[] arr = Long.toString(sq).toCharArray();

			if (arr.length != length) {
				continue;
			}

			Arrays.sort(arr);
			final String sorted = new String(arr);

			if (count.containsKey(sorted)) {
				count.put(sorted, count.get(sorted) + 1);
				maxElement.put(sorted, Math.max(maxElement.get(sorted), sq));
			} else {
				count.put(sorted, 1);
				maxElement.put(sorted, sq);
			}

		}

		String longest = null;
		long biggest = 0;

		for (final Entry<String, Integer> entry : count.entrySet()) {
			if (entry.getValue() > biggest) {
				biggest = entry.getValue();
				longest = entry.getKey();
			}
		}

		return maxElement.get(longest);
	}

}
