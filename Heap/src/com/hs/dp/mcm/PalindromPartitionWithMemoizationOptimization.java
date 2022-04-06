package com.hs.dp.mcm;

import java.util.Arrays;

public class PalindromPartitionWithMemoizationOptimization {
	private static int[][] dp;

	private int solve(String str, int i, int j) {
		if (i >= j || isPalindrome(str, i, j)) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		for (int k = i; k < j; k++) {
			if (dp[i][k] != -1) {
				left = dp[i][k];
			} else {
				left = solve(str, i, k);
				dp[i][k] = left;
			}

			if (dp[k + 1][j] != -1) {
				right = dp[k + 1][j];
			} else {
				right = solve(str, k + 1, j);
				dp[k + 1][j] = right;
			}
			int count = left + right + 1;
			min = Math.min(min, count);
		}
		return dp[i][j] = min;
	}

	private boolean isPalindrome(String string, int i, int j) {
		while (i < j) {
			if (string.charAt(i) != string.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromPartitionWithMemoizationOptimization mcm = new PalindromPartitionWithMemoizationOptimization();
		String str = "ababbbabbababa";

		int i = 0;
		int j = str.length() - 1;
		dp = new int[100][100];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		int minCount = mcm.solve(str, i, j);
		System.out.println("Min cuts needed for Palindrome Partitioning is " + minCount);
	}
}