package com.hs.dp.string;

import java.util.Arrays;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int n = s.length();
		int m = t.length();

		int[][] dp = new int[n][m];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(s, t, n - 1, m - 1, dp);
	}

	private int solveMemo(String s, String t, int i, int j, int[][] dp) {
		if (j < 0)
			return 1;
		if (i < 0)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (s.charAt(i) == t.charAt(j)) {
			int leaveOne = solveMemo(s, t, i - 1, j - 1, dp);
			int stay = solveMemo(s, t, i - 1, j, dp);

			return dp[i][j] = (leaveOne + stay);
		} else {
			return dp[i][j] = solveMemo(s, t, i - 1, j, dp);
		}
	}

	private int solveTab(String s, String t) {
		int n = s.length();
		int m = t.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= m; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1))
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		DistinctSubsequences obj = new DistinctSubsequences();
		String s = "babgbag";
		String t = "bag";
		int result = obj.numDistinct(s, t);
		System.out.println(result);

		result = obj.solveTab(s, t);
		System.out.println(result);
	}
}