
package com.hs.dp.stocks;

public class BestTimeToBuyAndSellStock1 {
	public int maxProfit(int[] prices) {
		int minPrice = prices[0];
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - minPrice;
			maxProfit = Math.max(maxProfit, profit);
			minPrice = Math.min(minPrice, prices[i]);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock1 obj = new BestTimeToBuyAndSellStock1();
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = obj.maxProfit(arr);
		System.out.println(maxProfit);
	}
}
