package com.hs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int j = 0;
		int i = 0;
		int ans = 0;

		while (j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			while (map.size() > k) {
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
				if (map.get(s.charAt(i)) == 0) {
					map.remove(s.charAt(i));
				}
				i++;
			}
			ans = Math.max(ans, j - i + 1);
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestSubstringWithAtMostKDistinctCharacters mwsok = new LongestSubstringWithAtMostKDistinctCharacters();
		String str = "aabacbebebe";
		int k = 3;
		int result = mwsok.lengthOfLongestSubstringKDistinct(str, k);
		System.out.println(result);
	}
}