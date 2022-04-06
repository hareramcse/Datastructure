package com.hs.dp.mcm;

import java.util.Arrays;

public class EggDroppingMemoized {
	private static int MAX = 100;
	private static int[][] dp = new int[MAX][MAX];

	private int eggDrop(int n, int k) {
		// If there are no floors, then no trials needed.
		// OR if there is one floor, one trial needed.
		if (k == 1 || k == 0)
			return k;

		// We need k trials for one egg and k floors
		if (n == 1)
			return k;

		int min = Integer.MAX_VALUE;

		if (dp[n][k] != -1) {
			return dp[n][k];
		}
		// Consider all droppings from 1st floor to kth floor and
		// return the minimum of these values plus 1.
		for (int i = 1; i <= k; i++) {
			int res = Math.max(eggDrop(n - 1, i - 1), eggDrop(n, k - i));
			min = Math.min(min, res);
		}
		dp[n][k] = min + 1;
		return min + 1;
	}

	public static void main(String args[]) {
		EggDroppingMemoized abcd = new EggDroppingMemoized();
		int n = 2, k = 10;
		 for (int i = 0; i < dp.length; i++)
	            Arrays.fill(dp[i], -1);
	            
		System.out.print("Minimum number of trials in worst case with " + n + " eggs and " + k + " floors is "
				+ abcd.eggDrop(n, k));
	}
}