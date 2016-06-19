package nyc.angus.euler.p009;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link SpecialPythagoreanTriple}.
 */
public class SpecialPythagoreanTripleTests {

	@Test
	public void eulerTest() {
		final SpecialPythagoreanTriple pyth = new SpecialPythagoreanTriple();

		assertEquals(31875000, pyth.getForSum(1000));
	}

}
