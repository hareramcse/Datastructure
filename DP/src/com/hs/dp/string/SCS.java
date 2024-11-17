package com.hs.dp.string;

public class SCS {
	public int scs(String text1, String text2) {
		return text1.length() + text2.length() - solveTab(text1, text2);
	}

	private int solveTab(String text1, String text2) {
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
		SCS obj = new SCS();
		String text1 = "abac";
		String text2 = "cab";
		int result = obj.scs(text1, text2);
		System.out.println(result);
	}
}