package dsalgo.learning.io.strings;

import java.util.LinkedList;
import java.util.Queue;

public class Compressor {
	
	class CharCount {
		char c;
		int count;
		
		CharCount() {
			count = 0;
		}
		
		CharCount(char ch) {
			c = ch;
			count = 1;
		}
		
		public void increment() {
			count += 1;
		}
		
		@Override
		public String toString() {
			if (count > 1) {
				return Character.toString(c) + count;
			} else {
				return Character.toString(c);
			}
		}
	}
	
	public String compress(String input) {
		char[] inArray = input.toCharArray();
		Queue<CharCount> charCountQueue = new LinkedList<CharCount>();
		StringBuilder sb = new StringBuilder();
		
		char lastChar = 0;
		for (int i = 0; i < inArray.length; i++) {
			char currentChar = inArray[i];
			
			if (currentChar == lastChar) {
				charCountQueue.peek().increment();
			} else {
				if (!charCountQueue.isEmpty()) {
					sb.append(charCountQueue.poll().toString());
				}
				CharCount charCount = new CharCount(currentChar);
				charCountQueue.add(charCount);
			}
			lastChar = currentChar;
		}
		
		if (!charCountQueue.isEmpty()) {
			sb.append(charCountQueue.poll().toString());
		}
		
		return sb.toString();
	}

}
