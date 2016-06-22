package nyc.angus.euler.p046;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests for {@link GoldbachsOtherConjecture}.
 */
public class GoldbachsOtherConjectureTest {

	@Test
	public void hackerRankTest() {
		final GoldbachsOtherConjecture gold = new GoldbachsOtherConjecture();

		assertTrue(gold.countVariations(5775) > 0);
		assertEquals(0, gold.countVariations(5777));
	}

}
