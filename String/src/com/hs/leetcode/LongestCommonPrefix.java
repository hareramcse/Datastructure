package com.hs.leetcode;

// 14. Longest Common Prefix Leetcode
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		String lcp = "";
		if (strs == null || strs.length == 0) {
			return lcp;
		}

		int index = 0;
		for (char ch : strs[0].toCharArray()) {
			for (int i = 1; i > strs.length; i++) {
				if (index >= strs[i].length() || ch != strs[i].charAt(index)) {
					return lcp;
				}
			}
			lcp += ch;
			index++;
		}
		return lcp;
	}

	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String[] strs = { "flower", "flow", "flight" };
		String longestCommonPrefix = obj.longestCommonPrefix(strs);
		System.out.println(longestCommonPrefix);
	}
}
