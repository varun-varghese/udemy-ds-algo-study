package dsalgo.learning.io.other;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntReverseTest {
	
	private IntReverse intReverse;

	@Before
	public void setUp() throws Exception {
		intReverse = new IntReverse();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntReverse() {
		assertThat(intReverse.reverse(121), equalTo(121));
		assertThat(intReverse.reverse(-121), equalTo(-121));
		assertThat(intReverse.reverse(-321), equalTo(-123));
		assertThat(intReverse.reverse(321), equalTo(123));
		assertThat(intReverse.reverse(0), equalTo(0));
	}
	
	@Test
	public void testIntReverse2() {
		assertThat(intReverse.reverse2(121), equalTo(121));
		assertThat(intReverse.reverse2(-121), equalTo(-121));
		assertThat(intReverse.reverse2(-321), equalTo(-123));
		assertThat(intReverse.reverse2(321), equalTo(123));
		assertThat(intReverse.reverse2(0), equalTo(0));
	}


}
