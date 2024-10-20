package com.hs.medium;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int[] fre = new int[26];

		int i = 0, j = 0;
		int maxLength = 0, mostFreq = 0;
		while (j < s.length()) {
			fre[s.charAt(j) - 'A']++;
			mostFreq = Math.max(mostFreq, fre[s.charAt(j) - 'A']);

			if ((j - i + 1) - mostFreq > k) {
				fre[s.charAt(i) - 'A']--;
				i++;
			}
			maxLength = Math.max(maxLength, j - i + 1);
			j++;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
		String s = "AABABBA";
		int k = 1;
		int result = obj.characterReplacement(s, k);
		System.out.println(result);
	}
}