package com.hs.slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int i = 0, j = 0;

		Map<Character, Integer> map = new HashMap<>();
		int maxLength = 0, mostFreq = 0;
		while (j < s.length()) {
			char ch = s.charAt(j);
			map.put(s.charAt(j), map.getOrDefault(ch, 0) + 1);
			mostFreq = Math.max(mostFreq, map.get(ch));

			if ((j - i + 1) - mostFreq > k) {
				// remove the ith char before sliding the window
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
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