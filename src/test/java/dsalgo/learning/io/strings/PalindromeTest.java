package dsalgo.learning.io.strings;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {
	
	Palindrome palindrome;

	@Before
	public void setUp() throws Exception {
		palindrome = new Palindrome();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsPalindrome() {
		assertTrue(palindrome.isPalindrome("abba"));
		assertTrue(palindrome.isPalindrome("aba"));
		assertTrue(palindrome.isPalindrome("abcba"));
		assertFalse(palindrome.isPalindrome("abc"));
		assertFalse(palindrome.isPalindrome("abcd"));
	}

}
