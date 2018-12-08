package dsalgo.learning.io.ds;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
	
	private HashTable<String, String> hashTable;

	@Before
	public void setUp() throws Exception {
		hashTable = new HashTable<String, String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContainsFalse() {
		assertFalse(hashTable.contains("A"));
		assertFalse(hashTable.contains("B"));
		assertFalse(hashTable.contains("C"));
		assertFalse(hashTable.contains(""));
		assertFalse(hashTable.contains(" "));
	}
	
	@Test
	public void testContainsTrue() {
		hashTable.put("A", "a");
		hashTable.put("B", "b");
		hashTable.put("C", "c");
		
		assertTrue(hashTable.contains("A"));
		assertTrue(hashTable.contains("B"));
		assertTrue(hashTable.contains("C"));
	}
	
	@Test
	public void testGet() {
		hashTable.put("AA", "123-456-0");
		hashTable.put("BB", "123-456-1");
		hashTable.put("CC", "123-456-2");
		hashTable.put("AB", "123-456-3");
		hashTable.put("AC", "123-456-4");
		hashTable.put("BA", "123-456-5");
		hashTable.put("BC", "123-456-6");
		hashTable.put("CA", "123-456-7");
		hashTable.put("CB", "123-456-8");
		
		assertThat(hashTable.get("AA"), equalTo("123-456-0"));
		assertThat(hashTable.get("BB"), equalTo("123-456-1"));
		assertThat(hashTable.get("CC"), equalTo("123-456-2"));
		assertThat(hashTable.get("AB"), equalTo("123-456-3"));
		assertThat(hashTable.get("AC"), equalTo("123-456-4"));
		assertThat(hashTable.get("BA"), equalTo("123-456-5"));
		assertThat(hashTable.get("BC"), equalTo("123-456-6"));
		assertThat(hashTable.get("CA"), equalTo("123-456-7"));
		assertThat(hashTable.get("CB"), equalTo("123-456-8"));
	}
	
	@Test
	public void testCollision() {
		hashTable.put("CollideAA", "123-456-0");
		hashTable.put("CollideBB", "123-456-1");
		
		assertThat(hashTable.get("CollideAA"), equalTo("123-456-0"));
		assertThat(hashTable.get("CollideBB"), equalTo("123-456-1"));
	}

}
