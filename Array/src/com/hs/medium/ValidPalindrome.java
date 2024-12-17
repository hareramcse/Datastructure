package com.hs.medium;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			Character leftChar = s.charAt(start);
			Character rightChar = s.charAt(end);
			if (!Character.isLetterOrDigit(leftChar)) {
				start++;
				continue;
			}
			if (!Character.isLetterOrDigit(rightChar)) {
				end--;
				continue;
			}
			if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome obj = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		boolean result = obj.isPalindrome(s);
		System.out.println(result);
	}
}