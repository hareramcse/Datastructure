package com.hs.dp.lcs;

public class LongestRepeatingSubsequence {

	private String longestRepeatingSubsequence(String x) {
		int n = x.length();
		int[][] dp = lcs(x, n);

		// This part of code finds the result string using dp[][]
		String result = "";

		// Traverse dp[][] from bottom right
		int i = n, j = n;
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i - 1][j - 1] + 1) {
				result = result + x.charAt(i - 1);
				i--;
				j--;
			} else if (dp[i][j] == dp[i - 1][j])
				i--;
			else
				j--;
		}

		return result = reverse(result);
	}

	private int[][] lcs(String x, int n) {
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if ((x.charAt(i - 1) == x.charAt(j - 1)) && i != j)
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp;
	}

	private String reverse(String x) {
		StringBuffer sb = new StringBuffer(x);
		StringBuffer reverse = sb.reverse();
		return reverse.toString();
	}

	public static void main(String[] args) {
		LongestRepeatingSubsequence lcsrm = new LongestRepeatingSubsequence();
		String x = "AABEBCDD";
		String result = lcsrm.longestRepeatingSubsequence(x);
		System.out.println(result);
	}
}