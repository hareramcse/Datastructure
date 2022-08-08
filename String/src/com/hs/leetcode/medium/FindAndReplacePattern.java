package com.hs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (isIsomorphicString(word, pattern)) {
				result.add(word);
			}
		}
		return result;
	}

	private boolean isIsomorphicString(String word, String pattern) {
		Map<Character, Character> sMap = new HashMap<>();
		for (int i = 0; i < word.length(); i++) {
			Character sChar = word.charAt(i);
			Character tChar = pattern.charAt(i);

			if (sMap.containsKey(sChar)) {
				if (sMap.get(sChar) != tChar)
					return false;
			}

			// if map does not contains sChar key but contains tchar as value and vice-versa
			if (sMap.containsValue(tChar) && !sMap.containsKey(sChar)) {
				return false;
			} else {
				sMap.put(sChar, tChar);
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