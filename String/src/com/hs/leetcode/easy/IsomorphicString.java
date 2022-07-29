package com.hs.leetcode.easy;

public class IsomorphicString {
	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;

		int[] m1 = new int[256];
		int[] m2 = new int[256];

		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (m1[c1] != m2[c2])
				return false;

			m1[c1] = i + 1;
			m2[c2] = i + 1;
		}

		return true;
	}

	public static void main(String[] args) {
		IsomorphicString obj = new IsomorphicString();
		String s = "egg";
		String t = "add";
		boolean result = obj.isIsomorphic(s, t);
		System.out.println(result);
	}
}
