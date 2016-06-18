package nyc.angus.euler.p002;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Tests of {@link EvenFibonacciNumbers}.
 */
public class EvenFibonacciNumbersTests {
	@Test
	public void eulerTest() throws IOException {
		final EvenFibonacciNumbers fib = new EvenFibonacciNumbers();

		assertEquals(4613732, fib.sumEvenValuedTermsBelowN(4000000));

	}
}
