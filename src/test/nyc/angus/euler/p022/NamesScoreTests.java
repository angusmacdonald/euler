package nyc.angus.euler.p022;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import nyc.angus.euler.p022.NamesScores;

import org.junit.Test;

/**
 * Tests of {@link NamesScores}.
 */
public class NamesScoreTests {

	@Test
	public void eulerTest() throws IOException {
		final String[] namesArray = loadNamesToArray();

		final NamesScores test = new NamesScores();

		assertEquals(871198282, test.getScoreSum(namesArray));

	}

	private String[] loadNamesToArray() throws IOException {
		final List<String> names = new LinkedList<>();

		try (final Stream<String> lines = Files.lines(new File("resources" + File.separator + "p022_names.txt").toPath())) {
			lines.map(s -> s.split(",")).map(getListFromLine()).forEach(list -> names.addAll(list));
		}

		final String[] namesArray = names.toArray(new String[0]);
		return namesArray;
	}

	private Function<? super String[], ? extends List<String>> getListFromLine() {
		return s -> Arrays.stream(s).map(el -> el.substring(1, el.length() - 1)).collect(Collectors.toList());
	}
}
