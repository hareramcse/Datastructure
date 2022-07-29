package com.hs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1002. Find Common Characters Leetcode Easy
public class CommonCharFromNString {
	public List<String> commonChars(String[] words) {
		List<String> commonChars = new ArrayList<>();
		int[] minFrequencies = new int[26];
		Arrays.fill(minFrequencies, Integer.MAX_VALUE);

		for (String word : words) {
			int[] charFrequencies = new int[26];
			for (char ch : word.toCharArray()) {
				charFrequencies[ch - 'a']++;
			}

			for (int i = 0; i < 26; i++) {
				minFrequencies[i] = Math.min(minFrequencies[i], charFrequencies[i]);
			}
		}

		for (int i = 0; i < 26; i++) {
			while (minFrequencies[i] > 0) {
				commonChars.add("" + (char) (i + 'a'));
				minFrequencies[i]--;
			}
		}
		return commonChars;
	}

	public static void main(String[] args) {
		CommonCharFromNString obj = new CommonCharFromNString();
		String[] input = { "bella", "label", "roller" };
		List<String> commonChars = obj.commonChars(input);
		System.out.println(commonChars);
	}
}