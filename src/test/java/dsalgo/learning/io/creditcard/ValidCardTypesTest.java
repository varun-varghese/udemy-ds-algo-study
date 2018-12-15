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
		
		validCardTypes.addValidType("MasterCard", "5", 16);
		validCardTypes.addValidType("MasterCard", "2", 16);
		validCardTypes.addValidType("VISA", "4", 16);
		validCardTypes.addValidType("AMEX", "34", 15);
		validCardTypes.addValidType("AMEX", "37", 15);
		validCardTypes.addValidType("Discover", "60", 16);
		validCardTypes.addValidType("Discover", "65", 16);
		validCardTypes.addValidType("JCB", "35", 16);
		validCardTypes.addValidType("JCB", "35", 17);
		validCardTypes.addValidType("JCB", "35", 18);
		validCardTypes.addValidType("JCB", "35", 19);
		validCardTypes.addValidType("Diners Club", "30", 14);
		validCardTypes.addValidType("Diners Club", "36", 14);
		validCardTypes.addValidType("Diners Club", "38", 14);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertThat(validCardTypes.getCardType("5111111111111111"), equalTo("MasterCard"));
		assertThat(validCardTypes.getCardType("2111111111111111"), equalTo("MasterCard"));
		
		assertThat(validCardTypes.getCardType("4111111111111111"), equalTo("VISA"));
		
		assertThat(validCardTypes.getCardType("341111111111111"), equalTo("AMEX"));
		assertThat(validCardTypes.getCardType("371111111111111"), equalTo("AMEX"));
		
		assertThat(validCardTypes.getCardType("371111"), equalTo("Unknown"));
		
		assertThat(validCardTypes.getCardType("6011111111111111"), equalTo("Discover"));
		assertThat(validCardTypes.getCardType("6511111111111111"), equalTo("Discover"));
		
		assertThat(validCardTypes.getCardType("3511111111111111"), equalTo("JCB"));
		assertThat(validCardTypes.getCardType("35111111111111111"), equalTo("JCB"));
		assertThat(validCardTypes.getCardType("351111111111111111"), equalTo("JCB"));
		assertThat(validCardTypes.getCardType("3511111111111111111"), equalTo("JCB"));
		
		assertThat(validCardTypes.getCardType("30111111111111"), equalTo("Diners Club"));
		assertThat(validCardTypes.getCardType("36111111111111"), equalTo("Diners Club"));
		assertThat(validCardTypes.getCardType("38111111111111"), equalTo("Diners Club"));
	}

}
