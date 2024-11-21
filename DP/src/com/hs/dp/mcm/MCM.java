package com.hs.dp.mcm;

import java.util.Arrays;

public class MCM {

	public int mcmMemoized(int[] arr, int n) {
		int[][] dp = new int[n][n];

		for (int row[] : dp)
			Arrays.fill(row, -1);

		int i = 1;
		int j = n - 1;

		return solveMemo(arr, i, j, dp);
	}

	private int solveMemo(int[] arr, int i, int j, int[][] dp) {
		if (i == j)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int mini = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int ans = solveMemo(arr, i, k, dp) + solveMemo(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
			mini = Math.min(mini, ans);
		}

		return dp[i][j] = mini;
	}

	public int solveTab(int[] arr, int n) {
		int[][] dp = new int[n][n];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		for (int i = 1; i < n; i++) {
			dp[i][i] = 0;
		}

		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j < n; j++) {
				int mini = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int ans = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
					mini = Math.min(mini, ans);
				}
				dp[i][j] = mini;
			}
		}
		return dp[1][n - 1];
	}

	public static void main(String[] args) {
		MCM obj = new MCM();
		int[] arr = { 10, 20, 30, 40, 50 };
		int result = obj.mcmMemoized(arr, arr.length);
		System.out.println(result);
		result = obj.solveTab(arr, arr.length);
		System.out.println(result);
	}
}