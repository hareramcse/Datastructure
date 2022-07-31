package com.hs.leetcode.hard;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		int length = s.length();
		int sign = 1;
		int ans = 0;
		int currNo = 0;

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < length; i++) {
			if (Character.isDigit(s.charAt(i))) {
				currNo = s.charAt(i) - '0';
				while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
					currNo = currNo * 10 + s.charAt(i + 1) - 'a';
					i++;
				}
				currNo = currNo * sign;
				ans += currNo;
				currNo = 0;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(ans);
				stack.push(sign);
				ans = 0;
				sign = 1;
			} else if (s.charAt(i) == ')') {
				int prevSign = stack.pop();
				ans = prevSign * ans;
				int prevAns = stack.pop();
				ans = ans + prevAns;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		BasicCalculator obj = new BasicCalculator();
		String s = "(1+(4+5+2)-3)+(6+8)";
		int result = obj.calculate(s);
		System.out.println(result);
	}
}