package com.hs.dp.subsequence;

import java.util.Arrays;

public class UnboundedKnapsack {
	int knapSack(int val[], int wt[], int W) {
		int n = val.length;
		int[][] dp = new int[n][W + 1];
		for (int row[] : dp)
			Arrays.fill(row, -1);

		return solveMemo(wt, val, n - 1, W, dp);
	}

	private int solveMemo(int[] wt, int[] val, int ind, int W, int[][] dp) {
		if (ind == 0) {
			return ((int) (W / wt[0])) * val[0];
		}

		if (dp[ind][W] != -1)
			return dp[ind][W];

		int notTaken = 0 + solveMemo(wt, val, ind - 1, W, dp);

		int taken = Integer.MIN_VALUE;
		if (wt[ind] <= W)
			taken = val[ind] + solveMemo(wt, val, ind, W - wt[ind], dp);

		return dp[ind][W] = Math.max(notTaken, taken);
	}
}
