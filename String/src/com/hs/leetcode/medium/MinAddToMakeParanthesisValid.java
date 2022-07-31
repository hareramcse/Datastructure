package com.hs.leetcode.medium;

import java.util.Stack;

public class MinAddToMakeParanthesisValid {
	public int minAddToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			} else {
				if (stack.size() > 0 && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}
		}
		return stack.size();
	}

	public static void main(String[] args) {
		MinAddToMakeParanthesisValid obj = new MinAddToMakeParanthesisValid();
		String s = "(((";
		int result = obj.minAddToMakeValid(s);
		System.out.println(result);
	}
}