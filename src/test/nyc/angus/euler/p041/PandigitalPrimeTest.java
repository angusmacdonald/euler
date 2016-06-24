package nyc.angus.euler.p041;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link PandigitalPrime}.
 */
public class PandigitalPrimeTest {
	@Test
	public void eulerTest() {
		assertEquals(7652413, new PandigitalPrime().getLongestPandigitalPrime(10000000000L));
	}

}
