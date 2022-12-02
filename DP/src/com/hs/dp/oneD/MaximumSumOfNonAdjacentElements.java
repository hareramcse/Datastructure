package com.hs.dp.oneD;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {

	public int findMaxSum(int arr[], int[] dp, int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return arr[n];
		if (dp[n] != -1)
			return dp[n];
		int pick = arr[n] + findMaxSum(arr, dp, n - 2);
		int nonPick = 0 + findMaxSum(arr, dp, n - 1);

		return dp[n] = Math.max(pick, nonPick);
	}

	public int findMaxSumMemo(int[] arr, int n) {
		int dp[] = new int[n];
		Arrays.fill(dp, -1);
		return findMaxSum(arr, dp, n - 1);
	}

	public int findMaxSumTab(int arr[], int n) {
		int[] dp = new int[n];
		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			int pick = arr[i];
			if (i > 1)
				pick += dp[i - 2];
			int nonPick = 0 + dp[i - 1];

			dp[i] = Math.max(pick, nonPick);
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		MaximumSumOfNonAdjacentElements obj = new MaximumSumOfNonAdjacentElements();
		int n = 6;
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		int result = obj.findMaxSumMemo(arr, n);
		System.out.println(result);
		result = obj.findMaxSumTab(arr, n);
		System.out.println(result);
	}
}