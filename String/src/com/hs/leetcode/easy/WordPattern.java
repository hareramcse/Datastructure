package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// 290. Word Pattern Leetcode
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] arr = str.split(" ");

		// prevent out of boundary problem
		if (arr.length != pattern.length())
			return false;

		Map<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				String value = map.get(c);
				if (!value.equals(arr[i])) {
					return false;
				}
			} else if (map.containsValue(arr[i])) {
				return false;
			}
			map.put(c, arr[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		WordPattern obj = new WordPattern();
		String pattern = "abba";
		String s = "dog cat cat dog";
		boolean wordPattern = obj.wordPattern(pattern, s);
		System.out.println(wordPattern);
	}
}