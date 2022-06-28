package com.hs.dp.mcm;

import java.util.Arrays;

public class MinPalindromPartitionWithMemoization {

	private int solve(String str) {
		int i = 0;
		int j = str.length() - 1;
		int[][] dp = new int[str.length()][str.length()];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		return solve(dp, str, i, j);
	}

	private int solve(int[][] dp, String str, int i, int j) {
		if (i >= j || isPalindrome(str, i, j)) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			int count = 1 + solve(dp, str, i, k) + solve(dp, str, k + 1, j);
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
		MinPalindromPartitionWithMemoization mcm = new MinPalindromPartitionWithMemoization();
		String str = "ababbbabbababa";
		int minCount = mcm.solve(str);
		System.out.println("Min cuts needed for Palindrome Partitioning is " + minCount);
	}
}