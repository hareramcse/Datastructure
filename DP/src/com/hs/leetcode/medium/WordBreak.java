package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		int[] pos = new int[s.length() + 1];

		Arrays.fill(pos, -1);
		pos[0] = 0;

		for (int i = 0; i < s.length(); i++) {
			if (pos[i] != -1) {
				for (int j = i + 1; j <= s.length(); j++) {
					String sub = s.substring(i, j);
					if (wordDict.contains(sub)) {
						pos[j] = i;
					}
				}
			}
		}
		return pos[s.length()] != -1;
	}

	public static void main(String[] args) {
		WordBreak obj = new WordBreak();
		String input = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		boolean wordBreak = obj.wordBreak(input, wordDict);
		System.out.println(wordBreak);
	}
}
