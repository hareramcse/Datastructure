package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAndReplacePattern {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (matches(word, pattern)) {
				result.add(word);
			}
		}

		return result;
	}

	private boolean matches(String word, String pattern) {
		char[] patternTOWord = new char[26];
		char[] wordTOPattern = new char[26];

		for (int i = 0; i < pattern.length(); i++) {
			char wordChar = word.charAt(i);
			char patterChar = pattern.charAt(i);

			if (patternTOWord[patterChar - 'a'] == 0) {
				patternTOWord[patterChar - 'a'] = wordChar;
			}
			if (wordTOPattern[wordChar - 'a'] == 0) {
				wordTOPattern[wordChar - 'a'] = patterChar;
			}

			if (patternTOWord[patterChar - 'a'] != wordChar || wordTOPattern[wordChar - 'a'] != patterChar) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		FindAndReplacePattern obj = new FindAndReplacePattern();
		String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		String pattern = "abb";
		List<String> result = obj.findAndReplacePattern(words, pattern);
		System.out.println(result);
	}
}