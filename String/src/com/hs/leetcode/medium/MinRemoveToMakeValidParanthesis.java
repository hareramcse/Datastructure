package com.hs.leetcode.medium;

import java.util.Stack;

public class MinRemoveToMakeValidParanthesis {
	public String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder(s);
		Stack<Pair> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(new Pair(ch, i));
			} else if (ch == ')') {
				if (!stack.isEmpty() && stack.peek().key == '(') {
					stack.pop();
				} else {
					stack.push(new Pair(ch, i));
				}
			}
		}

		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			sb.deleteCharAt(pair.value);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MinRemoveToMakeValidParanthesis obj = new MinRemoveToMakeValidParanthesis();
		String s = "))((";
		String result = obj.minRemoveToMakeValid(s);
		System.out.println(result);
	}
}