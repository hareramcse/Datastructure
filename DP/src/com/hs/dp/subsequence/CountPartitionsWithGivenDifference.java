package com.hs.dp.subsequence;

import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
	public int countPartitions(int[] arr, int d) {
		int n = arr.length;
		int totSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totSum += arr[i];
		}

		// Checking for edge cases
		if (totSum - d < 0)
			return 0;
		if ((totSum - d) % 2 == 1)
			return 0;

		int s2 = (totSum - d) / 2;

		int[][] dp = new int[n][s2 + 1];

		for (int row[] : dp)
			Arrays.fill(row, -1);

		return solveMemo(arr, n - 1, s2, dp);
	}

	private int solveMemo(int[] arr, int n, int target, int[][] dp) {
		if (n == 0) {
			if (target == 0 && arr[0] == 0)
				return 2;
			if (target == 0 || target == arr[0])
				return 1;
			return 0;
		}

		if (dp[n][target] != -1)
			return dp[n][target];

		int notTake = solveMemo(arr, n - 1, target, dp);

		int take = 0;
		if (target >= arr[n])
			take = solveMemo(arr, n - 1, target - arr[n], dp);

		return dp[n][target] = notTake + take;
	}

	public static void main(String[] args) {
		CountPartitionsWithGivenDifference obj = new CountPartitionsWithGivenDifference();
		int arr[] = { 5, 2, 6, 4 };
		int d = 3;
		int result = obj.countPartitions(arr, d);
		System.out.println(result);
	}
}