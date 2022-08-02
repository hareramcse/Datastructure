package com.hs.leetcode.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicate {

	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();

		for (int j = 0; j < s.length(); j++) {
			char curr = s.charAt(j);

			if (stack.size() > 0 && stack.peek() == curr) {
				stack.pop();
			} else {
				stack.push(curr);
			}
		}

		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.append(stack.pop());
		}
		return res.reverse().toString();
	}

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicate obj = new RemoveAllAdjacentDuplicate();
		String s = "abbaca";
		String result = obj.removeDuplicates(s);
		System.out.println(result);
	}
}