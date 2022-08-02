package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Character> sMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character sChar = s.charAt(i);
			Character tChar = t.charAt(i);

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
		IsomorphicString obj = new IsomorphicString();
		String s = "badc";
		String t = "baba";
		boolean result = obj.isIsomorphic(s, t);
		System.out.println(result);
	}
}