package nyc.angus.euler.p015;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link PowerDigitSum}.
 */
public class PowerDigitSumTest {

	@Test
	public void eulerTest() {
		assertEquals(1366L, new PowerDigitSum().digitSum(1000));
	}

}
