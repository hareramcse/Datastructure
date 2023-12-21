package com.hs.medium;

import java.util.Stack;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		Stack<Integer> stack = new Stack<>();
		int[] lastIndex = new int[26];
		boolean[] visited = new boolean[26];

		// find the last occurance index of each char
		for (int i = 0; i < s.length(); i++) {
			lastIndex[s.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';

			// we dont have to add duplicate char
			if (visited[index])
				continue;

			visited[index] = true;
			
			//
			while (!stack.isEmpty() && stack.peek() > index && lastIndex[stack.peek()] > i) {
				visited[stack.pop()] = false;
			}
			stack.push(index);
		}

		// once we get the result in stack, iterate it and return the result
		StringBuilder ans = new StringBuilder();
		for (int i : stack) {
			ans.append((char) (i + 'a'));
		}
		return ans.toString();
	}

	public static void main(String[] args) {
		RemoveDuplicateLetters obj = new RemoveDuplicateLetters();
		String s = "cbacdcbc";
		String result = obj.removeDuplicateLetters(s);
		System.out.println(result);
	}
}