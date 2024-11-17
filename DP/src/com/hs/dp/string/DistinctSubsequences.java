package com.hs.dp.string;

import java.util.Arrays;

public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
		int n = s.length();
		int m = t.length();

		int[][] dp = new int[n + 1][m + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(s, t, n, m, dp);
	}

	private int solveMemo(String s, String t, int n, int m, int[][] dp) {
		if (m == 0)
			return 1;

		if (n == 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[n][m];

		if (s.charAt(n - 1) == t.charAt(m - 1)) {
			int take = solveMemo(s, t, n - 1, m - 1, dp);
			int notTake = solveMemo(s, t, n - 1, m, dp);

			dp[n][m] = take + notTake;
		} else {
			dp[n][m] = solveMemo(s, t, n - 1, m, dp);
		}
		return dp[n][m];
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