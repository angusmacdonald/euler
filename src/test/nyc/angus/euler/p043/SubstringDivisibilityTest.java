package nyc.angus.euler.p043;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link SubstringDivisibility}.
 */
public class SubstringDivisibilityTest {

	@Test
	public void eulerTest() {
		assertEquals(16695334890L, new SubstringDivisibility().sumMatchingNDigitNums(9));
	}

}