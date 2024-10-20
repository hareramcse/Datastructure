package com.hs.medium;

import java.util.Arrays;

public class PermutationInString {
	public boolean checkInclusion(String s1, String s2) {
		int[] s1Fre = new int[26];
		int[] s2Fre = new int[26];
		for (char ch : s1.toCharArray()) {
			s1Fre[ch - 'a']++;
		}

		int i = 0, j = 0;
		while (j < s2.length()) {
			char ch = s2.charAt(j);
			s2Fre[ch - 'a']++;

			if (j - i + 1 == s1.length()) {
				if (Arrays.equals(s1Fre, s2Fre))
					return true;
				
				s2Fre[s2.charAt(i) - 'a']--;
				i++;
			}
			j++;
		}
		return false;
	}

	public static void main(String[] args) {
		PermutationInString obj = new PermutationInString();
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean checkInclusion = obj.checkInclusion(s1, s2);
		System.out.println(checkInclusion);
	}
}