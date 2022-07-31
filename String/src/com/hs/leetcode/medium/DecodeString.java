package com.hs.leetcode.medium;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		if (s.length() == 0 || s == null) {
			return s;
		}
		Stack<Integer> numStack = new Stack<Integer>();
		Stack<StringBuilder> strStack = new Stack<>();

		StringBuilder res = new StringBuilder();
		int num = 0;

		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				num = num * 10 + ch - '0';
			} else if (ch == '[') {
				strStack.push(res);
				res = new StringBuilder();
				numStack.push(num);
				num = 0;
			} else if (ch == ']') {
				StringBuilder temp = res;
				res = strStack.pop();
				int count = numStack.pop();
				while (count-- > 0) {
					res.append(temp);
				}
			} else {
				res.append(ch);
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