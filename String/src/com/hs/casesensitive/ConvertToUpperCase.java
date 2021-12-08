package com.hs.casesensitive;

public class ConvertToUpperCase {

	// Converts a string to uppercase
	static String to_upper(char[] in) {
		for (int i = 0; i < in.length; i++)
			if ('a' <= in[i] && in[i] <= 'z')
				in[i] &= ~(1 << 5);
		return String.valueOf(in);
	}

	// Driver code
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(to_upper(str.toCharArray()));
	}

}