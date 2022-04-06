package com.hs.dp.mcm;

import java.util.Arrays;

public class EggDroppingMemoizedOptmization {
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
		int low, high = 0;
		for (int i = 1; i <= k; i++) {
			if (dp[n - 1][i - 1] != -1) {
				low = dp[n - 1][i - 1];
			} else {
				low = eggDrop(n - 1, i - 1);
				dp[n - 1][i - 1] = low;
			}

			if (dp[n][k - i] != -1) {
				high = dp[n][k - i];
			} else {
				high = eggDrop(n, k - i);
				dp[n][k - i] = high;
			}

			int res = Math.max(low, high);
			min = Math.min(min, res);
		}
		dp[n][k] = min + 1;
		return min + 1;
	}

	public static void main(String args[]) {
		EggDroppingMemoizedOptmization abcd = new EggDroppingMemoizedOptmization();
		int n = 2, k = 10;
		for (int i = 0; i < dp.length; i++)
			Arrays.fill(dp[i], -1);

		System.out.print("Minimum number of trials in worst case with " + n + " eggs and " + k + " floors is "
				+ abcd.eggDrop(n, k));
	}
}