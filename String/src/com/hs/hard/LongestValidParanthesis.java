package com.hs.hard;

import java.util.Stack;

public class LongestValidParanthesis {
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<>();
		stack.push(-1); // Base index if valid substring starts from 0th index
		int maxLength = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop(); // Match a previous '('
				if (stack.isEmpty()) {
					stack.push(i); // Update base index
				} else {
					maxLength = Math.max(maxLength, i - stack.peek());
				}
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		LongestValidParanthesis obj = new LongestValidParanthesis();
		String input = ")()())";
		int count = obj.longestValidParentheses(input);
		System.out.println(count);
	}
}