package com.hs.medium;

import java.util.Stack;

public class ValidParenthesisString {
	public boolean checkValidString(String s) {
		char[] chars = s.toCharArray();

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = chars[i];
			if (ch == '(') {
				s1.push(i);
			} else if (ch == ')') {
				if (!s1.isEmpty()) {
					s1.pop();
				} else if (!s2.isEmpty()) {
					s2.pop();
				} else {
					return false;
				}
			} else if (ch == '*') {
				s2.push(i);
			}
		}

		while (!s1.isEmpty() && !s2.isEmpty()) {
			Integer value = s2.pop();
			if (s1.peek() < value)
				s1.pop();
		}
		return s1.isEmpty();
	}

	public static void main(String[] args) {
		ValidParenthesisString obj = new ValidParenthesisString();
		String s = "(*))";
		boolean result = obj.checkValidString(s);
		System.out.println(result);
	}
}