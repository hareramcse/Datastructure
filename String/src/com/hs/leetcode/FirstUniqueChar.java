package com.hs.leetcode;

import java.util.HashMap;
import java.util.Map;

// 387. First Unique Character in a String Leetcode Easy
public class FirstUniqueChar {
	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueChar obj = new FirstUniqueChar();
		String input = "loveleetcode";
		int firstUniqChar = obj.firstUniqChar(input);
		System.out.println(firstUniqChar);
	}
}