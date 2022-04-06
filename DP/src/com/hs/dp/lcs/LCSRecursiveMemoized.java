package com.hs.dp.lcs;

import java.util.Arrays;

public class LCSRecursiveMemoized {
	private static int[][] dp;

	private int lcs(String x, String y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (dp[m][n] != -1) {
			return dp[m][n];
		}

		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return dp[m][n] = 1 + lcs(x, y, m - 1, n - 1);
		} else {
			return dp[m][n] = Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
		}
	}

	public static void main(String[] args) {
		LCSRecursiveMemoized lcsrm = new LCSRecursiveMemoized();
		String x = "abcdgh";
		String y = "abedfhr";
		int m = x.length();
		int n = y.length();
		dp = new int[m + 1][n + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		int count = lcsrm.lcs(x, y, m, n);
		System.out.println(count);
	}

}
