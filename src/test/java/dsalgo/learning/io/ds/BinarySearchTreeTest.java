package dsalgo.learning.io.ds;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class BinarySearchTreeTest {
	
	private BinarySearchTree bst;

	@Before
	public void setUp() throws Exception {
		bst = new BinarySearchTree();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        assertEquals("e", bst.find(5));
        assertEquals("c", bst.find(3));
        assertEquals("b", bst.find(2));
        assertEquals("d", bst.find(4));
        assertEquals("g", bst.find(7));
        assertEquals("f", bst.find(6));
        assertEquals("h", bst.find(8));
        assertEquals(null, bst.find(99));
	}
	
	@Test
    public void testMinKey() throws Exception {
        bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");

        assertEquals(2, bst.findMinKey());
    }
	
	@Test
	public void testDeleteNoChild() {
		bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        bst.delete(2);
        assertNull(bst.find(2));
	}
	
	@Test
	public void testDeleteOneChild() {
		bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        
        bst.delete(7);
        
        assertNull(bst.find(7));
	}
	
	@Test
	public void testDeleteTwoChild() {
		bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");

        bst.delete(7);
        
        assertNull(bst.find(7));
	}
	
	@Test
	public void testDepth() {
		bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");
        
        assertThat(bst.depth(), equalTo(3));
	}
	
	@Test
	public void testTraversal() {
		bst.insert(5, "e");
        bst.insert(3, "c");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(7, "g");
        bst.insert(6, "f");
        bst.insert(8, "h");
        
        System.out.println("* InOrder *");
        bst.printInOrder();
        System.out.println("* PostOrder *");
        bst.printPostOrder();
        System.out.println("* PreOrder *");
        bst.printPreOrder();
	}

}
