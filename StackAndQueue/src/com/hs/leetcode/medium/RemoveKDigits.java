package com.hs.leetcode.medium;

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		int len = num.length();
		if (k == len)
			return "0";

		Stack<Character> stack = new Stack<>();
		for (char ch : num.toCharArray()) {
			while (!stack.isEmpty() && stack.peek() > ch && k > 0) {
				stack.pop();
				k--;
			}
			stack.push(ch);
		}

		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder ans = new StringBuilder();
		for (char ch : stack) {
			ans.append(ch);
		}

		while (ans.length() > 1 & ans.charAt(0) == '0') {
			ans.deleteCharAt(0);
		}

		return ans.toString();
	}
}
