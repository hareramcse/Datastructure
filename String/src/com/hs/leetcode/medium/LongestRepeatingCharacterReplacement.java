package com.hs.leetcode.medium;

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
}
