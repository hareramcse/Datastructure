package com.hs.dp.string;

public class MinimumNumberOfDeletionsAndInsertions {
	// Time Complexity O(n*m)
	// Space Complexity O(n*m)
	public int minOperations(String str1, String str2) {
		return str1.length() + str2.length() - 2 * solveTab(str1, str2);
	}

	public int solveTab(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
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
		MinimumNumberOfDeletionsAndInsertions obj = new MinimumNumberOfDeletionsAndInsertions();
		String str1 = "heap";
		String str2 = "pea";
		int result = obj.minOperations(str1, str2);
		System.out.println(result);
	}
}