package nyc.angus.euler.p030;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link DigitNthPowers}.
 */
public class DigitNthPowersTest {

	@Test
	public void eulerTest() {
		assertEquals(443839, new DigitNthPowers().getTotalOfDigitNthPowers(5));
	}

}
