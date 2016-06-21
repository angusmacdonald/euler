package nyc.angus.euler.p082;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests of {@link ThreeWayPathSum}.
 */
public class ThreeWayPathSumTest {

	@Test
	public void hackerRankTest() {
		final long[] arr = { 131, 673, 234, 103, 18 };

		final long[] arr2 = { 201, 96, 342, 965, 150 };
		final long[] arr3 = { 630, 803, 746, 422, 111 };
		final long[] arr4 = { 537, 699, 497, 121, 956 };
		final long[] arr5 = { 805, 732, 524, 37, 331 };

		final long[][] input = { arr, arr2, arr3, arr4, arr5 };

		assertEquals(994, new ThreeWayPathSum().getMinimumPathSum(input));
	}
}
