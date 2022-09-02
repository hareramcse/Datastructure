package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {
	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0, ans = 0;

		while (j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			
			// it means there are some duplicate char in the window.
			while (map.size() < j - i + 1) {
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
				if (map.get(s.charAt(i)) == 0)
					map.remove(s.charAt(i));
				i++;
			}

			ans = Math.max(ans, j - i + 1);
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingChar obj = new LongestSubstringWithoutRepeatingChar();
		String str = "abcabcbb";
		int length = obj.lengthOfLongestSubstring(str);
		System.out.println(length);
	}
}