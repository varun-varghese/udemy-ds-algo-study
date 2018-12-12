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
	public void testCompress() {
		assertThat(compressor.compress("aaabbac"), equalTo("a3b2ac"));
		assertThat(compressor.compress("aaabbaaacc"), equalTo("a3b2a3c2"));
		assertThat(compressor.compress("aabb"), equalTo("aabb"));
		assertThat(compressor.compress("abc"), equalTo("abc"));
		assertThat(compressor.compress("ab"), equalTo("ab"));
		assertThat(compressor.compress("a"), equalTo("a"));
		assertThat(compressor.compress("zzz"), equalTo("z3"));
		assertThat(compressor.compress("aabbaabb"), equalTo("aabbaabb"));
	}
	
	@Test
	public void testCompressAlt() {
		assertThat(compressor.compressAlt("aaabbac"), equalTo("a3b2ac"));
		assertThat(compressor.compressAlt("aaabbaaacc"), equalTo("a3b2a3c2"));
		assertThat(compressor.compressAlt("aabb"), equalTo("aabb"));
		assertThat(compressor.compressAlt("abc"), equalTo("abc"));
		assertThat(compressor.compressAlt("ab"), equalTo("ab"));
		assertThat(compressor.compressAlt("a"), equalTo("a"));
		assertThat(compressor.compressAlt("zzz"), equalTo("z3"));
		assertThat(compressor.compressAlt("aabbaabb"), equalTo("aabbaabb"));
	}

}
