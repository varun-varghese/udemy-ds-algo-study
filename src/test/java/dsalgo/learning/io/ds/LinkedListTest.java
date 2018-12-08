package dsalgo.learning.io.ds;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	
	private LinkedList<String> linkedList;

	@Before
	public void setUp() throws Exception {
		linkedList = new LinkedList<String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		linkedList.addFirst("one");
		linkedList.addFirst("two");
		linkedList.addFirst("three");
		
		assertThat(linkedList.getFirst(), equalTo("three"));
		assertThat(linkedList.getLast(), equalTo("one"));
		
		linkedList.addLast("zero");
		assertThat(linkedList.getLast(), equalTo("zero"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetFirstNull() throws Exception {
		linkedList.getFirst();
	}
	
	@Test
	public void testSize() {
		assertThat(0, equalTo(linkedList.size()));
		
		linkedList.addFirst("one");
		linkedList.addFirst("two");
		linkedList.addFirst("three");
		
		assertThat(linkedList.size(), equalTo(3));
	}
	
	@Test
	public void testDeleteFirst() {
		linkedList.addFirst("one");
		linkedList.addFirst("two");
		linkedList.addFirst("three");
		
		linkedList.deleteFirst();
		assertThat(linkedList.size(), equalTo(2));
		linkedList.deleteFirst();
		assertThat(linkedList.size(), equalTo(1));
		linkedList.deleteFirst();
		assertThat(linkedList.size(), equalTo(0));
	}
	
	@Test
	public void testDeleteLast() {
		linkedList.deleteLast();
		assertThat(linkedList.size(), equalTo(0));
		
		linkedList.addFirst("one");
		linkedList.addFirst("two");
		linkedList.addFirst("three");
		
		linkedList.deleteLast();
		assertThat(linkedList.size(), equalTo(2));
		linkedList.deleteLast();
		assertThat(linkedList.size(), equalTo(1));
		linkedList.deleteLast();
		assertThat(linkedList.size(), equalTo(0));
	}
	
	@Test
	public void testPrint() {
		linkedList.addFirst("one");
		linkedList.addFirst("two");
		linkedList.addFirst("three");
		
		linkedList.print();
	}

}
