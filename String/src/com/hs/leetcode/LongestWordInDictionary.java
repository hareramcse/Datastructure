package com.hs.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 720. Longest Word in Dictionary Leetcode Medium
public class LongestWordInDictionary {
	public String longestWord(String[] words) {
		Arrays.sort(words);
		Set<String> set = new HashSet<>();
		String result = "";

		for (String word : words) {
			if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
				set.add(word);
				if (word.length() > result.length())
					result = word;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		LongestWordInDictionary obj = new LongestWordInDictionary();
		String[] input = { "w", "wo", "wor", "worl", "world" };
		String longestWord = obj.longestWord(input);
		System.out.println(longestWord);
	}
}