package com.hs.dp.mcm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ScrambleString {
	private static Map<String, Boolean> map = new HashMap<String, Boolean>();

	private boolean isScramble(String S1, String S2) {

		// Strings of non-equal length cant' be scramble strings
		if (S1.length() != S2.length()) {
			return false;
		}

		int n = S1.length();

		// Empty strings are scramble strings
		if (n == 0) {
			return true;
		}

		// Equal strings are scramble strings
		if (S1.equals(S2)) {
			return true;
		}

		// Converting string to character array
		char[] tempArray1 = S1.toCharArray();
		char[] tempArray2 = S2.toCharArray();

		// Checking condition for Anagram
		Arrays.sort(tempArray1);
		Arrays.sort(tempArray2);

		String copy_S1 = new String(tempArray1);
		String copy_S2 = new String(tempArray2);

		if (!copy_S1.equals(copy_S2)) {
			return false;
		}

		// make key of type string for search in map
		String key = (S1 + " " + S2);
		if (map.containsKey(key)) {
			return map.get(key);
		}

		// declaring flag variable to store result
		boolean flag = false;
		for (int i = 1; i < n; i++) {

			// Check if S2[0...i] is a scrambled
			// string of S1[0...i] and if S2[i+1...n] is a scrambled string of S1[i+1...n]
			if (isScramble(S1.substring(0, i), S2.substring(0, i))
					&& isScramble(S1.substring(i, n), S2.substring(i, n))) {
				flag = true;
				return true;
			}

			// Check if S2[0...i] is a scrambled
			// string of S1[n-i...n] and S2[i+1...n] is a scramble string of S1[0...n-i-1]
			if (isScramble(S1.substring(n - i, n), S2.substring(0, i))
					&& isScramble(S1.substring(0, n - i), S2.substring(i, n))) {
				flag = true;
				return true;
			}
		}
		map.put(key, flag);
		// If none of the above conditions are satisfied
		return false;
	}

	public static void main(String[] args) {
		ScrambleString abc = new ScrambleString();
		String S1 = "coder";
		String S2 = "ocred";

		if (abc.isScramble(S1, S2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}