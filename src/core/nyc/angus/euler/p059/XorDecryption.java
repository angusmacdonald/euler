package nyc.angus.euler.p059;

import java.util.stream.IntStream;

/**
 * Solution for Project Euler #59.
 */
public class XorDecryption {

	public int sumOfDecryptedAsciiValues(final int[] message) {
		return sumAsciiValues(decrypt(message, getKey(message)));
	}

	private int sumAsciiValues(final int[] decrypted) {
		return IntStream.range(0, decrypted.length).map(i -> decrypted[i]).sum();
	}

	private int[] decrypt(final int[] message, final int[] key) {
		for (int i = 0; i < message.length; i++) {
			message[i] = message[i] ^ key[i % key.length];
		}

		return message;
	}

	private int[] getKey(final int[] message) {
		// Get the most common characters for each of the three key positions:
		final int pile1 = getMostCommonCharacter(message, 0, 3);
		final int pile2 = getMostCommonCharacter(message, 1, 3);
		final int pile3 = getMostCommonCharacter(message, 2, 3);

		final int space = ' '; // most common character

		final int[] key = { pile1 ^ space, pile2 ^ space, pile3 ^ space };

		return key;
	}

	private int getMostCommonCharacter(final int[] message, final int start, final int jump) {
		final int[] occurrences = new int[256];

		for (int i = start; i < message.length; i += jump) {
			occurrences[message[i]]++;
		}

		int max = 0;
		int idx = 0;

		for (int i = 0; i < occurrences.length; i++) {
			if (occurrences[i] > max) {
				max = occurrences[i];
				idx = i;
			}
		}

		return idx;
	}

}
