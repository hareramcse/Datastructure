package com.hs.occurance;

import java.util.Arrays;

public class KthNonRepeatingChar {

	public static int MAX_CHAR = 256;

	// Returns index of k'th non-repeating character in
	// given string str[]
	static int kthNonRepeating(String str, int k) {
		int n = str.length();

		// count[x] is going to store count of
		// character 'x' in str. If x is not present,
		// then it is going to store 0.
		int[] count = new int[MAX_CHAR];

		// index[x] is going to store index of character
		// 'x' in str. If x is not present or x is
		// repeating, then it is going to store a value
		// (for example, length of string) that cannot be
		// a valid index in str[]
		int[] index = new int[MAX_CHAR];

		// Initialize counts of all characters and indexes
		// of non-repeating characters.
		for (int i = 0; i < MAX_CHAR; i++) {
			count[i] = 0;
			index[i] = n; // A value more than any index
							// in str[]
		}

		// Traverse the input string
		for (int i = 0; i < n; i++) {
			// Find current character and increment its
			// count
			char x = str.charAt(i);
			++count[x];

			// If this is first occurrence, then set value
			// in index as index of it.
			if (count[x] == 1)
				index[x] = i;

			// If character repeats, then remove it from
			// index[]
			if (count[x] == 2)
				index[x] = n;
		}

		// Sort index[] in increasing order. This step
		// takes O(1) time as size of index is 256 only
		Arrays.sort(index);

		// After sorting, if index[k-1] is value, then
		// return it, else return -1.
		return (index[k - 1] != n) ? index[k - 1] : -1;
	}

	// driver program
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		int k = 3;
		int res = kthNonRepeating(str, k);

		System.out.println(res == -1 ? "There are less than k non-repeating characters"
				: "k'th non-repeating character is " + str.charAt(res));
	}

}