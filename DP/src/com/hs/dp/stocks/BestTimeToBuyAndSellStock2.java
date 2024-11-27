package com.hs.dp.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {
	// Time complexity O(n)
	// Space Complexity O(n)
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return solveMemo(prices, 0, 0, dp);
	}

	private int solveMemo(int[] prices, int i, int buy, int[][] dp) {
		if (i == prices.length)
			return 0;

		if (dp[i][buy] != -1)
			return dp[i][buy];

		if (buy == 0) {
			int buyStock = -prices[i] + solveMemo(prices, i + 1, 1, dp);
			int notBuyStock = solveMemo(prices, i + 1, 0, dp);
			dp[i][buy] = Math.max(buyStock, notBuyStock);
		} else {
			int sale = prices[i] + solveMemo(prices, i + 1, 0, dp);
			int notSale = solveMemo(prices, i + 1, 1, dp);
			dp[i][buy] = Math.max(sale, notSale);
		}
		return dp[i][buy];
	}

	private int solveTab(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n + 1][2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		dp[n][0] = dp[n][1] = 0;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= 1; j++) {
				if (j == 0) {// We can buy the stock
					int buy = -prices[i] + dp[i + 1][1];
					int notBuy = dp[i + 1][0];
					dp[i][j] = Math.max(buy, notBuy);
				}

				if (j == 1) {// We can sell the stock
					int sale = prices[i] + dp[i + 1][0];
					int notSale = dp[i + 1][1];
					dp[i][j] = Math.max(sale, notSale);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock2 obj = new BestTimeToBuyAndSellStock2();
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int result = obj.maxProfit(prices);
		System.out.println(result);
		result = obj.solveTab(prices);
		System.out.println(result);
	}
}