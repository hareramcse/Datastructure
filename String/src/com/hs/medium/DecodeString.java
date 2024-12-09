package com.hs.medium;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
		if (s.length() == 0 || s == null) {
			return s;
		}

		Stack<Integer> stack1 = new Stack<>();
		Stack<StringBuilder> stack2 = new Stack<>();

		StringBuilder res = new StringBuilder();
		int no = 0;
		
		for (char ch : s.toCharArray()) {
			if (Character.isLetter(ch)) {
				res.append(ch);
			} else if (Character.isDigit(ch)) {
				no = no * 10 + (ch - '0');
			} else if (ch == '[') {
				stack1.push(no);
				stack2.push(res);
				res = new StringBuilder();
				no = 0;
			} else if (ch == ']') {
				StringBuilder temp = res;
				res = stack2.pop();
				int fre = stack1.pop();
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