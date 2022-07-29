package com.hs.leetcode.easy;

public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		int idx = (s + s).indexOf(s, 1);
		return idx < s.length();
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern obj = new RepeatedSubstringPattern();
		String s = "abab";
		boolean result = obj.repeatedSubstringPattern(s);
		System.out.println(result);
	}
}
