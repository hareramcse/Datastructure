package com.hs.leetcode;

// 44. Wildcard Matching Leetcode
public class WildCardMatching {
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;

		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}

		return j == p.length();
	}

	public static void main(String[] args) {
		WildCardMatching obj = new WildCardMatching();
		String input = "xyxzzxy";
		String pattern = "x***x?";
		boolean match = obj.isMatch(input, pattern);
		System.out.println(match);
	}
}
