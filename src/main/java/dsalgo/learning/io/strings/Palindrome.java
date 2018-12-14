package dsalgo.learning.io.strings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Palindrome {
	
	public boolean isPalindrome(String text) {
		char[] arr = text.toLowerCase().toCharArray();
		int mid = arr.length / 2;
		log.debug("| len = {}, mid = {}", arr.length, mid);
		int matchCount = 0;
		for (int i = 0, j = arr.length - 1; i < mid ; i++, j--) {
			
			if (arr[i] == arr[j]) {
				matchCount ++;
			}
			log.debug("| i = {}, j = {}, left = {}, right = {}, matchCount = {}", i, j, arr[i], arr[j], matchCount);
		}
		if (matchCount == mid) {
			return true;
		} else {
			return false;
		}
	}

}
