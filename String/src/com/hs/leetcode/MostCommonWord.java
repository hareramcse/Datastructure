package com.hs.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 819. Most Common Word Leetcode Easy
public class MostCommonWord {
	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> bannedWord = new HashSet<>();
		for (String word : banned) {
			bannedWord.add(word);
		}

		Map<String, Integer> validWordCount = new HashMap<>();
		String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
		for (String word : words) {
			if (!bannedWord.contains(word)) {
				validWordCount.put(word, validWordCount.getOrDefault(word, 0) + 1);
			}
		}

		String result = "";
		for (String key : validWordCount.keySet()) {
			if (result.equals("") || validWordCount.get(key) > validWordCount.get(result)) {
				result = key;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MostCommonWord obj = new MostCommonWord();
		String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
		String[] banned = { "hit" };
		String mostCommonWord = obj.mostCommonWord(paragraph, banned);
		System.out.println(mostCommonWord);
	}
}