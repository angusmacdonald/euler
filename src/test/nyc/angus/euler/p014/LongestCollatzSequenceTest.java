package nyc.angus.euler.p014;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link LongestCollatzSequence}.
 */
public class LongestCollatzSequenceTest {

	@Test
	public void eulerTest() {
		final LongestCollatzSequence seq = new LongestCollatzSequence();

		assertEquals(837799, seq.longestSequence(1000000));
	}
}
