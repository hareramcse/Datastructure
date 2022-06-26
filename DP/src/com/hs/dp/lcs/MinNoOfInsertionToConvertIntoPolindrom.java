package com.hs.dp.lcs;

public class MinNoOfInsertionToConvertIntoPolindrom {

	private int minInsertion(String x) {
		int lps = lps(x);
		return x.length() - lps;
	}

	private int lps(String x) {
		String y = reverse(x);
		return lcs(x, y);
	}

	private int lcs(String x, String y) {
		int m = x.length();
		int n = y.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	private String reverse(String x) {
		StringBuffer sb = new StringBuffer(x);
		StringBuffer reverse = sb.reverse();
		return reverse.toString();
	}

	public static void main(String[] args) {
		MinNoOfInsertionToConvertIntoPolindrom lcsrm = new MinNoOfInsertionToConvertIntoPolindrom();
		String x = "aggtab";

		int noOfInsertion = lcsrm.minInsertion(x);

		System.out.println("Minimum no of insertion " + noOfInsertion);
	}
}