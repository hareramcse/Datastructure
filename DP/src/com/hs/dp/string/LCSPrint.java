package com.hs.dp.string;

public class LCSPrint {
	public String lcsPrint(String text1, String text2) {
		int[][] dp = solveTab(text1, text2);

		int n = text1.length();
		int m = text2.length();
		int i = n;
		int j = m;

		StringBuilder result = new StringBuilder();
		while (i > 0 && j > 0) {
			if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
				result.insert(0, text1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] >= dp[i][j - 1]) {
				i--;
			} else
				j--;
		}
		
		return result.toString();
	}

	public int[][] solveTab(String text1, String text2) {
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
		LCSPrint obj = new LCSPrint();
		String text1 = "abcde";
		String text2 = "bdgek";
		String result = obj.lcsPrint(text1, text2);
		System.out.println(result);
	}
}