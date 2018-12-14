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

}
