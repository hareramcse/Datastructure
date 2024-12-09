package com.hs.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicate {
	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();

		for (Character ch : s.toCharArray()) {
			if (stack.size() > 0 && stack.peek() == ch) {
				stack.pop();
			} else {
				stack.push(ch);
			}
		}

		StringBuilder res = new StringBuilder();
		for (char ch : stack) {
			res.append(ch);
		}

		return res.toString();
	}

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicate obj = new RemoveAllAdjacentDuplicate();
		String s = "abbaca";
		String result = obj.removeDuplicates(s);
		System.out.println(result);
	}
}