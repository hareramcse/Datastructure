package com.hs.leetcode.easy;

import java.util.Stack;

public class CheckBalancedParanthesis {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{')
				stack.push(ch);
			else {
				if (stack.isEmpty()) {
					return false;
				}
				char c = stack.pop();
				if ((ch == ')' && c == '(') || (ch == ']' && c == '[') || (ch == '}' && c == '{'))
					continue;
				else
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		CheckBalancedParanthesis ch = new CheckBalancedParanthesis();
		String exp = "[]";
		boolean b = ch.isValid(exp);
		System.out.println(b);
	}
}