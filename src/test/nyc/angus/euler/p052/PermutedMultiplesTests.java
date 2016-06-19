package nyc.angus.euler.p052;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link PermutedMultiples}.
 */
public class PermutedMultiplesTests {

	@Test
	public void eulerTest() {
		final PermutedMultiples perm = new PermutedMultiples();

		assertEquals(142857, perm.findPermutedMultipleSeries(1000000, 6));
	}

}
