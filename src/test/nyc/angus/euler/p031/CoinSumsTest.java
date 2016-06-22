package nyc.angus.euler.p031;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link CoinSums}.
 */
public class CoinSumsTest {

	@Test
	public void eulerTest() {
		final int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
		assertEquals(73682, new CoinSums().sum(200, coins));
	}

}
