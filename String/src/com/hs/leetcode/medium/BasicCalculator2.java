package com.hs.leetcode.medium;

import java.util.Stack;

public class BasicCalculator2 {
	public int calculate(String s) {
		Stack<Integer> st = new Stack<>();

		char operator = '+';
		int no = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				no = no * 10 + (ch - '0');
			}

			if (isOperator(ch) || i == s.length() - 1) {
				if (operator == '+') {
					st.push(no);
				} else if (operator == '-') {
					st.push(-no);
				} else if (operator == '*') {
					int top = st.pop();
					st.push(top * no);
				} else if (operator == '/') {
					int top = st.pop();
					st.push(top / no);
				}
				no = 0;
				operator = ch;
			}
		}

		int res = 0;
		while (!st.empty()) {
			res += st.pop();
		}
		return res;
	}

	private boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '/' || c == '*';
	}

	public static void main(String[] args) {
		BasicCalculator2 obj = new BasicCalculator2();
		String s = "3*2+5/2-10";
		int result = obj.calculate(s);
		System.out.println(result);
	}
}