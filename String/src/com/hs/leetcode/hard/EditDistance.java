package com.hs.leetcode.hard;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word1.length();

		char[] ch1 = word1.toCharArray();
		char[] ch2 = word2.toCharArray();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					dp[i][j] = j;

				else if (j == 0)
					dp[i][j] = i;

				else if (ch1[i - 1] == ch2[j - 1])
					dp[i][j] = dp[i - 1][j - 1];

				else
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		EditDistance obj = new EditDistance();
		String word1 = "intention";
		String word2 = "execution";
		int result = obj.minDistance(word1, word2);
		System.out.println(result);
	}
}