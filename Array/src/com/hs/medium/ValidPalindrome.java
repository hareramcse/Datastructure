package com.hs.medium;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			Character leftChar = s.charAt(i);
			Character rightChar = s.charAt(j);
			if (!Character.isLetterOrDigit(leftChar)) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(rightChar)) {
				j--;
				continue;
			}
			if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}