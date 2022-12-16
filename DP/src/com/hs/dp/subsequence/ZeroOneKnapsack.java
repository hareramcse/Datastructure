package com.hs.dp.subsequence;

import java.util.Arrays;

public class ZeroOneKnapsack {
	public int knapsack(int[] wt, int[] val, int n, int W) {
		int dp[][] = new int[n][W + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		return solveMemo(wt, val, n - 1, W, dp);
	}

	private int solveMemo(int[] wt, int[] val, int n, int W, int[][] dp) {
		if (n == 0) {
			if (wt[0] <= W)
				return val[0];
			else
				return 0;
		}

		if (dp[n][W] != -1)
			return dp[n][W];

		int notTaken = solveMemo(wt, val, n - 1, W, dp);
		int taken = Integer.MIN_VALUE;
		if (W >= wt[n]) {
			taken = val[n] + solveMemo(wt, val, n - 1, W - wt[n], dp);
		}

		return dp[n][W] = Math.max(notTaken, taken);
	}

	private int knapsackTab(int[] wt, int[] val, int n, int W) {
		int[][] dp = new int[n][W + 1];

		for (int i = wt[0]; i <= W; i++) {
			dp[0][i] = val[0];
		}

		for (int i = 1; i < n; i++) {
			for (int w = 0; w <= W; w++) {
				int notTaken = dp[i - 1][w];

				int taken = Integer.MIN_VALUE;
				if (wt[i] <= w)
					taken = val[i] + dp[i - 1][w - wt[i]];

				dp[i][w] = Math.max(notTaken, taken);
			}
		}

		return dp[n - 1][W];
	}

	public static void main(String[] args) {
		ZeroOneKnapsack obj = new ZeroOneKnapsack();
		int wt[] = { 1, 2, 4, 5 };
		int val[] = { 5, 4, 8, 6 };
		int W = 5;

		int n = wt.length;
		int result = obj.knapsack(wt, val, n - 1, W);
		System.out.println(result);

		result = obj.knapsackTab(wt, val, n, W);
		System.out.println(result);
	}
}