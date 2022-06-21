package com.hs.dp.mcm;

import java.util.Arrays;

class ScrambleStringRecursive {

	private boolean isScramble(String s1, String s2) {

		// Strings of non-equal length cant' be scramble strings
		if (s1.length() != s2.length()) {
			return false;
		}

		// Empty and Equal strings are scramble strings
		if (s1.length() == 0 || s1.equals(s2)) {
			return true;
		}

		// Converting string to character array
		char[] tempArray1 = s1.toCharArray();
		char[] tempArray2 = s2.toCharArray();

		// Checking condition for Anagram
		Arrays.sort(tempArray1);
		Arrays.sort(tempArray2);

		String copy_S1 = new String(tempArray1);
		String copy_S2 = new String(tempArray2);

		if (!copy_S1.equals(copy_S2)) {
			return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, s1.length());
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, s2.length());
			String s23 = s2.substring(0, s2.length() - i);
			String s24 = s2.substring(s2.length() - i, s2.length());

			// if there is no swapping
			if (isScramble(s11, s21) && isScramble(s12, s22)) {
				return true;
			}

			// if there is swapping
			if (isScramble(s11, s24) && isScramble(s12, s23)) {
				return true;
			}

		}
		// If none of the above conditions are satisfied
		return false;
	}

	public static void main(String[] args) {
		ScrambleStringRecursive abc = new ScrambleStringRecursive();
		String S1 = "coder";
		String S2 = "ocred";

		if (abc.isScramble(S1, S2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}