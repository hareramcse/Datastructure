package com.hs.dp.string;

public class SCSPrint {
	public String shortestCommonSupersequence(String str1, String str2) {
		int[][] dp = solveTab(str1, str2);
		int i = str1.length();
		int j = str2.length();

		StringBuilder result = new StringBuilder();

		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				result.insert(0, str1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				result.insert(0, str1.charAt(i - 1));
				i--;
			} else {
				result.insert(0, str2.charAt(j - 1));
				j--;
			}
		}

		while (i > 0) {
			result.insert(0, str1.charAt(i - 1));
			i--;
		}

		while (j > 0) {
			result.insert(0, str2.charAt(j - 1));
			j--;
		}
		return result.toString();
	}

	private int[][] solveTab(String text1, String text2) {
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

		return dp;
	}

	public static void main(String[] args) {
		SCSPrint obj = new SCSPrint();
		String text1 = "abac";
		String text2 = "cab";
		String result = obj.shortestCommonSupersequence(text1, text2);
		System.out.println(result);
	}
}