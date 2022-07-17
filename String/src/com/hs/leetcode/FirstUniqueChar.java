package com.hs.leetcode;

import java.util.HashMap;
import java.util.Map;

// 387. First Unique Character in a String Leetcode
public class FirstUniqueChar {
	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, -1);
			} else {
				map.put(ch, i);
			}
		}

		Integer min = Integer.MAX_VALUE;
		for (char ch : map.keySet()) {
			if (map.get(ch) > -1 && map.get(ch) < min) {
				min = map.get(ch);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}
	
	public static void main(String[] args) {
		FirstUniqueChar obj = new FirstUniqueChar();
		String input = "loveleetcode";
		int firstUniqChar = obj.firstUniqChar(input);
		System.out.println(firstUniqChar);
	}
}
