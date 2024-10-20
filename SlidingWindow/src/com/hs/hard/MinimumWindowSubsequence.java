package com.hs.hard;

public class MinimumWindowSubsequence {
	public String minWindow(String s, String t) {
		int sLen = s.length();
		int tLen = t.length();
		if (sLen == 0 || tLen == 0 || sLen < tLen) {
			return "";
		}

		int i = 0, j = 0, k = 0;
		int minLen = Integer.MAX_VALUE;
		String str = "";

		while (j < sLen) {
			// Move j to find a valid window that contains T as a subsequence
			if (s.charAt(j) == t.charAt(k)) {
				k++;
			}

			// When T is fully matched in the window
			if (k == tLen) {
				// Start shrinking the window from the rightmost match of T
				i = j;
				k--;

				// Shrink window from the left while maintaining the subsequence
				while (i >= 0 && k >= 0) {
					if (s.charAt(i) == t.charAt(k)) {
						k--;
					}
					i--;
				}
				i++; // Restore `i` to the start of the valid window

				// Update the result if the current window is smaller
				if (j - i + 1 < minLen) {
					minLen = j - i + 1;
					str = s.substring(i, j + 1); // Correct substring extraction
				}

				// Reset k for the next window search
				k = 0;
			}

			j++; // Move to the next character in S
		}

		return str;
	}

	public static void main(String[] args) {
		MinimumWindowSubsequence obj = new MinimumWindowSubsequence();
		String s = "abcdebdde";
		String t = "bde";
		String test = obj.minWindow(s, t);
		System.out.println(test);
	}
}