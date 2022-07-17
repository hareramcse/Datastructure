package com.hs.leetcode;

// 125. Valid Palindrome Leetcode
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
				i++;
			}
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
				j--;
			}

			if (i < j && Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome obj = new ValidPalindrome();
		String input = "A man, a plan, a canal: Panama";
		boolean isPalindrome = obj.isPalindrome(input);
		System.out.println(isPalindrome);
	}
}
