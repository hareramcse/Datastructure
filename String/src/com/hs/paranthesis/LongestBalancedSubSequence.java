package com.hs.paranthesis;

public class LongestBalancedSubSequence {

	static int maxLength(String s, int n) {
		// As it's subsequence - assuming first
		// open brace would map to a first close
		// brace which occurs after the open brace
		// to make subsequence balanced and second
		// open brace would map to second close
		// brace and so on.

		// Variable to count all the open brace
		// that does not have the corresponding
		// closing brace.
		int invalidOpenBraces = 0;

		// To count all the close brace that
		// does not have the corresponding open brace.
		int invalidCloseBraces = 0;

		// Iterating over the String
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {

				// Number of open braces that
				// hasn't been closed yet.vvvvvv
				invalidOpenBraces++;
			} else {
				if (invalidOpenBraces == 0) {

					// Number of close braces that
					// cannot be mapped to any open
					// brace.
					invalidCloseBraces++;
				} else {

					// Mapping the ith close brace
					// to one of the open brace.
					invalidOpenBraces--;
				}
			}
		}
		return (n - (invalidOpenBraces + invalidCloseBraces));
	}

	// Driver Code
	public static void main(String[] args) {
		String s = "()(((((()";
		int n = s.length();
		System.out.println(maxLength(s, n));
	}

}