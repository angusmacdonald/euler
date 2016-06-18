package nyc.angus.euler.p003;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests of {@link LargestPrimeFactor}.
 */
public class LargestPrimeFactorTests {
	@Test
	public void eulerTest() throws IOException {
		final LargestPrimeFactor f = new LargestPrimeFactor();

		assertEquals(6857, f.getLargestPrimeFactorOfN(600851475143L));
	}
}
