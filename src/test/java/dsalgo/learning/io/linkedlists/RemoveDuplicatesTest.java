package dsalgo.learning.io.linkedlists;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dsalgo.learning.io.ds.LinkedList;

public class RemoveDuplicatesTest {
	
	private LinkedList<Integer> ll;
	
	private RemoveDuplicates<Integer> removeDuplicates;

	@Before
	public void setUp() throws Exception {
		ll = new LinkedList<Integer>();
		ll.addFirst(1);
		ll.addLast(1);
		ll.addLast(2);
		ll.addLast(1);
				
		removeDuplicates = new RemoveDuplicates<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertThat(ll.size(), equalTo(4));
		
		removeDuplicates.removeDuplicate(ll);
		
		assertThat(ll.size(), equalTo(2));
	}

}
