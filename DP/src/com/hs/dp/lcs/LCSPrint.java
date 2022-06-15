package com.hs.dp.lcs;

public class LCSPrint {
	public String longestCommonSubsequence(String x, String y) {
		int m = x.length();
		int n = y.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		String result = "";
		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			if (x.charAt(i - 1) == y.charAt(j - 1)) {
				result = result + x.charAt(i - 1);
				i--;
				j--;
			} else {
				if (dp[i - 1][j] > dp[i][j - 1])
					i--;
				else
					j--;
			}
		}
		return result;
	}

	private String reverse(String x) {
		StringBuffer sb = new StringBuffer(x);
		StringBuffer reverse = sb.reverse();
		return reverse.toString();
	}

	public static void main(String[] args) {
		LCSPrint lcsrm = new LCSPrint();
		String x = "acbcf";
		String y = "abcdaf";
		String result = lcsrm.longestCommonSubsequence(x, y);
		result = lcsrm.reverse(result);
		System.out.println(result);
	}
}
