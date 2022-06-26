package com.hs.dp.lcs;

// 1092. Shortest Common Supersequence Leetcode
public class SCSSPrint {
	private String longestCommonSubsequence(String str1, String str2) {

		int m = str1.length();
		int n = str2.length();
		int[][] dp = lcs(str1, str2, m, n);

		String result = "";
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				result = result + str1.charAt(i - 1);
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1]) {
					result = result + str1.charAt(i - 1);
					i--;
				} else {
					result = result + str2.charAt(j - 1);
					j--;
				}
			}
		}

		while (i > 0) {
			result = result + str1.charAt(i - 1);
			i--;
		}
		while (j > 0) {
			result = result + str2.charAt(j - 1);
			j--;
		}
		return result = reverse(result);
	}
	
	private int[][] lcs(String str1, String str2, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
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
		SCSSPrint lcsrm = new SCSSPrint();
		String x = "aggtab";
		String y = "gxtxayb";
		String result = lcsrm.longestCommonSubsequence(x, y);
		System.out.println(result);
	}
}