package com.hs.leetcode.easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
			}
		}

		return prefix;
	}

	public static void main(String[] args) {
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String[] strs = { "flower", "flow", "flight" };
		String longestCommonPrefix = obj.longestCommonPrefix(strs);
		System.out.println(longestCommonPrefix);
	}
}