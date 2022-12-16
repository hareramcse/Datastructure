package com.hs.dp.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return solveMemo(prices, 0, 0, dp);
	}

	private int solveMemo(int[] prices, int i, int buy, int[][] dp) {
		if (i >= prices.length)
			return 0;

		int profit = 0;

		if (dp[i][buy] != -1)
			return dp[i][buy];

		if (buy == 0) {
			int buyStock = -prices[i] + solveMemo(prices, i + 1, 1, dp);
			int notBuyStock = solveMemo(prices, i + 1, 0, dp);
			profit = Math.max(buyStock, notBuyStock);
		} else {
			int sale = prices[i] + solveMemo(prices, i + 2, 0, dp);
			int notSale = solveMemo(prices, i + 1, 1, dp);
			profit = Math.max(sale, notSale);
		}
		return dp[i][buy] = profit;
	}

	public int solveTab(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n + 2][2];

		// base condition
		dp[n][0] = dp[n][1] = 0;

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= 1; j++) {
				int profit = 0;

				if (j == 0) {// We can buy the stock
					int buy = -prices[i] + dp[i + 1][1];
					int notBuy = dp[i + 1][0];
					profit = Math.max(buy, notBuy);
				}

				if (j == 1) {// We can sell the stock
					int sale = prices[i] + dp[i + 2][0];
					int notSale = dp[i + 1][1];
					profit = Math.max(sale, notSale);
				}

				dp[i][j] = profit;
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStockWithCooldown obj = new BestTimeToBuyAndSellStockWithCooldown();
		int[] prices = { 1, 2, 3, 0, 2 };
		int result = obj.maxProfit(prices);
		System.out.println(result);
		result = obj.solveTab(prices);
		System.out.println(result);
	}
}