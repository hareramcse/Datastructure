package com.hs.leetcode.easy;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int minPrice = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = obj.maxProfit(arr);
		System.out.println(maxProfit);
	}
}
