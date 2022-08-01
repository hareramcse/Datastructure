package com.hs.leetcode.easy;

public class RemoveAllAdjacentDuplicate {

	public String removeDuplicates(String s) {
		char[] chars = new char[s.length()];
		
		// this is to point the result index
		int i = 0;

		for (int j = 0; j < s.length(); j++) {
			char curr = s.charAt(j);

			if (i > 0 && chars[i - 1] == curr) {
				i--;
			} else {
				chars[i] = curr;
				i++;
			}
		}

		return new String(chars, 0, i);
	}

	public static void main(String[] args) {
		RemoveAllAdjacentDuplicate obj = new RemoveAllAdjacentDuplicate();
		String s = "abbaca";
		String result = obj.removeDuplicates(s);
		System.out.println(result);
	}
}