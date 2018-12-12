package dsalgo.learning.io.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringPermutationDetector {
	
	public boolean isPermutation(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		} else {
			Map<Character, Integer> str1CountMap = new HashMap<Character, Integer>();
			Map<Character, Integer> str2CountMap = new HashMap<Character, Integer>();
			
			char[] arr1 = str1.toLowerCase().toCharArray();
			char[] arr2 = str2.toLowerCase().toCharArray();
			
			for (int i = 0; i < arr1.length; i++) {
				Character c1 = Character.valueOf(arr1[i]);
				Character c2 = Character.valueOf(arr2[i]);
				
				if (str1CountMap.containsKey(c1)) {
					str1CountMap.put(c1, 1 + str1CountMap.get(c1));
				} else {
					str1CountMap.put(c1, 1);
				}
				
				if (str2CountMap.containsKey(c2)) {
					str2CountMap.put(c2, 1 + str1CountMap.get(c2));
				} else {
					str2CountMap.put(c2, 1);
				}
			}
			return str1CountMap.equals(str2CountMap);
		}
	}
	
	public boolean isPermutationClean(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		} else {
			
			return sorted(str1).equals(sorted(str2));
		}
	}
	
	private String sorted(String s) {
		char[] arr = s.toLowerCase().toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

}
