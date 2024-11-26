package com.hs.dp.knapsack;

import java.util.Arrays;

public class CoinChange2 {
	public int change(int amount, int[] coins) {
		int n = coins.length;
		int dp[][] = new int[n][amount + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return solveMemo(n - 1, coins, amount, dp);
	}

	private int solveMemo(int n, int[] coins, int amount, int[][] dp) {
		if (amount == 0) {
			return 1;
		}

		if (n < 0 || amount < 0) {
			return 0;
		}

		if (dp[n][amount] != -1)
			return dp[n][amount];

		int notTaken = solveMemo(n - 1, coins, amount, dp);
		int taken = solveMemo(n, coins, amount - coins[n], dp);
		dp[n][amount] = taken + notTaken;

		return dp[n][amount];
	}

	public static void main(String[] args) {
		CoinChange2 obj = new CoinChange2();
		int[] coins = { 1, 2, 5 };
		int amount = 5;
		int result = obj.change(amount, coins);
		System.out.println(result);
	}
}
