package com.hs.dp.knapsack.unbounded;

public class CoinChangeProblemMinNoOfCoins {

	private int coinChangeProblem(int[] coin, int sum, int n) {
		int[][] dp = new int[n + 1][sum + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j == 0) {
					dp[i][j] = 0;
				} else if (i == 0) {
					dp[i][j] = Integer.MAX_VALUE - 1;
				}
			}
		}

		for (int i = 1; i <= 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (j % coin[0] == 0 && j / coin[0] == 1) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = Integer.MAX_VALUE - 1;
				}
			}
		}

		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (coin[i - 1] <= j) {
					dp[i][j] = Math.min(1 + dp[i][j - coin[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][sum] == Integer.MAX_VALUE - 1 ? 0 : dp[n][sum];
	}

	public static void main(String[] args) {
		int coin[] = { 3, 4, 5 };
		int sum = 5;
		int n = coin.length;
		CoinChangeProblemMinNoOfCoins ccpmnoc = new CoinChangeProblemMinNoOfCoins();
		int result = ccpmnoc.coinChangeProblem(coin, sum, n);
		System.out.println(result);
	}
}