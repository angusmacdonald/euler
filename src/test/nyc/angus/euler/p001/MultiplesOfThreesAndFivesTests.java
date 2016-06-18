package nyc.angus.euler.p001;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests of {@link Multiples3And5}.
 */
public class MultiplesOfThreesAndFivesTests {
	@Test
	public void eulerTest() throws IOException {
		final Multiples3And5 m = new Multiples3And5();

		assertEquals(233168, m.calculateSumBelowN(1000));

	}
}
