package com.hs.dp.mcm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 87. Scramble String Leetcode
class ScrambleStringMemoized {

	public boolean isScramble(String s1, String s2) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		return isScramble(s1, s2, map);
	}

	private boolean isScramble(String s1, String s2, Map<String, Boolean> map) {

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

		// make key of type string for search in map
		String key = (s1 + " " + s2);
		if (map.containsKey(key)) {
			return map.get(key);
		}

		// declaring flag variable to store result
		boolean flag = false;
		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, s1.length());
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, s2.length());
			String s23 = s2.substring(0, s2.length() - i);
			String s24 = s2.substring(s2.length() - i, s2.length());

			// if there is no swapping
			if (isScramble(s11, s21, map) && isScramble(s12, s22, map)) {
				flag = true;
				return true;
			}

			// if there is swapping
			if (isScramble(s11, s24, map) && isScramble(s12, s23, map)) {
				flag = true;
				return true;
			}

		}
		map.put(key, flag);
		// If none of the above conditions are satisfied
		return false;
	}

	public static void main(String[] args) {
		ScrambleStringMemoized abc = new ScrambleStringMemoized();
		String S1 = "eebaacbcbcadaaedceaaacadccd";
		String S2 = "eadcaacabaddaceacbceaabeccd";

		if (abc.isScramble(S1, S2)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}