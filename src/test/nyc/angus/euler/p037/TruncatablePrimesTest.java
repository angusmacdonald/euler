package nyc.angus.euler.p037;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link TruncatablePrimes}.
 */
public class TruncatablePrimesTest {

	@Test
	public void eulerTest() {
		assertEquals(748317, new TruncatablePrimes().sumTruncatablePrimesBelowN(1000000));
	}

}
