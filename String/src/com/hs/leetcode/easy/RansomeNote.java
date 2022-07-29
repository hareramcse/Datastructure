package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : magazine.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (char ch : ransomNote.toCharArray()) {
			if (!map.containsKey(ch) || map.get(ch) <= 0) {
				return false;
			}

			map.put(ch, map.get(ch) - 1);
		}
		return true;
	}

	public static void main(String[] args) {
		RansomeNote obj = new RansomeNote();
		String ransomNote = "aa";
		String magazine = "aab";
		boolean result = obj.canConstruct(ransomNote, magazine);
		System.out.println(result);
	}
}
