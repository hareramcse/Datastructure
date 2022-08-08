package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
	public int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		int ans = 0;
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			int longestChain = 0;
			for (int i = 0; i < word.length(); i++) {
				String predecessor = word.substring(0, i) + word.substring(i + 1);
				longestChain = Math.max(longestChain, map.getOrDefault(predecessor, 0) + 1);
			}
			map.put(word, longestChain);
			ans = Math.max(ans, map.get(word));
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestStringChain obj = new LongestStringChain();
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		int result = obj.longestStrChain(words);
		System.out.println(result);
	}
}