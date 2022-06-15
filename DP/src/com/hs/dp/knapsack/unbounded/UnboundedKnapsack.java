package com.hs.dp.knapsack.unbounded;

public class UnboundedKnapsack {
	private int knapsack(int[] wt, int[] val, int W) {
		int n = wt.length;
		int[][] dp = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[n][W];
	}

	public static void main(String[] args) {
		UnboundedKnapsack kbu = new UnboundedKnapsack();
		int[] wt = new int[] { 5, 4, 6, 3 };
		int[] val = new int[] { 10, 40, 30, 50 };
		int W = 10;
		int maxGain = kbu.knapsack(wt, val, W);
		System.out.println(maxGain);
	}
}