package com.hs.leetcode.medium;

public class MinRemoveToMakeValidParanthesis {
	public String minRemoveToMakeValid(String s) {
		int count = 0;
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '(') {
				count++;
			} else if (ch[i] == ')') {
				if (count > 0) {
					count--;
				} else {
					ch[i] = 0;
				}
			}
		}

		count = 0;
		for (int i = ch.length - 1; i > 0; i--) {
			if (ch[i] == ')') {
				count++;
			} else if (ch[i] == '(') {
				if (count > 0) {
					count--;
				} else {
					ch[i] = 0;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : ch) {
			if (c != 0) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		MinRemoveToMakeValidParanthesis obj = new MinRemoveToMakeValidParanthesis();
		String s = "a)b(c)d";
		String result = obj.minRemoveToMakeValid(s);
		System.out.println(result);
	}
}