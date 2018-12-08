package dsalgo.learning.io.strings;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
	
	public boolean isAnagram(String text1, String text2) {
		return charCountMap(text1).equals(charCountMap(text2));
	}
	
	private Map<Character, Integer> charCountMap(String in) {
		Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		char[] arr = in.replaceAll(" ", "")
				.toLowerCase()
				.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			Character c = Character.valueOf(arr[i]);
			
			if (charCountMap.containsKey(c)) {
				charCountMap.put(c, 1 + charCountMap.get(c));
			} else {
				charCountMap.put(c, 1);
			}
		}
		
		return charCountMap;
	}

}
