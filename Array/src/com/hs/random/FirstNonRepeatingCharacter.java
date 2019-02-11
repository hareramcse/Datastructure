package com.hs.random;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class FirstNonRepeatingCharacter {
	static Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

	static void firstNonRepeating(String str) {
		for (char ch : str.toCharArray()) {
			map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
		}

		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println(entry.getKey());
				break;
			}
		}
	}

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		firstNonRepeating(str);
	}
}