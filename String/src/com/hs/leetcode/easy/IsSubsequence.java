package com.hs.leetcode.easy;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;

		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j))
				i++;
			j++;
		}
		return i == s.length();
	}

	public static void main(String[] args) {
		IsSubsequence obj = new IsSubsequence();
		String s = "abc";
		String t = "ahbgdc";
		boolean result = obj.isSubsequence(s, t);
		System.out.println(result);
	}
}
