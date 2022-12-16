package com.hs.dp.subsequence;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];

		for (int row[] : dp)
			Arrays.fill(row, -1);

		int ans = solveMemo(coins, n - 1, amount, dp);
		if (ans >= (int) Math.pow(10, 9))
			return -1;
		return ans;
	}

	private int solveMemo(int[] coins, int n, int amount, int[][] dp) {
		if (n == 0) {
			if (amount % coins[0] == 0)
				return amount / coins[0];
			else
				return (int) Math.pow(10, 9);
		}

		if (dp[n][amount] != -1)
			return dp[n][amount];

		int notTaken = solveMemo(coins, n - 1, amount, dp);

		int taken = (int) Math.pow(10, 9);
		if (coins[n] <= amount)
			taken = 1 + solveMemo(coins, n, amount - coins[n], dp);

		return dp[n][amount] = Math.min(notTaken, taken);
	}

	private int solveTab(int[] coins, int amount) {
		int n = coins.length;
		int dp[][] = new int[n][amount + 1];

		for (int i = 0; i <= amount; i++) {
			if (i % coins[0] == 0)
				dp[0][i] = i / coins[0];
			else
				dp[0][i] = (int) Math.pow(10, 9);
		}

		for (int ind = 1; ind < n; ind++) {
			for (int target = 0; target <= amount; target++) {
				int notTake = 0 + dp[ind - 1][target];
				
				int take = (int) Math.pow(10, 9);
				if (coins[ind] <= target)
					take = 1 + dp[ind][target - coins[ind]];

				dp[ind][target] = Math.min(notTake, take);
			}
		}

		int ans = dp[n - 1][amount];
		if (ans >= (int) Math.pow(10, 9))
			return -1;
		return ans;
	}

	public static void main(String[] args) {
		CoinChange obj = new CoinChange();
		int[] arr = { 1, 2, 3 };
		int amount = 7;
		int result = obj.coinChange(arr, amount);
		System.out.println(result);
		result = obj.solveTab(arr, amount);
		System.out.println(result);
	}
}