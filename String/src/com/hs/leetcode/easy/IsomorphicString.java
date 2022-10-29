package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character sChar = s.charAt(i);
			Character tChar = t.charAt(i);

			if (map.containsKey(sChar)) {
				if (map.get(sChar) != tChar)
					return false;
			} else if (map.containsValue(tChar)) {
				return false;
			} else {
				map.put(sChar, tChar);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		IsomorphicString obj = new IsomorphicString();
		String s = "eded";
		String t = "baba";
		boolean result = obj.isIsomorphic(s, t);
		System.out.println(result);
	}
}