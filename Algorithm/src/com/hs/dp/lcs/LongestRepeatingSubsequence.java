package com.hs.dp.lcs;

public class LongestRepeatingSubsequence {

	private String lcs(String x) {
		int n = x.length();
		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				dp[i][j] = 0;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				if (x.charAt(i - 1) == x.charAt(j - 1) && i != j)
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

		// This part of code finds the result string using dp[][]
		String res = "";

		// Traverse dp[][] from bottom right
		int i = n, j = n;
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i - 1][j - 1] + 1) {
				res = res + x.charAt(i - 1);
				i--;
				j--;
			} else if (dp[i][j] == dp[i - 1][j])
				i--;
			else
				j--;
		}

		String reverse = "";
		for (int k = res.length() - 1; k >= 0; k--) {
			reverse = reverse + res.charAt(k);
		}

		return reverse;
	}

	public static void main(String[] args) {
		LongestRepeatingSubsequence lcsrm = new LongestRepeatingSubsequence();
		String x = "AABEBCDD";
		String result = lcsrm.lcs(x);
		System.out.println(result);
	}
}