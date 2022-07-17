package com.hs.leetcode;

import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingChar {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet<>();
		int result = 1;
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (!set.contains(c)) {
				set.add(c);
				result = Math.max(result, set.size());
			} else {
				while (i < j) {
					if (s.charAt(i) == c) {
						i++;
						break;
					}

					set.remove(s.charAt(i));
					i++;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingChar obj = new LongestSubstringWithoutRepeatingChar();
		String str = "geeksforgeeks";
		int length = obj.lengthOfLongestSubstring(str);
		System.out.println(length);
	}
}
