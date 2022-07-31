package com.hs.leetcode.medium;

import java.util.Stack;

public class SmallestSubsequenceDistinctCharacters {
	public String smallestSubsequence(String s) {
		int[] maxIndexes = new int[26];
		boolean[] used = new boolean[26];
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			maxIndexes[ch - 'a'] = i;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (used[ch - 'a'] == false) {
				while (!stack.empty()) {
					char tmpCh = stack.peek(); // remove the last character, not stack
					if (maxIndexes[tmpCh - 'a'] > i && ch < tmpCh) {
						stack.pop(); // The last character is popped from the stack
						used[tmpCh - 'a'] = false;
					} else {
						break;
					}
				}
				stack.push(ch);
				used[ch - 'a'] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Character character : stack) {
			sb.append(character);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		SmallestSubsequenceDistinctCharacters obj = new SmallestSubsequenceDistinctCharacters();
		String s = "cbacdcbc";
		String result = obj.smallestSubsequence(s);
		System.out.println(result);
	}
}