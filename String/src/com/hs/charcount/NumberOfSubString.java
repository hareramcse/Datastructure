package com.hs.charcount;

public class NumberOfSubString {

	static int countNonEmptySubstr(String str) {
		int n = str.length();
		return n * (n + 1) / 2;
	}

	// Driver code
	public static void main(String args[]) {
		String s = "abcde";
		System.out.println(countNonEmptySubstr(s));
	}

}