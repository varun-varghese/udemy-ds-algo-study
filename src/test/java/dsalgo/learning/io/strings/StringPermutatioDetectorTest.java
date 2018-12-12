package dsalgo.learning.io.strings;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringPermutatioDetectorTest {
	
	private StringPermutationDetector stringPermutationDetector;

	@Before
	public void setUp() throws Exception {
		stringPermutationDetector = new StringPermutationDetector();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsPermutation() {
		assertTrue(stringPermutationDetector.isPermutation("abc", "bca"));
		assertFalse(stringPermutationDetector.isPermutation("abc", "bcd"));
		
		assertTrue(stringPermutationDetector.isPermutationClean("abc", "bca"));
		assertFalse(stringPermutationDetector.isPermutationClean("abc", "bcd"));
	}

}
