package com.hs.leetcode;

// 5. Longest Palindromic Substring Leetcode
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if (s != null && s.length() <= 1) {
			return s;
		}
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {
			String temp = expand(s, i, i);
			if (temp.length() > longest.length()) {
				longest = temp;
			}
			temp = expand(s, i, i + 1);
			if (temp.length() > longest.length()) {
				longest = temp;
			}
		}
		return longest;
	}

	private String expand(String s, int left, int right) {
		while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		String str = "abbac";
		String longestPalindrome = obj.longestPalindrome(str);
		System.out.println(longestPalindrome);
	}
}