package com.hs.leetcode.medium;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
		return longestSubstringUtil(s.toCharArray(), 0, s.length(), k);
	}

	private int longestSubstringUtil(char[] ch, int start, int end, int k) {
		if (end - start < k)
			return 0;

		int[] count = new int[26];
		for (int i = start; i < end; i++) {
			count[ch[i] - 'a']++;
		}

		for (int i = start; i < end; i++) {
			if (count[ch[i] - 'a'] < k) {
				int j = i + 1;

				while (j < end && count[ch[j] - 'a'] < k) {
					j++;
				}
				int a = longestSubstringUtil(ch, start, i, k);
				int b = longestSubstringUtil(ch, j, end, k);
				return Math.max(a, b);
			}
		}
		return end - start;
	}

	public static void main(String[] args) {
		LongestSubstringWithAtLeastKRepeatingCharacters obj = new LongestSubstringWithAtLeastKRepeatingCharacters();
		String s = "ababbc";
		int k = 2;
		int result = obj.longestSubstring(s, k);
		System.out.println(result);
	}
}