package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		Map<Character, Character> sTMap = new HashMap<>();
		Map<Character, Character> tSMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character sChar = s.charAt(i);
			Character tChar = t.charAt(i);

			if (sTMap.containsKey(sChar)) {
				if (sTMap.get(sChar) != tChar)
					return false;
			}
			if (tSMap.containsKey(tChar)) {
				if (tSMap.get(tChar) != sChar)
					return false;
			}

			sTMap.put(sChar, tChar);
			tSMap.put(tChar, sChar);
		}

		return true;
	}

	public static void main(String[] args) {
		IsomorphicString obj = new IsomorphicString();
		String s = "egg";
		String t = "add";
		boolean result = obj.isIsomorphic(s, t);
		System.out.println(result);
	}
}