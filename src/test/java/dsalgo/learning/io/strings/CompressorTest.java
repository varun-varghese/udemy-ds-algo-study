package dsalgo.learning.io.strings;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompressorTest {
	
	private Compressor compressor;

	@Before
	public void setUp() throws Exception {
		compressor = new Compressor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertThat(compressor.compress("aaabbac"), equalTo("a3b2ac"));
		assertThat(compressor.compress("aaabbaaacc"), equalTo("a3b2a3c2"));
		assertThat(compressor.compress("abc"), equalTo("abc"));
		assertThat(compressor.compress("ab"), equalTo("ab"));
		assertThat(compressor.compress("a"), equalTo("a"));
	}

}
