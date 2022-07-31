package com.hs.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
	public int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		int res = 0;
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, 1);
			for (int i = 0; i < word.length(); i++) {
				StringBuilder current = new StringBuilder(word);
				String next = current.deleteCharAt(i).toString();
				if (map.containsKey(next)) {
					map.put(word, Math.max(map.get(word), map.get(next) + 1));
				}
			}

			res = Math.max(res, map.get(word));
		}
		return res;
	}

	public static void main(String[] args) {
		LongestStringChain obj = new LongestStringChain();
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		int result = obj.longestStrChain(words);
		System.out.println(result);
	}
}