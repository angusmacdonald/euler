package nyc.angus.euler.p059;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;

/**
 * Tests of {@link XorDecryption}.
 */
public class XorDecryptionTest {

	@Test
	public void eulerTest() throws IOException {
		final String data = Files.readAllLines(new File("resources" + File.separator + "p059_cipher.txt").toPath()).get(0);
		final String[] numsStr = data.split(",");

		final int[] nums = new int[numsStr.length];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numsStr[i]);
		}

		assertEquals(107359, new XorDecryption().sumOfDecryptedAsciiValues(nums));
	}

}
