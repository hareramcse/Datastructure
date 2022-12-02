package com.hs.leetcode.medium;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		if (s.length() == 0 || s == null) {
			return s;
		}

		Stack<Integer> noStack = new Stack<>();
		Stack<StringBuilder> strStack = new Stack<>();

		StringBuilder res = new StringBuilder();
		int no = 0;
		
		for (char ch : s.toCharArray()) {
			if (Character.isLetter(ch)) {
				res.append(ch);
			} else if (Character.isDigit(ch)) {
				no = no * 10 + (ch - '0');
			} else if (ch == '[') {
				noStack.push(no);
				strStack.push(res);
				res = new StringBuilder();
				no = 0;
			} else if (ch == ']') {
				StringBuilder temp = res;
				res = strStack.pop();
				int fre = noStack.pop();
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