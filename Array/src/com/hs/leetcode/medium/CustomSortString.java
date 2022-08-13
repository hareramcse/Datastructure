package com.hs.leetcode.medium;

public class CustomSortString {
	public String customSortString(String order, String s) {
		int[] fre = new int[26];

		for (char ch : s.toCharArray()) {
			fre[ch - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : order.toCharArray()) {
			while (fre[ch - 'a'] > 0) {
				sb.append(ch);
				fre[ch - 'a']--;
			}
		}

		for (int i = 0; i < 26; i++) {
			while (fre[i] > 0) {
				sb.append((char) (i + 'a'));
				fre[i]--;
			}
		}
		return sb.toString();
	}
}
