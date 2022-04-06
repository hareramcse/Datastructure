package com.hs.dp.lcs;

public class MinNoOfDeletionToConvertIntoPolindrom {

	private void solve(String x, String y) {
		int lcs = lcs(x, y);
		System.out.println("Minimum no of deletion " + (x.length() - lcs));
	}

	private int lcs(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] dp = new int[m + 1][n + 1];

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
		return dp[m][n];
	}

	public static void main(String[] args) {
		MinNoOfDeletionToConvertIntoPolindrom lcsrm = new MinNoOfDeletionToConvertIntoPolindrom();
		String x = "aggtab";
		String y = "gxtxayb";

		lcsrm.solve(x, y);
	}
}