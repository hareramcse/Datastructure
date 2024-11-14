package com.hs.leetcode.twoD.medium;

import java.util.Arrays;

public class CoinChange2 {
	public int change(int amount, int[] coins) {
		int n = coins.length;
		int dp[][] = new int[n][amount + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return solveMemo(coins, n - 1, amount, dp);
	}

	private int solveMemo(int[] coins, int n, int amount, int[][] dp) {
		if (n == 0) {
			if (amount % coins[0] == 0)
				return 1;
			else
				return 0;
		}

		if (dp[n][amount] != -1)
			return dp[n][amount];

		int notTaken = solveMemo(coins, n - 1, amount, dp);

		int taken = 0;
		if (coins[n] <= amount)
			taken = solveMemo(coins, n, amount - coins[n], dp);

		return dp[n][amount] = notTaken + taken;
	}
}
