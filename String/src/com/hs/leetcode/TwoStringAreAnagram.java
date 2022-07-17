package com.hs.leetcode;

public class TwoStringAreAnagram {

	// function to check if two strings are anagrams of each other
	private boolean areAnagram(char[] str1, char[] str2) {

		// Create a count array and initialize all values as 0
		int[] count = new int[256];

		// For each character in input strings,
		// increment count in the corresponding
		// count array
		for (int i = 0; i < str1.length; i++) {
			count[str1[i] - 'a']++;
			count[str2[i] - 'a']--;
		}

		// If both strings are of different length.
		if (str1.length != str2.length)
			return false;

		// See if there is any non-zero value in count array
		for (int i = 0; i < 256; i++)
			if (count[i] != 0) {
				return false;
			}
		return true;
	}

	public static void main(String[] args) {
		TwoStringAreAnagram obj = new TwoStringAreAnagram();
		char str1[] = "geeksforgeeks".toCharArray();
		char str2[] = "forgeeksgeeks".toCharArray();

		if (obj.areAnagram(str1, str2))
			System.out.print("The two strings are " + "anagram of each other");
		else
			System.out.print("The two strings are " + "not anagram of each other");
	}

}