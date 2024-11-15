package com.hs.dp.string;

import java.util.Arrays;

public class LCS {
	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();

		int[][] dp = new int[n][m];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(text1, text2, n - 1, m - 1, dp);
	}

	public int solveMemo(String text1, String text2, int n, int m, int[][] dp) {
		if (n < 0 || m < 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[n][m];

		if (text1.charAt(n) == text2.charAt(m))
			return dp[n][m] = 1 + solveMemo(text1, text2, n - 1, m - 1, dp);

		// take the maximum of excluding one character from either string
		int first = solveMemo(text1, text2, n - 1, m, dp);
		int second = solveMemo(text1, text2, n, m - 1, dp);
		dp[n][m] = Math.max(first, second);
		return dp[n][m];
	}

	public int solveTab(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (text1.charAt(i - 1) == text2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[n][m];
	}

	public static void main(String[] args) {
		LCS obj = new LCS();
		String a = "acd";
		String b = "ced";
		int result = obj.longestCommonSubsequence(a, b);
		System.out.println(result);

		result = obj.solveTab(a, b);
		System.out.println(result);
	}
}
