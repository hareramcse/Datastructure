package com.hs.medium;

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

		for (char ch : s.toCharArray()) {
			while (fre[ch - 'a'] > 0) {
				sb.append(ch);
				fre[ch - 'a']--;
			}
		}
		return sb.toString();
	}
}
