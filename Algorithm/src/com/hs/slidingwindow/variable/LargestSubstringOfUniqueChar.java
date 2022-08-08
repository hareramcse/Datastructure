package com.hs.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

// 3. Longest Substring Without Repeating Characters Leetcode
public class LargestSubstringOfUniqueChar {

	private int solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0, ans = 0;

		while (j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

			if (map.size() == j - i + 1) {
				ans = Math.max(ans, j - i + 1);
			} else if (map.size() < j - i + 1) {
				while (map.size() < j - i + 1) {
					map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
					if (map.get(s.charAt(i)) == 0)
						map.remove(s.charAt(i));
					i++;
				}
			}
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		LargestSubstringOfUniqueChar mwsok = new LargestSubstringOfUniqueChar();
		String str = "aabacbebebe";
		int maxWindowsSize = mwsok.solve(str);
		System.out.println(maxWindowsSize);
	}
}
