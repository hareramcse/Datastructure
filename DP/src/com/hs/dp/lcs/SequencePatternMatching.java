package com.hs.dp.lcs;

// 392. Is Subsequence Leetcode
public class SequencePatternMatching {
	private boolean isSubsequence(String x, String y) {
		int length = lcs(x, y);
		if (x.length() == length) {
			return true;
		} else {
			return false;
		}
	}

	private int lcs(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		SequencePatternMatching lcsRecursive = new SequencePatternMatching();
		String x = "abc";
		String y = "ahbgdc";
		boolean found = lcsRecursive.isSubsequence(x, y);
		System.out.println(found);
	}
}