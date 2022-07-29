package com.hs.leetcode.medium;

import java.util.Stack;

// 316. Remove Duplicate Letters Leetcode
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		int[] count = new int[26];
		boolean[] isAdded = new boolean[26];

		// count of each char
		for (char ch : s.toCharArray())
			count[ch - 'a']++;

		for (char ch : s.toCharArray()) {
			count[ch - 'a']--;
			
			// if char is already present then skip that char
			if (isAdded[ch - 'a'])
				continue;

			// if last char of res string > current char and count of last char count > 0
			// then remove the char from the result and mark that element presence to false
			while (stack.size() > 0 && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
				char rem = stack.pop();
				isAdded[rem - 'a'] = false;
			}

			// add the char to result and mark that char present in result
			stack.push(ch);
			isAdded[ch - 'a'] = true;
		}

		// once we get the result in stack, iterate it and return the result
		char[] result = new char[stack.size()];
		int i = stack.size() - 1;
		while (i >= 0) {
			result[i--] = stack.pop();
		}
		return new String(result);
	}

	public static void main(String[] args) {
		RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
		String s = "cbacdcbc";
		String result = obj.removeDuplicateLetters(s);
		System.out.println(result);
	}
}