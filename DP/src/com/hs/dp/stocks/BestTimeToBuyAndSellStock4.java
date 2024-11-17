package com.hs.dp.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock4 {
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n][2][k + 1];
		for (int[][] rows : dp) {
			for (int[] row : rows) {
				Arrays.fill(row, -1);
			}
		}
		return solveMemo(prices, 0, 0, k, dp);
	}

	private int solveMemo(int[] prices, int i, int buy, int cap, int[][][] dp) {
		if (i == prices.length || cap == 0)
			return 0;

		if (dp[i][buy][cap] != -1)
			return dp[i][buy][cap];

		if (buy == 0) {
			int buyStock = -prices[i] + solveMemo(prices, i + 1, 1, cap, dp);
			int notBuyStock = solveMemo(prices, i + 1, 0, cap, dp);
			dp[i][buy][cap] = Math.max(buyStock, notBuyStock);
		} else {
			int sale = prices[i] + solveMemo(prices, i + 1, 0, cap - 1, dp);
			int notSale = solveMemo(prices, i + 1, 1, cap, dp);
			dp[i][buy][cap] = Math.max(sale, notSale);
		}
		return dp[i][buy][cap];
	}

	private int solveTab(int k, int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n + 1][2][k + 1];
		for (int[][] rows : dp) {
			for (int[] row : rows) {
				Arrays.fill(row, 0);
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= 1; j++) {
				for (int cap = 1; cap <= k; cap++) {
					if (j == 0) {// We can buy the stock
						dp[i][j][cap] = Math.max(dp[i + 1][0][cap], -prices[i] + dp[i + 1][1][cap]);
					}

					if (j == 1) {// We can sell the stock
						dp[i][j][cap] = Math.max(0 + dp[i + 1][1][cap], prices[i] + dp[i + 1][0][cap - 1]);
					}
				}
			}
		}
		return dp[0][0][k];
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock4 obj = new BestTimeToBuyAndSellStock4();
		int[] prices = { 3, 2, 6, 5, 0, 3 };
		int result = obj.maxProfit(2, prices);
		System.out.println(result);
		result = obj.solveTab(2, prices);
		System.out.println(result);
	}
}
