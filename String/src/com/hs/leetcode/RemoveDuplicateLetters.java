package com.hs.leetcode;

import java.util.Stack;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		int[] count = new int[26];
		boolean[] exist = new boolean[26];

		for (char ch : s.toCharArray())
			count[ch - 'a']++;

		for (char ch : s.toCharArray()) {
			count[ch - 'a']--;
			if (exist[ch - 'a'])
				continue;
			while (stack.size() > 0 && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
				char rem = stack.pop();
				exist[rem - 'a'] = false;
			}
			stack.push(ch);
			exist[ch - 'a'] = true;
		}

		char[] result = new char[stack.size()];
		int i = stack.size() - 1;
		while (i >= 0) {
			result[i--] = stack.pop();
		}
		return new String(result);
	}

	public static void main(String[] args) {
		RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
		String s = "bcabc";
		String result = obj.removeDuplicateLetters(s);
		System.out.println(result);
	}
}