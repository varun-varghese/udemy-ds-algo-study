package dsalgo.learning.io.strings;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnagramTest {
	
	private Anagram anagramChecker;

	@Before
	public void setUp() throws Exception {
		anagramChecker = new Anagram();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsAnagram() {
		assertTrue(anagramChecker.isAnagram("rail safety", "fairy tales"));
		assertTrue(anagramChecker.isAnagram("Elvis", "lives"));
		assertTrue(anagramChecker.isAnagram("William Shakespeare", "I am a weakish speller"));
		assertTrue(anagramChecker.isAnagram("Schoolmaster", "The classroom"));

		assertFalse(anagramChecker.isAnagram("Anagrams", "the great art"));
	}

}
