package com.hs.leetcode.twoD.medium;

import java.util.Arrays;

public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {
		int index1 = text1.length();
		int index2 = text2.length();

		int[][] dp = new int[index1][index2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return lcsMemo(text1, text2, index1 - 1, index2 - 1, dp);
	}

	public int lcsMemo(String text1, String text2, int index1, int index2, int[][] dp) {
		if (index1 < 0 || index2 < 0)
			return 0;

		if (dp[index1][index2] != -1)
			return dp[index1][index2];

		if (text1.charAt(index1) == text2.charAt(index2))
			return dp[index1][index2] = 1 + lcsMemo(text1, text2, index1 - 1, index2 - 1, dp);

		return dp[index1][index2] = Math.max(lcsMemo(text1, text2, index1 - 1, index2, dp),
				lcsMemo(text1, text2, index1, index2 - 1, dp));
	}
}
