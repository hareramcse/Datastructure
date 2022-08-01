package com.hs.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharFromNString {
	public List<String> commonChars(String[] words) {
		int[] common = new int[26];
		Arrays.fill(common, Integer.MAX_VALUE);

		for (String word : words) {
			int[] frequencies = new int[26];
			for (char ch : word.toCharArray()) {
				frequencies[ch - 'a']++;
			}

			for (int i = 0; i < 26; i++) {
				common[i] = Math.min(common[i], frequencies[i]);
			}
		}

		List<String> ans = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			while (common[i] > 0) {
				ans.add("" + (char) (i + 'a'));
				common[i]--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		CommonCharFromNString obj = new CommonCharFromNString();
		String[] input = { "bella", "label", "roller" };
		List<String> commonChars = obj.commonChars(input);
		System.out.println(commonChars);
	}
}