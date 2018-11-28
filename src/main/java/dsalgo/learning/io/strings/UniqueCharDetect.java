package dsalgo.learning.io.strings;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UniqueCharDetect {
	
	public boolean isUnique(String text) {
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (char c : text.toCharArray()) {
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, 1 + charCountMap.get(c));
			} else {
				charCountMap.put(c, 1);
			}
		}
		
		long duplicates = charCountMap.values().stream()
			.filter(i -> i > 1)
			.count();
		if (duplicates > 0) {
			return false;
		} else {
			return true;
		}
	}

}
