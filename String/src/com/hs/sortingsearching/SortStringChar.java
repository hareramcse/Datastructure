package com.hs.sortingsearching;

public class SortStringChar {

	static final int MAX_CHAR = 26;

	// function to print string in sorted order
	static void sortString(String str) {

		// Hash array to keep count of characters.
		int letters[] = new int[MAX_CHAR];

		// Traverse string and increment
		// count of characters
		for (char x : str.toCharArray()) {

			// 'a'-'a' will be 0, 'b'-'a' will be 1,
			// so for location of character in count
			// array we will do str[i]-'a'.
			letters[x - 'a']++;
		}

		// Traverse the hash array and print
		// characters
		for (int i = 0; i < MAX_CHAR; i++) {
			for (int j = 0; j < letters[i]; j++) {
				System.out.print((char) (i + 'a'));
			}
		}
	}

	// Driver program to test above function
	public static void main(String[] args) {
		sortString("geeksforgeeks");
	}

}