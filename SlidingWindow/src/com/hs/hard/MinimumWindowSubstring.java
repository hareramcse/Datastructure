package com.hs.hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
		}

		int i = 0, j = 0, count = map.size();
		String res = "";
		int min = Integer.MAX_VALUE;

		while (j < s.length()) {
			char ch = s.charAt(j);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) {
					count--;
				}
			}

			while (count == 0) {
				if (j - i + 1 < min) {
					res = s.substring(i, j + 1);
					min = j - i + 1;
				}

				char c = s.charAt(i);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
					if (map.get(c) > 0) {
						count++;
					}
				}
				i++;
			}
			j++;
		}
		return res;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring sol = new MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String res = sol.minWindow(s, t);
		System.out.println(res);
	}
}