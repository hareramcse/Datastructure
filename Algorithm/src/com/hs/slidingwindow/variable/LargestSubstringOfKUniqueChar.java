package com.hs.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringOfKUniqueChar {

	public int solve(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int j = 0;
		int i = 0;
		int max = Integer.MIN_VALUE;

		while (j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			if (map.size() == k) {
				max = Math.max(max, j - i + 1);
			} else if (map.size() > k) {
				while (map.size() > k) {
					map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
					if (map.get(s.charAt(i)) == 0)
						map.remove(s.charAt(i));
					i++;
				}
			}
			j++;
		}
		return max;
	}

	public static void main(String[] args) {
		LargestSubstringOfKUniqueChar mwsok = new LargestSubstringOfKUniqueChar();
		String str = "aabacbebebe";
		int k = 3;
		int maxWindowsSize = mwsok.solve(str, k);
		System.out.println(maxWindowsSize);
	}
}