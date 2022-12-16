package com.hs.dp.string;

import java.util.Arrays;

public class LCS {
	public int longestCommonSubsequence(String text1, String text2) {
		int index1 = text1.length();
		int index2 = text2.length();

		int[][] dp = new int[index1][index2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(text1, text2, index1 - 1, index2 - 1, dp);
	}

	public int solveMemo(String text1, String text2, int index1, int index2, int[][] dp) {
		if (index1 < 0 || index2 < 0)
			return 0;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		if (text1.charAt(index1) == text2.charAt(index2))
			return dp[index1][index2] = 1 + solveMemo(text1, text2, index1 - 1, index2 - 1, dp);

		return dp[index1][index2] = Math.max(solveMemo(text1, text2, index1 - 1, index2, dp),
				solveMemo(text1, text2, index1, index2 - 1, dp));
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
