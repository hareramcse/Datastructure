package com.hs.dp.subsequence;

import java.util.Arrays;

public class CoinChange2 {
	public int change(int amount, int[] coins) {
		int n = coins.length;
		int dp[][] = new int[n + 1][amount + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return solve(coins, n - 1, amount, dp);
	}

	private int solve(int[] coins, int n, int amount, int[][] dp) {
		if (amount == 0) {
			return 1;
		}

		if (n < 0 || amount < 0) {
			return 0;
		}

		if (dp[n][amount] != -1)
			return dp[n][amount];

		int notTaken = solve(coins, n - 1, amount, dp);

		int taken = 0;
		if (coins[n] <= amount)
			taken = solve(coins, n, amount - coins[n], dp);

		dp[n][amount] = notTaken + taken;
		return dp[n][amount];
	}
}
