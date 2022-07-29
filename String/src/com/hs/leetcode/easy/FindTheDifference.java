package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (char ch : t.toCharArray()) {
			if (map.containsKey(ch) && map.get(ch) == 0 || !map.containsKey(ch)) {
				return ch;
			} else {
				map.put(ch, map.get(ch) - 1);
			}
		}
		return '|';
	}

	public static void main(String[] args) {
		FindTheDifference obj = new FindTheDifference();
		String s = "abcd";
		String t = "abcde";
		char result = obj.findTheDifference(s, t);
		System.out.println(result);
	}
}
