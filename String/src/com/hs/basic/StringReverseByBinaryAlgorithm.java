package com.hs.basic;

public class StringReverseByBinaryAlgorithm {

	public static String reverse(String str) {
		char[] s = str.toCharArray();
		int start = 0;
		int end = s.length-1;
		while(start<end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
		return new String(s);
	}

	public static void main(String[] args) {
		String str = "abcde";
		String reversedString = StringReverseByBinaryAlgorithm.reverse(str);
		System.out.println(reversedString);
	}
}
