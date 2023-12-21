package com.hs.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int result = 0;
		boolean oddFound = false;

		for (int value : map.values()) {
			if (value % 2 == 0)
				result += value;
			else {
				oddFound = true;
				result += value - 1;
			}
		}

		// this is for middle element of the palindrome
		if (oddFound)
			result++;

		return result;
	}

	public static void main(String[] args) {
		LongestPalindrome obj = new LongestPalindrome();
		String input = "abccccdd";
		int longestPalindrome = obj.longestPalindrome(input);
		System.out.println(longestPalindrome);
	}
}