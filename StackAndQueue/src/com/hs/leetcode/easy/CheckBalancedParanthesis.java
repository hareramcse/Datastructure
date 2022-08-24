package com.hs.leetcode.easy;

import java.util.Stack;

// 20. Valid Parentheses Leetcode
public class CheckBalancedParanthesis {
	// checks if parentheses are balanced or not
	public boolean balancedparantheses(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char charValue : s.toCharArray()) {
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