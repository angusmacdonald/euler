package nyc.angus.euler.p077;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests of {@link PrimeSummations}.
 */
public class PrimeSummationsTest {

	@Test
	public void eulerTest() {
		// Test to check that the method works, but it is formatted for the hackerrank problem, not the project euler
		// one.
		assertTrue(new PrimeSummations().sum(70) < 5000);
		assertTrue(new PrimeSummations().sum(71) > 5000);
	}

}
