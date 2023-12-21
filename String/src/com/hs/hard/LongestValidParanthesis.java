package com.hs.hard;

//32
public class LongestValidParanthesis {
	public int longestValidParentheses(String s) {
		int open = 0;
		int close = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				open++;
			} else {
				close++;
			}

			if (open == close) {
				int length = open + close;
				max = Math.max(max, length);
			} else if (close > open) {
				open = close = 0;
			}
		}

		open = close = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch == '(') {
				open++;
			} else {
				close++;
			}

			if (open == close) {
				int length = open + close;
				max = Math.max(max, length);
			} else if (open > close) {
				open = close = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestValidParanthesis obj = new LongestValidParanthesis();
		String input = ")()())";
		int count = obj.longestValidParentheses(input);
		System.out.println(count);
	}
}