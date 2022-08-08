package com.hs.leetcode.medium;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		if (s.length() == 0 || s == null) {
			return s;
		}
		Stack<Integer> freStack = new Stack<>();
		Stack<StringBuilder> strStack = new Stack<>();
		int k = 0;

		StringBuilder res = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (Character.isLetter(ch)) {
				res.append(ch);
			} else if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {
				freStack.push(k);
				strStack.push(res);
				res = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder temp = res;
				res = strStack.pop();
				int fre = freStack.pop();
				while (fre > 0) {
					res.append(temp);
					fre--;
				}
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		DecodeString obj = new DecodeString();
		String s = "3[a]2[bc]";
		String result = obj.decodeString(s);
		System.out.println(result);
	}
}