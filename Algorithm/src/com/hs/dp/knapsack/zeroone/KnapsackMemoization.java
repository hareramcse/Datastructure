package com.hs.dp.knapsack.zeroone;

import java.util.Arrays;

public class KnapsackMemoization {
	private static int[][] dp;

	private int solve(int[] wt, int[] val, int w, int n) {
		if (n == 0 || w == 0)
			return 0;

		if (dp[n][w] != -1)
			return dp[n][w];

		if (wt[n - 1] <= w) {
			dp[n][w] = Math.max(val[n - 1] + solve(wt, val, w - wt[n - 1], n - 1), solve(wt, val, w, n - 1));
		} else {
			dp[n][w] = solve(wt, val, w, n - 1);
		}
		return dp[n][w];
	}

	public static void main(String[] args) {
		KnapsackMemoization knapsack = new KnapsackMemoization();
		int[] wt = new int[] { 5, 4, 6, 3 };
		int[] val = new int[] { 10, 40, 30, 50 };
		int w = 10;
		int n = wt.length;
		dp = new int[n + 1][w + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		int maxProfit = knapsack.solve(wt, val, w, n);
		System.out.println(maxProfit);
	}

}
