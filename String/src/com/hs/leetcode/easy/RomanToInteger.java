package com.hs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int n = s.length();
		Integer result = map.get(s.charAt(n - 1));
		for (int i = n - 2; i >= 0; i--) {
			if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
				result -= map.get(s.charAt(i));
			else
				result += map.get(s.charAt(i));
		}
		return result;
	}

	public static void main(String[] args) {
		RomanToInteger obj = new RomanToInteger();
		String s = "LVIII";
		int result = obj.romanToInt(s);
		System.out.println(result);
	}
}