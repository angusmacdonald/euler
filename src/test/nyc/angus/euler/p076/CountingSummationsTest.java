package nyc.angus.euler.p076;

import static org.junit.Assert.assertEquals;
import nyc.angus.euler.p076.CountingSummations;

import org.junit.Test;

/**
 * Tests for {@link CountingSummations}.
 */
public class CountingSummationsTest {

	@Test
	public void eulerTest() {
		assertEquals(190569291L, new CountingSummations().sum(100));
	}

}
