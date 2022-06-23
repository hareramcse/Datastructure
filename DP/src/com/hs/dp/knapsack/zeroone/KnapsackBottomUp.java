package com.hs.dp.knapsack.zeroone;

public class KnapsackBottomUp {
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
					dp[i][j] = Math.max(val[i - 1] + dp[i-1][j - wt[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[n][W];
	}

	public static void main(String[] args) {
		KnapsackBottomUp kbu = new KnapsackBottomUp();
		int[] wt = new int[] { 1, 3, 4, 5 };
		int[] val = new int[] { 1, 4, 5, 7 };
		int W = 7;
		int maxGain = kbu.knapsack(wt, val, W);
		System.out.println(maxGain);
	}
}