package com.hs.dp.string;

import java.util.Arrays;

public class EditDistance {
	// Time Complexity O(n*m)
	// Space Complexity O(n*m)
	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		int[][] dp = new int[n + 1][m + 1];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return solveMemo(word1, word2, n, m, dp);
	}

	private static int solveMemo(String word1, String word2, int n, int m, int[][] dp) {
		if (n == 0) {
			return m; // All insertions
		}

		if (m == 0) {
			return n; // All deletions
		}

		if (dp[n][m] != -1) {
			return dp[n][m];
		}

		// If characters are the same, no operation needed, move to the next characters
		if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
			dp[n][m] = solveMemo(word1, word2, n - 1, m - 1, dp);
		} else {
			int insert = solveMemo(word1, word2, n, m - 1, dp);
			int delete = solveMemo(word1, word2, n - 1, m, dp);
			int replace = solveMemo(word1, word2, n - 1, m - 1, dp);
			dp[n][m] = 1 + Math.min(insert, Math.min(delete, replace));
		}

		return dp[n][m];
	}

	// Time Complexity O(n*m)
	// Space Complexity O(n*m)
	public int solveTab(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= m; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];

				else
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		EditDistance obj = new EditDistance();
		String word1 = "intention";
		String word2 = "execution";
		int result = obj.minDistance(word1, word2);
		System.out.println(result);
	}
}