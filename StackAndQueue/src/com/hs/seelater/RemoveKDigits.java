package com.hs.seelater;

import java.util.Stack;

public class RemoveKDigits {
	// it finds smallest possible integer after removing k digits from num
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

		// if input is having same repeating number
		while (k > 0) {
			stack.pop();
			k--;
		}

		StringBuilder ans = new StringBuilder();
		for (char ch : stack) {
			ans.append(ch);
		}

		// to handle the leading 0 at starting of the input
		while (ans.length() > 1 & ans.charAt(0) == '0') {
			ans.deleteCharAt(0);
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		RemoveKDigits obj = new RemoveKDigits();
		String num = "1432219";
		int k = 3;
		String result = obj.removeKdigits(num, k);
		System.out.println(result);
	}
}