package dsalgo.learning.io.strings;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseTest {
	
	private Reverse reverse;

	@Before
	public void setUp() throws Exception {
		reverse = new Reverse();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReverse() {
		assertThat(reverse.reverse("Hello"), equalTo("olleH"));
		assertThat(reverse.reverse("I am Sam"), equalTo("maS ma I"));
		assertThat(reverse.reverse("Magic!"), equalTo("!cigaM"));
	}

}
