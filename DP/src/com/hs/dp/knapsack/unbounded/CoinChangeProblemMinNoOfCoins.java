package com.hs.dp.knapsack.unbounded;

// 322. Coin Change Leetcode
public class CoinChangeProblemMinNoOfCoins {
	private int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n + 1][amount + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= amount; j++) {
				if (i == 0) {
					dp[i][j] = Integer.MAX_VALUE - 1;
				}
				if (j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
	}

	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		int amount = 11;
		CoinChangeProblemMinNoOfCoins ccpmnoc = new CoinChangeProblemMinNoOfCoins();
		int result = ccpmnoc.coinChange(coins, amount);
		System.out.println(result);
	}
}