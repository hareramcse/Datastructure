package com.hs.slidingwindow.fixed;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		char[] arr = s.toCharArray();
		int i = 0, j = 0, n = s.length();

		Map<Character, Integer> map = new HashMap<>();
		int maxLength = 0, mostFreq = 0;
		while (j < n) {
			map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
			mostFreq = Math.max(mostFreq, map.get(arr[j]));

			if ((j - i + 1) - mostFreq > k) {
				map.put(arr[i], map.get(arr[i]) - 1);
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