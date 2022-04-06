package com.hs.dp.lcs;

public class SCSSTabulation {

	private int scs(String x, String y) {
		int m = x.length();
		int n = y.length();
		int dp[][] = new int[m + 1][n + 1];

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
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return m + n - dp[m][n];
	}

	public static void main(String[] args) {
		SCSSTabulation lcsrm = new SCSSTabulation();
		String x = "aggtab";
		String y = "gxtxayb";

		int count = lcsrm.scs(x, y);
		System.out.println(count);
	}
}