package nyc.angus.euler.p049;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link PrimePermutations}.
 */
public class PrimePermutationsTests {

	@Test
	public void eulerTest() {
		final PrimePermutations perm = new PrimePermutations();

		assertEquals(296962999629L, perm.getLargestSequence(9999, 3));
	}

}
