package dsalgo.learning.io.creditcard;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidCardTypesTest {
	
	private ValidCardTypes validCardTypes;

	@Before
	public void setUp() throws Exception {
		validCardTypes = new ValidCardTypes();

		validCardTypes.addValidType("VISA", "4", 16);
		validCardTypes.addValidType("AMEX", "34", 15);
		validCardTypes.addValidType("AMEX", "37", 15);
		validCardTypes.addValidType("Discovery", "60", 16);
		validCardTypes.addValidType("Discovery", "65", 16);
		validCardTypes.addValidType("JCB", "35", 16);
		validCardTypes.addValidType("JCB", "35", 17);
		validCardTypes.addValidType("JCB", "35", 18);
		validCardTypes.addValidType("JCB", "35", 19);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertThat(validCardTypes.getCardType("4111111111111111"), equalTo("VISA"));
		
		assertThat(validCardTypes.getCardType("341111111111111"), equalTo("AMEX"));
		assertThat(validCardTypes.getCardType("371111111111111"), equalTo("AMEX"));
		
		assertThat(validCardTypes.getCardType("371111"), equalTo("Unknown"));
		
		assertThat(validCardTypes.getCardType("6011111111111111"), equalTo("Discovery"));
		assertThat(validCardTypes.getCardType("6511111111111111"), equalTo("Discovery"));
		
		assertThat(validCardTypes.getCardType("3511111111111111"), equalTo("JCB"));
		assertThat(validCardTypes.getCardType("35111111111111111"), equalTo("JCB"));
		assertThat(validCardTypes.getCardType("351111111111111111"), equalTo("JCB"));
		assertThat(validCardTypes.getCardType("3511111111111111111"), equalTo("JCB"));
	}

}
