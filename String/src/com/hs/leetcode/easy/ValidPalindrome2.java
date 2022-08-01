package com.hs.leetcode.easy;

public class ValidPalindrome2 {
	public boolean validPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
			}
			i++;
			j--;
		}
		return true;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome2 obj = new ValidPalindrome2();
		String s = "abca";
		boolean result = obj.validPalindrome(s);
		System.out.println(result);
	}
}