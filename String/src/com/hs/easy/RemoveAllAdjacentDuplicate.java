package com.hs.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicate {
	public String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (stack.size() > 0 && stack.peek() == curr) {
				stack.pop();
			} else {
				stack.push(curr);
			}
		}

		StringBuilder res = new StringBuilder();		
		for(char ch : stack) {
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