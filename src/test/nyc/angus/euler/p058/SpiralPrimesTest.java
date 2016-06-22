package nyc.angus.euler.p058;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link SpiralPrimes}.
 */
public class SpiralPrimesTest {

	@Test
	public void eulerTest() {
		assertEquals(26241, new SpiralPrimes().getGridSizeForPrimeThreshold(10));
	}

}
