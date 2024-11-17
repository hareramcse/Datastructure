package com.hs.dp.string;

public class LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String x) {
		String y = reverse(x);
		return solveTab(x, y);
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

	private String reverse(String x) {
		StringBuffer sb = new StringBuffer(x);
		StringBuffer reverse = sb.reverse();
		return reverse.toString();
	}

	public static void main(String[] args) {
		LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
		String text1 = "bbbab";
		int result = obj.longestPalindromeSubseq(text1);
		System.out.println(result);
	}
}