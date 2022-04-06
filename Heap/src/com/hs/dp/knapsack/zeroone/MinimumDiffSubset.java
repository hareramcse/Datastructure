package com.hs.dp.knapsack.zeroone;

import java.util.ArrayList;
import java.util.List;

public class MinimumDiffSubset {
	private int minDiffernce(int arr[], int n) {
		int range = 0;
		for (int i = 0; i < n; i++)
			range = range + arr[i];
		List<Integer> list = subsetSum(arr, n, range);
		int mn = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++)
			mn = Math.min(mn, range - (2 * list.get(i)));
		return mn;
	}

	private List<Integer> subsetSum(int arr[], int n, int range) {
		int dp[][] = new int[n + 1][range + 1];

		for (int i = 0; i < range + 1; i++)
			dp[0][i] = 0;
		for (int i = 0; i < n + 1; i++)
			dp[i][0] = 1;

		for (int i = 1; i < n + 1; i++)
			for (int j = 1; j < range + 1; j++) {
				if (arr[i - 1] <= j)
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j];
			}

		List<Integer> list = new ArrayList<>();
		for (int i = n; i < n + 1; i++)
			for (int j = 0; j <= range / 2; j++) {
				if (dp[i][j] == 1)
					list.add(j);
			}

		return list;
	}

	public static void main(String[] args) {
		MinimumDiffSubset mds = new MinimumDiffSubset();
		int[] arr = { 4, 5, 2, 7, 1, 3 };
		int n = arr.length;
		int minDiffernce = mds.minDiffernce(arr, n);
		System.out.println(minDiffernce);
	}
}