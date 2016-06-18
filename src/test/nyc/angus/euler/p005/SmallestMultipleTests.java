package nyc.angus.euler.p005;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests of {@link SmallestMultiple}.
 */
public class SmallestMultipleTests {
	@Test
	public void eulerTest() throws IOException {
		final SmallestMultiple mul = new SmallestMultiple();

		assertEquals(232792560, mul.getSmallestMultiple(20));
	}
}
