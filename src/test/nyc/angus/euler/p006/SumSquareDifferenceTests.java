package nyc.angus.euler.p006;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests of {@link SumSquareDifference}.
 */
public class SumSquareDifferenceTests {
	@Test
	public void eulerTest() throws IOException {
		final SumSquareDifference dif = new SumSquareDifference();

		assertEquals(25164150, dif.calculateDifference(100));
	}
}
