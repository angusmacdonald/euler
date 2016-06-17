package nyc.angus.euler.p089;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for Project Euler #89.
 */
public class RomanNumerals {

	public String getValidRomanNumeral(final String romanNumeral) {
		final long num = romanToNumber(romanNumeral.toCharArray());

		final StringBuilder sb = new StringBuilder();
		numberToRoman(num, sb);

		return sb.toString();
	}

	private long romanToNumber(final char[] roman) {
		final Map<Character, Integer> values = getValues();

		final long prev = values.get(roman[0]);

		long sum = prev;

		for (int i = 1; i < roman.length; i++) {
			final int curr = values.get(roman[i]);

			if (curr > prev) {
				sum -= prev;
				sum += curr - prev;
			} else {
				sum += curr;
			}
		}

		return sum;
	}

	private void numberToRoman(long num, final StringBuilder sb) {
		// I can only be subtracted from V and X.
		// I = 1, V = 5, X = 10
		// X can only be subtracted from L and C.
		// X = 10, L = 50, C = 100
		// C can only be subtracted from D and M.
		// C = 100, D = 500, M = 1000
		// V, L, D and M can't be subtracted from any symbol.
		// V = 5, L = 50, D = 500, M = 1000
		// At most one symbol can be subtracted from another symbol.
		// No numeral appears more than 3 times in a row
		// None of V, L, D appear even twice in a row
		// V = 5, L = 50, D = 500
		while (num > 0) {
			if (num >= 1000) {
				sb.append('M');
				num -= 1000;
			} else if (num >= 900) {
				sb.append("CM");
				num -= 900;
			} else if (num >= 500) {
				sb.append('D');
				num -= 500;
			} else if (num >= 400) {
				sb.append("CD");
				num -= 400;
			} else if (num >= 100) {
				sb.append('C');
				num -= 100;
			} else if (num >= 90) {
				sb.append("XC");
				num -= 90;
			} else if (num >= 50) {
				sb.append('L');
				num -= 50;
			} else if (num >= 40) {
				sb.append("XL");
				num -= 40;
			} else if (num >= 10) {
				sb.append('X');
				num -= 10;
			} else if (num >= 9) {
				sb.append("IX");
				num -= 9;
			} else if (num >= 5) {
				sb.append('V');
				num -= 5;
			} else if (num == 4) {
				sb.append("IV");
				num -= 4;
			} else if (num > 0) {
				sb.append('I');
				num -= 1;
			}
		}
	}

	private Map<Character, Integer> getValues() {
		final Map<Character, Integer> values = new HashMap<>();
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);

		return values;
	}
}