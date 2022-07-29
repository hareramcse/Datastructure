package com.hs.leetcode.easy;

public class RemoveAllAdjacentDuplicate {

	public String removeDuplicates(String s) {
		char[] stack = new char[s.length()];
		int i = 0;

		for (int j = 0; j < s.length(); j++) {
			char curr = s.charAt(j);

			if (i > 0 && stack[i - 1] == curr) {
				i--;
			} else {
				stack[i] = curr;
				i += 1;
			}
		}

		return new String(stack, 0, i);
	}

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicate obj = new RemoveAllAdjacentDuplicate();
		String s = "abbaca";
		String result = obj.removeDuplicates(s);
		System.out.println(result);
	}
}