package dsalgo.learning.io.strings;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UniqueCharDetectTest {
	
	@Autowired
	private UniqueCharDetect uniqueCharDetect;

	@Test
	public void testIsUnique() {
		assertTrue(uniqueCharDetect.isUnique("ab"));
		assertFalse(uniqueCharDetect.isUnique("aa"));
		assertFalse(uniqueCharDetect.isUnique("aabacda"));
		assertFalse(uniqueCharDetect.isUnique("aabacda!!"));
	}

}
