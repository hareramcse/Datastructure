package com.hs.dp.knapsack.zeroone;

public class Knapsack {
	private int solve(int[] wt, int[] value, int w, int n) {
		if (n == 0 || w == 0)
			return 0;

		if (wt[n - 1] <= w) {
			return Math.max(value[n - 1] + solve(wt, value, w - wt[n - 1], n - 1), solve(wt, value, w, n - 1));
		} else {
			return solve(wt, value, w, n - 1);
		}
	}

	public static void main(String[] args) {
		Knapsack knapsack = new Knapsack();
		int[] wt = { 1, 4, 5, 6, 2, 3, 7, 8 };
		int[] value = { 2, 3, 4, 5, 1, 6, 8, 0 };
		int w = 10;
		int n = wt.length;
		int maxProfit = knapsack.solve(wt, value, w, n);
		System.out.println(maxProfit);
	}
}