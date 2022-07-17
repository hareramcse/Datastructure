package com.hs.leetcode;

// 647. Palindromic Substrings Leetcode Medium
public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		if (s.isEmpty())
			return 0;
		int n = s.length();
		int count = 0;
		char[] ch = s.toCharArray();
		for (int i = 0; i < n; i++) {
			count += isPalindrome(ch, i, i);
			count += isPalindrome(ch, i, i + 1);
		}
		return count;
	}

	private int isPalindrome(char[] chars, int i, int j) {
		int count = 0;
		while (i >= 0 && j < chars.length && chars[i--] == chars[j++]) {
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		PalindromicSubstrings obj = new PalindromicSubstrings();
		String input = "aaa";
		int countSubstrings = obj.countSubstrings(input);
		System.out.println(countSubstrings);
	}
}