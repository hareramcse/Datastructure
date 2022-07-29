package com.hs.leetcode.easy;

import java.util.Stack;

public class BackspaceStringCompare {
	public boolean backspaceCompare(String s, String t) {
		Stack<Character> sStack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch != '#') {
				sStack.push(ch);
			} else if (!sStack.isEmpty()) {
				sStack.pop();
			}
		}

		Stack<Character> tStack = new Stack<>();
		for (char ch : t.toCharArray()) {
			if (ch != '#') {
				tStack.push(ch);
			} else if (!tStack.isEmpty()) {
				tStack.pop();
			}
		}

		while (!sStack.isEmpty()) {
			char current = sStack.pop();
			if (tStack.isEmpty() || tStack.pop() != current) {
				return false;
			}
		}

		return sStack.isEmpty() && tStack.isEmpty();
	}

	public static void main(String[] args) {
		BackspaceStringCompare obj = new BackspaceStringCompare();
		String s = "ab##";
		String t = "c#d#";
		boolean backspaceCompare = obj.backspaceCompare(s, t);
		System.out.println(backspaceCompare);
	}
}