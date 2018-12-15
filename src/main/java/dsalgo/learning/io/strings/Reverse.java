package dsalgo.learning.io.strings;

import java.util.Stack;

public class Reverse {
	
	public String reverse(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : input.toCharArray()) {
			stack.push(c);
		}
		
		StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	public String reverse2(String input) {
		char[] arr = input.toCharArray();
		
		for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
		
		return String.valueOf(arr);
	}

}
