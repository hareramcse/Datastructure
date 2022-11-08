package com.hs.leetcode.medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParanthesis {
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
					stack.pop();
				} else {
					stack.push(i);
				}
			}
		}

		StringBuilder sb = new StringBuilder(s);
		while (!stack.isEmpty()) {
			int index = stack.pop();
			sb.deleteCharAt(index);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MinimumRemoveToMakeValidParanthesis obj = new MinimumRemoveToMakeValidParanthesis();
		String s = "))(()";
		String result = obj.minRemoveToMakeValid(s);
		System.out.println(result);
	}
}