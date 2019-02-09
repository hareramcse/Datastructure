package com.hs.basic;

public class StringReverseByBinaryAlgorithm {

	public static String reverse(String str) {
		char[] s = str.toCharArray();
		int n = s.length;
		int mid = n / 2;
		for (int i = 0; i < mid; i++) {
			char temp = s[i];
			s[i] = s[n - 1 - i];
			s[n - 1 - i] = temp;
		}
		return new String(s);
	}

	public static void main(String[] args) {
		String str = "my name is khan and i am not a terrorist";
		String reversedString = StringReverseByBinaryAlgorithm.reverse(str);
		System.out.println(reversedString);
	}
}
