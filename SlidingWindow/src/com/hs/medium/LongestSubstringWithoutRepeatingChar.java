package com.hs.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;

		Set<Character> set = new HashSet<>();
		int ans = Integer.MIN_VALUE;
		int i = 0;
		int j = 0;
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				ans = Math.max(ans, j - i + 1);
				j++;
			} else {
				set.remove(s.charAt(i));
				i++;
			}
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