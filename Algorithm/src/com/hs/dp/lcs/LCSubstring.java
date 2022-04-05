package com.hs.dp.lcs;

public class LCSubstring {

	private int lcs(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] dp = new int[m + 1][n + 1];

		int count = 0;
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					count = Math.max(dp[i][j], count);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		LCSubstring lcsrm = new LCSubstring();
		String x = "abcdgh";
		String y = "abedfhr";

		int count = lcsrm.lcs(x, y);
		System.out.println(count);
	}

}
