package dsalgo.learning.io.creditcard;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CreditCardType {
	
	private String cardType;
	
	private List<ValidCriteria> validCriterias;
	
	public CreditCardType(String type, String prefix, int length) {
		cardType = type;
		validCriterias = new ArrayList<ValidCriteria>();
		validCriterias.add(new ValidCriteria(prefix, length));
	}
	
	public boolean isValid(String prefix, int length) {
		long validCount = validCriterias.stream()
			.filter(criteria -> criteria.getValidLength() == length && criteria.getValidPrefix().equals(prefix))
			.count();
		
		if (validCount > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isExistingCriteria(String prefix, int length) {
		return isValid(prefix, length);
	}
	
	public void addValidCriteria(String prefix, int length) {
		if (!isExistingCriteria(prefix, length)) {
			ValidCriteria criteria = new ValidCriteria(prefix, length);
			validCriterias.add(criteria);
		}
	}

}
