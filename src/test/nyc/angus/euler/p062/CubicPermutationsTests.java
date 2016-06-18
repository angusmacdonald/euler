package nyc.angus.euler.p062;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests of {@link CubicPermutations}.
 */
public class CubicPermutationsTests {
	@Test
	public void eulerTest() throws IOException {
		final CubicPermutations cp = new CubicPermutations();

		assertEquals(new Long(127035954683L), cp.findCubesWithKPermutations(10000, 5).get(0));
	}

}
