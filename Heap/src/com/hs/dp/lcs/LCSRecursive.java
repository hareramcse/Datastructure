package com.hs.dp.lcs;

public class LCSRecursive {
	private int lcs(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (x.charAt(m - 1) == y.charAt(m - 1)) {
			return 1 + lcs(x, y, m - 1, n - 1);
		} else {
			return Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
		}
	}

	public static void main(String[] args) {
		LCSRecursive lcsRecursive = new LCSRecursive();
		String x = "abcdgh";
		String y = "abedfhr";
		int m = x.length();
		int n = y.length();
		int count = lcsRecursive.lcs(x, y, m, n);
		System.out.println(count);
	}
}