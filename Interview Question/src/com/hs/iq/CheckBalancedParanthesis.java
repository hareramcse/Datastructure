package com.hs.iq;

import java.util.Stack;

public class CheckBalancedParanthesis {
	// checks if parentheses are balanced or not
	public boolean balancedparantheses(String exp) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < exp.length(); i++) {
			char charValue = exp.charAt(i);
			if (charValue == '[' || charValue == '(' || charValue == '{') {
				stack.push(charValue);
			} else if (charValue == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '[') {
					return false;
				}
			} else if (charValue == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '(') {
					return false;
				}
			} else if (charValue == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		CheckBalancedParanthesis ch = new CheckBalancedParanthesis();
		String exp = "[]";
		boolean b = ch.balancedparantheses(exp);
		System.out.println(b);
	}
}