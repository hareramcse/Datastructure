package com.hs.imp;

import java.util.Stack;

public class CheckPalindromeWithStack {
	private boolean isPalindrom(String input) {
		int i = 0;
		char[] ch = input.toCharArray();
		Stack<Character> stack = new Stack<Character>();

		while (ch[i] != 'X') {
			stack.push(ch[i]);
			i++;
		}
		i++;
		while (i < ch.length) {
			if (stack.isEmpty()) {
				return false;
			}
			if (ch[i] != stack.pop().charValue()) {
				return false;
			}
			i++;
		}

		return true;
	}

	public static void main(String[] args) {
		CheckPalindromeWithStack check = new CheckPalindromeWithStack();
		boolean b = check.isPalindrom("abcXcba");
		System.out.println("is palindrome " + b);
	}
}
