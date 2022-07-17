package com.hs.leetcode;

// 28. Implement strStr() Leetcode
public class ImplementStrstr {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return 0;

		if (needle.length() == 0)
			return 0;

		for (int i = 0; i < haystack.length(); i++) {
			if (i + needle.length() > haystack.length())
				return -1;

			int m = i;
			for (int j = 0; j < needle.length(); j++) {
				if (needle.charAt(j) == haystack.charAt(m)) {
					if (j == needle.length() - 1)
						return i;
					m++;
				} else {
					break;
				}

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ImplementStrstr obj = new ImplementStrstr();
		String x = "Techie Delight";
		String y = "light";
		int strStr = obj.strStr(x, y);
		System.out.println(strStr);
	}
}