package com.hs.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {
	public List<String> commonChars(String[] words) {
		int[] common = new int[26];
		Arrays.fill(common, Integer.MAX_VALUE);

		for (String word : words) {
			int[] freq = new int[26];
			for (char ch : word.toCharArray()) {
				freq[ch - 'a']++;
			}

			for (int i = 0; i < 26; i++) {
				common[i] = Math.min(common[i], freq[i]);
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
		FindCommonCharacters obj = new FindCommonCharacters();
		String[] input = { "bella", "label", "roller" };
		List<String> commonChars = obj.commonChars(input);
		System.out.println(commonChars);
	}
}