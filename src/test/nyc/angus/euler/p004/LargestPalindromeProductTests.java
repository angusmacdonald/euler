package nyc.angus.euler.p004;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests of {@link LargestPalindromeProduct}.
 */
public class LargestPalindromeProductTests {
	@Test
	public void eulerTest() throws IOException {
		final LargestPalindromeProduct pal = new LargestPalindromeProduct();

		assertEquals(906609, pal.getLargestPrimeProduct(999999));
	}
}
