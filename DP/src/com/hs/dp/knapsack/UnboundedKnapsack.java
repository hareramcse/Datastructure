package com.hs.dp.knapsack;

import java.util.Arrays;

public class UnboundedKnapsack {
	int knapSack(int val[], int wt[], int W) {
		int n = val.length;
		int[][] dp = new int[n][W + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		return solve(wt, val, n - 1, W, dp);
	}

	private int solve(int[] wt, int[] val, int n, int W, int[][] dp) {
		if (n < 0 || W <= 0)
			return 0;

		if (dp[n][W] != -1)
			return dp[n][W];

		int notTaken = solve(wt, val, n - 1, W, dp);

		int taken = Integer.MIN_VALUE;
		if (wt[n] <= W)
			taken = val[n] + solve(wt, val, n, W - wt[n], dp);

		dp[n][W] = Math.max(notTaken, taken);
		return dp[n][W];
	}
}
