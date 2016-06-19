package nyc.angus.euler.p079;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

/**
 * Tests of {@link PasscodeDerivation}.
 */
public class PasscodeDerivationTests {

	@Test
	public void eulerTest() throws IOException {
		final PasscodeDerivation pass = new PasscodeDerivation();

		assertEquals("73162890", pass.obtainPassword(loadInput()));
	}

	private String[] loadInput() throws IOException {
		Path path = new File("resources" + File.separator + "p079_keylog.txt").toPath();
		return Files.readAllLines(path).toArray(new String[0]);
	}

}
