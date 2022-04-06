package com.hs.dp.knapsack.unbounded;

public class CoinChangeNumberOfWays {
	private int knapsack(int[] coin, int N) {
		int[][] dp = new int[coin.length + 1][N + 1];

		for (int i = 0; i < coin.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= coin.length; i++) {
			for (int j = 1; j <= N; j++) {
				if (coin[i - 1] <= j) {
					dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[coin.length][N];
	}

	public static void main(String[] args) {
		CoinChangeNumberOfWays kbu = new CoinChangeNumberOfWays();
		int[] coin = new int[] { 5, 4, 6, 3 };
		int N = 10;
		int maxGain = kbu.knapsack(coin, N);
		System.out.println(maxGain);
	}
}