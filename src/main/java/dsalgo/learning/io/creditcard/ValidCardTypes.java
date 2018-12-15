package dsalgo.learning.io.creditcard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class ValidCardTypes {
	
	private List<CreditCardType> validCardTypes;
	
	public ValidCardTypes() {
		this.validCardTypes = new ArrayList<CreditCardType>();
	}
	
	public ValidCardTypes(List<CreditCardType> validCardTypeMap) {
		this.validCardTypes = validCardTypeMap;
	}
	
	public void addValidType(String type, String prefix, int length) {
		CreditCardType existingType = validCardTypes.stream()
			.filter(cardType -> cardType.getCardType().equals(type))
			.findFirst()
			.orElse(null);
		if (null != existingType) {
			existingType.addValidCriteria(prefix, length);
		} else {
			CreditCardType newCardType = new CreditCardType(type, prefix, length);
			validCardTypes.add(newCardType);
		}
	}
	
	public String getCardType(String cardNumber) {
		int len = cardNumber.length();
		List<String> typesFound = prefixes(cardNumber).stream()
			.map(pfx -> 
				validCardTypes.stream()
					.filter(card -> card.isValid(pfx, len))
					.filter(Objects::nonNull)
					.map(CreditCardType::getCardType)
					.collect(Collectors.toList())
			)
			.flatMap(Collection::stream)
			.filter(Objects::nonNull)
			.distinct()
			.collect(Collectors.toList());
		log.info("| Types found: {}", typesFound);
		if (typesFound.size() > 0) {
			return typesFound.get(0);
		} else {
			return "Unknown";
		}
	}
	
	private List<String> prefixes(String cardNumber) {
		List<String> p = new ArrayList<String>();
		p.add(cardNumber.substring(0, 1));
		p.add(cardNumber.substring(0, 2));
		return p;
	}

}
