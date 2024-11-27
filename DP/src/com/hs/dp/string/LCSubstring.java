package com.hs.dp.string;

import java.util.Arrays;

public class LCSubstring {
	// Time Complexity O(n*m)
	// Space Complexity O(n*m)
	public int longestCommonSubString(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();

		int[][] dp = new int[n + 1][m + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		int[] max = { 0 };
		return solveMemo(text1, text2, n, m, dp, max);
	}

	public int solveMemo(String text1, String text2, int n, int m, int[][] dp, int[] max) {
		if (n == 0 || m == 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[n][m];

		if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
			dp[n][m] = 1 + solveMemo(text1, text2, n - 1, m - 1, dp, max);
			max[0] = Math.max(max[0], dp[n][m]);
		} else {
			dp[n][m] = 0;
		}
		return max[0];
	}

	// Time Complexity O(n*m)
	// Space Complexity O(n*m)
	public int solveTab(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();

		int[][] dp = new int[n + 1][m + 1];

		int ans = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (text1.charAt(i - 1) == text2.charAt(i - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					ans = Math.max(ans, dp[i][j]);
				} else
					dp[i][j] = 0;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		LCSubstring obj = new LCSubstring();
		String text1 = "abcd";
		String text2 = "abcd";
		int result = obj.longestCommonSubString(text1, text2);
		System.out.println(result);
		result = obj.solveTab(text1, text2);
		System.out.println(result);
	}
}