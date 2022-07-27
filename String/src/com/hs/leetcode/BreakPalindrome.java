package com.hs.leetcode;

// 1328. Break a Palindrome Leetcode Medium
public class BreakPalindrome {
	public String breakPalindrome(String palindrome) {
		if (palindrome.length() <= 1) {
			return "";
		}
		char[] chars = palindrome.toCharArray();
		for (int i = 0; i < palindrome.length() / 2; i++) {
			if (chars[i] != 'a') {
				chars[i] = 'a';
				return new String(chars);
			}
		}
		
		// for middle char if we change middle char, still it will be palindrome
		// so we need to change it last char of the string with b
		chars[palindrome.length() - 1] = 'b';
		return new String(chars);
	}

	public static void main(String[] args) {
		BreakPalindrome obj = new BreakPalindrome();
		String input = "abccba";
		String breakPalindrome = obj.breakPalindrome(input);
		System.out.println(breakPalindrome);
	}
}