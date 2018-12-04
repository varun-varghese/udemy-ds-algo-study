package dsalgo.learning.io.ds;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DynamicArrayTest {
	
	private DynamicArray<String> array;

	@Before
	public void setUp() throws Exception {
		array = new DynamicArray<String>(3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddInsert() {
		assertThat(array.size(), equalTo(0));
		array.add("a");
		assertThat(array.get(0), equalTo("a"));
		assertThat(array.size(), equalTo(1));
		
		array.add("b");
		assertThat(array.get(1), equalTo("b"));
		assertThat(array.size(), equalTo(2));
		
		array.add("c");
		assertThat(array.get(2), equalTo("c"));
		assertThat(array.size(), equalTo(3));
		
		array.insert(0, "d");
		assertThat(array.get(0), equalTo("d"));
		assertThat(array.get(1), equalTo("a"));
		assertThat(array.get(2), equalTo("b"));
		assertThat(array.get(3), equalTo("c"));
		assertThat(array.size(), equalTo(4));
	}
	
	@Test
	public void testDelete() {
		array.add("a");
        array.add("b");
        array.add("c");

        array.delete(1);
        assertThat(array.size(), equalTo(2));
        assertThat(array.get(0), equalTo("a"));
		assertThat(array.get(1), equalTo("c"));
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(array.isEmpty());
		array.add("a");
		assertFalse(array.isEmpty());
	}

}
