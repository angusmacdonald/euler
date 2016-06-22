package nyc.angus.euler.p028;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link NumberSpiralDiagonals}.
 */
public class NumberSpiralDiagonalsTest {

	@Test
	public void eulerTest() {
		final NumberSpiralDiagonals diag = new NumberSpiralDiagonals();

		assertEquals(669171001, diag.sumOfDiagonals(1001));
	}

}
