package com.hs.dp.mcm;

import java.util.Arrays;

public class MCMWithMemoization {
	private static int[][] dp;

	private int solve(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		for (int k = i; k < j; k++) {
			int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			min = Math.min(min, temp);
		}
		return dp[i][j] = min;
	}

	public static void main(String[] args) {
		MCMWithMemoization mcm = new MCMWithMemoization();
		int[] arr = { 1, 2, 3, 4, 3 };
		int i = 1;
		int j = arr.length - 1;
		dp = new int[100][100];
		for (int[] row : dp)
			Arrays.fill(row, -1);
		int ans = mcm.solve(arr, i, j);
		System.out.println(ans);
	}
}