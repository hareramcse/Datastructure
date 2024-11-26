package com.hs.dp.knapsack;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];

		for (int row[] : dp)
			Arrays.fill(row, -1);

		int ans = solveMemo(n - 1, coins, amount, dp);
		if (ans >= (int) 1e9)
			return -1;

		return ans;
	}

	private int solveMemo(int n, int[] coins, int amount, int[][] dp) {
		if (amount == 0)
			return 0;

		if (n < 0 || amount < 0)
			return (int) 1e9;

		if (dp[n][amount] != -1)
			return dp[n][amount];

		int notTaken = solveMemo(n - 1, coins, amount, dp);
		int taken = 1 + solveMemo(n, coins, amount - coins[n], dp);
		dp[n][amount] = Math.min(notTaken, taken);

		return dp[n][amount];
	}

	public static void main(String[] args) {
		CoinChange obj = new CoinChange();
		int[] arr = { 1, 2, 3 };
		int amount = 7;
		int result = obj.coinChange(arr, amount);
		System.out.println(result);
	}
}