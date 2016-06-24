package nyc.angus.euler.p034;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link DigitFactorials}.
 */
public class DigitFactorialsTest {

	@Test
	public void hackerRankTest() {
		assertEquals(27093, new DigitFactorials().getSumOfDigitFactorials(10000));
	}

}
