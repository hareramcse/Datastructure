package com.hs.basic;

public class StringReverseByRecursion {

	private String reverseString(String str) {
		if (str == null) {
			return null;
		}
		if (str.length() <= 1) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);
	}

	public static void main(String a[]) {
		StringReverseByRecursion srr = new StringReverseByRecursion();
		System.out.println("Result: " + srr.reverseString("abcde"));
	}
}