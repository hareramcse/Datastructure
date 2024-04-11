package com.hs.basic;

public class Palindrome {
	public boolean palindrome(String str, int i, int n) {
		if (i >= n / 2)
			return true;
		if (str.charAt(i) != str.charAt(n - i - 1))
			return false;
		return palindrome(str, i + 1, n);
	}

	public static void main(String[] args) {
		Palindrome obj = new Palindrome();
		String str = "MADAM";
		boolean result = obj.palindrome(str, 0, str.length());
		System.out.println(result);
	}
}
