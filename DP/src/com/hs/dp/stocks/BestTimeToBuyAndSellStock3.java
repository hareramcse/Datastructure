package com.hs.dp.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock3 {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n][2][3];
		for (int[][] rows : dp) {
			for (int[] row : rows) {
				Arrays.fill(row, -1);
			}
		}
		return solveMemo(prices, 0, 0, 2, dp);
	}

	private int solveMemo(int[] prices, int i, int buy, int cap, int[][][] dp) {
		if (i == prices.length || cap == 0)
			return 0;

		if (dp[i][buy][cap] != -1)
			return dp[i][buy][cap];

		int profit = 0;

		if (buy == 0) {
			int buyStock = -prices[i] + solveMemo(prices, i + 1, 1, cap, dp);
			int notBuyStock = solveMemo(prices, i + 1, 0, cap, dp);
			profit = Math.max(buyStock, notBuyStock);
		} else {
			int sale = prices[i] + solveMemo(prices, i + 1, 0, cap - 1, dp);
			int notSale = solveMemo(prices, i + 1, 1, cap, dp);
			profit = Math.max(sale, notSale);
		}
		return dp[i][buy][cap] = profit;
	}

	private int solveTab(int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n + 1][2][3];
		for (int[][] rows : dp) {
			for (int[] row : rows) {
				Arrays.fill(row, 0);
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= 1; j++) {
				for (int cap = 1; cap <= 2; cap++) {
					if (j == 0) {// We can buy the stock
						dp[i][j][cap] = Math.max(dp[i + 1][0][cap], -prices[i] + dp[i + 1][1][cap]);
					}

					if (j == 1) {// We can sell the stock
						dp[i][j][cap] = Math.max(0 + dp[i + 1][1][cap], prices[i] + dp[i + 1][0][cap - 1]);
					}
				}
			}
		}
		return dp[0][0][2];
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock3 obj = new BestTimeToBuyAndSellStock3();
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int result = obj.maxProfit(prices);
		System.out.println(result);
		result = obj.solveTab(prices);
		System.out.println(result);
	}
}