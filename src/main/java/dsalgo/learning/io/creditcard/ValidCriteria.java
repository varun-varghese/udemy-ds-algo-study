package dsalgo.learning.io.creditcard;

import lombok.Data;

@Data
public class ValidCriteria {
	
	private String validPrefix;
	
	private int validLength;
	
	@SuppressWarnings("unused")
	private ValidCriteria() {
		//
	}
	
	public ValidCriteria(String prefix, int length) {
		validPrefix = prefix;
		validLength = length;
	}

}
