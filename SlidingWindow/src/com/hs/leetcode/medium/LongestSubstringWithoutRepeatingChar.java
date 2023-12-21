package com.hs.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		
		int ans = Integer.MIN_VALUE;
		Set<Character> set = new HashSet<>();
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			while (set.contains(s.charAt(j))) {
				set.remove(s.charAt(i));
				i++;
			}
			set.add(s.charAt(j));
			ans = Math.max(ans, j - i + 1);
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