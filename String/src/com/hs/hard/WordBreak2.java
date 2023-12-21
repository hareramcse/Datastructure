package com.hs.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak2 {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Map<Integer, List<String>> map = new HashMap<>();
		Set<String> set = new HashSet<>(wordDict);
		return wordBreakUtil(s, 0, set, map);
	}

	private List<String> wordBreakUtil(String s, int start, Set<String> set, Map<Integer, List<String>> map) {
		if (map.containsKey(start))
			return map.get(start);

		List<String> validSubString = new ArrayList<>();
		if (start == s.length())
			validSubString.add("");

		for (int end = start + 1; end <= s.length(); end++) {
			String prefix = s.substring(start, end);
			if (set.contains(prefix)) {
				List<String> suffixes = wordBreakUtil(s, end, set, map);
				for (String suffix : suffixes) {
					validSubString.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
				}
			}
		}
		map.put(start, validSubString);
		return validSubString;
	}

	public static void main(String[] args) {
		WordBreak2 obj = new WordBreak2();
		String s = "catsanddog";
		String[] wordDict = { "cat", "cats", "and", "sand", "dog" };
		List<String> list = Arrays.asList(wordDict);
		List<String> result = obj.wordBreak(s, list);
		System.out.println(result);
	}
}