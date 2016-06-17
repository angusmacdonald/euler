package nyc.angus.euler.p017;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution for Project Euler #17.
 */
public class NumberToWords {

	private static String[] small = { "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	private static String[] tens = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	private static String[] large = { "", "Thousand", "Million", "Billion", "Trillion" };

	public String convertNumberToWords(long n) {
		if (n == 0) {
			return "Zero";
		}

		final List<String> entries = new LinkedList<>();

		int thousand = 0;

		while (n > 0) {
			final long next = n % 1000;

			final String res = toStringThousandsPart((int) next, thousand).toString().trim();

			if (res.length() > 0) {
				entries.add(res);
			}

			n /= 1000;
			thousand++;
		}

		Collections.reverse(entries);
		return buildResult(entries);
	}

	private StringBuilder toStringThousandsPart(int n, final int thousand) {
		final StringBuilder sb = new StringBuilder();
		boolean space = false;
		boolean thousandAdded = false;

		if (n >= 100) {
			sb.append(small[(n / 100) - 1]);
			sb.append(" ");
			sb.append("Hundred");
			space = true;
		}

		n = n % 100;

		if (n > 19) {
			if (space) {
				sb.append(" ");
			}
			space = true;
			sb.append(tens[(n / 10) - 2]);

			n = n % 10;

			if (n == 0 && thousand > 0) {
				sb.append(" ");
				sb.append(large[thousand]);
				thousandAdded = true;
			}
		}

		if (n > 0) {
			if (space) {
				sb.append(" ");
			}
			sb.append(small[n - 1]);

			if (thousand > 0) {
				sb.append(" ");
				sb.append(large[thousand]);
			}
		} else if (!thousandAdded && space && thousand > 0) {
			sb.append(" ");
			sb.append(large[thousand]);
		}

		return sb;
	}

	private String buildResult(final List<String> entries) {
		final StringBuilder sb = new StringBuilder();

		for (final String entry : entries) {
			sb.append(entry.trim());
			sb.append(" ");
		}
		return sb.toString().trim();
	}

}