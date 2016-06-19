package nyc.angus.euler.p145;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for {@link ReversibleNumbers}.
 */
public class ReversibleNumbersTests {

	@Test
	public void eulerTest() {
		final ReversibleNumbers rev = new ReversibleNumbers();

		assertEquals(608720, rev.countReversibleNumbersBelowN(1000000000L));
	}

}
