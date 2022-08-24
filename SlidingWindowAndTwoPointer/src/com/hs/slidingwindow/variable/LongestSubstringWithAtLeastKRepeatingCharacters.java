package com.hs.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

// TODO its not working for -ve numbers.
public class LongestSubstringWithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
		if (s.isEmpty() || k == 0)
			return 0;

		int i = 0, j = 0, ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (j < s.length()) {
			char ch = s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			while (map.size() < j - i + 1) {
				int fre = map.get(ch);
				if (fre >= k) {
					ans = Math.max(ans, j - i + 1);
				}
				i++;
			}
			j++;
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestSubstringWithAtLeastKRepeatingCharacters obj = new LongestSubstringWithAtLeastKRepeatingCharacters();
		String s = "ababbc";
		int k = 2;
		int result = obj.longestSubstring(s, k);
		System.out.println(result);
	}
}