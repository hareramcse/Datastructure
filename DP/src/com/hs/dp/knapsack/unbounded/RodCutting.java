package com.hs.dp.knapsack.unbounded;

public class RodCutting {
	private int knapsack(int[] length, int[] price, int N) {
		int[][] dp = new int[length.length + 1][N + 1];

		for (int i = 0; i < length.length; i++) {
			for (int j = 0; j < N; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= length.length; i++) {
			for (int j = 1; j <= N; j++) {
				if (length[i - 1] <= j) {
					dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[length.length][N];
	}

	public static void main(String[] args) {
		RodCutting kbu = new RodCutting();
		int[] length = new int[] { 5, 4, 6, 3 };
		int[] price = new int[] { 10, 40, 30, 50 };
		int N = 10;
		int maxGain = kbu.knapsack(length, price, N);
		System.out.println(maxGain);
	}
}