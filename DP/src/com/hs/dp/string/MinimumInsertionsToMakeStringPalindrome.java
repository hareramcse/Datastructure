package com.hs.dp.string;

public class MinimumInsertionsToMakeStringPalindrome {
	public int minInsertions(String s) {
		return s.length() - longestPalindromeSubseq(s);
	}

	public int longestPalindromeSubseq(String x) {
		String y = reverse(x);
		return solveTab(x, y);
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

	private String reverse(String x) {
		StringBuffer sb = new StringBuffer(x);
		StringBuffer reverse = sb.reverse();
		return reverse.toString();
	}

	public static void main(String[] args) {
		MinimumInsertionsToMakeStringPalindrome obj = new MinimumInsertionsToMakeStringPalindrome();
		String text = "CodingNinja";
		int result = obj.minInsertions(text);
		System.out.println(result);
	}
}