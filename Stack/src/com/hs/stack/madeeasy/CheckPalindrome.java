package com.hs.stack.madeeasy;

public class CheckPalindrome {
	private boolean isPalindrom(String input) {
		int i = 0, j = input.length()-1;
		char[] ch = input.toCharArray();

		while (i < j && ch[i] == ch[j]) {
			i++;
			j--;
		}

		if (i < j) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		CheckPalindrome check = new CheckPalindrome();
		boolean b = check.isPalindrom("abcdcba");
		System.out.println("is palindrome " + b);
	}
}
