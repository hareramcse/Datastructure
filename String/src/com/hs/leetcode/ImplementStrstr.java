package com.hs.leetcode;

// 28. Implement strStr() Leetcode Easy
public class ImplementStrstr {
	public int strStr(String haystack, String needle) {
		if (haystack.isEmpty() || needle.isEmpty())
			return 0;
		int m = haystack.length();
		int n = needle.length();
		if (m < n)
			return -1;

		for (int i = 0; i <= m - n; i++) {
			int j;
			for (j = 0; j < n; j++) {
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}

			if (j == n)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		ImplementStrstr obj = new ImplementStrstr();
		String x = "hello";
		String y = "ll";
		int strStr = obj.strStr(x, y);
		System.out.println(strStr);
	}
}