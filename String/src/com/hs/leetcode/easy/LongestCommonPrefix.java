package com.hs.leetcode.easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
					return strs[j].substring(0, i);
				}
			}
		}
		return strs[0];
	}

	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String[] strs = { "flower", "flow", "flight" };
		String longestCommonPrefix = obj.longestCommonPrefix(strs);
		System.out.println(longestCommonPrefix);
	}
}