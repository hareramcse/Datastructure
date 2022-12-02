package com.hs.subsequence;

public class MinimumDifferenceSubsets {
	public int minSubsetSumDifference(int[] arr, int n) {
		int sum = 0;
		for (int num : arr)
			sum += num;

		int target = sum;
		boolean[][] dp = targetSumTab(arr, n, target);

		int mini = (int) 1e9;
		for (int s1 = 0; s1 <= sum / 2; s1++) {
			if (dp[n - 1][s1] == true)
				mini = Math.min(mini, Math.abs((sum - s1) - s1));
		}
		return mini;
	}

	public boolean[][] targetSumTab(int[] arr, int n, int k) {
		boolean dp[][] = new boolean[n][k + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		if (arr[0] <= k)
			dp[0][arr[0]] = true;

		for (int i = 1; i < n; i++) {
			for (int target = 1; target <= k; target++) {
				boolean notTaken = dp[i - 1][target];

				boolean taken = false;
				if (arr[i] <= target)
					taken = dp[i - 1][target - arr[i]];

				dp[i][target] = notTaken || taken;
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		MinimumDifferenceSubsets obj = new MinimumDifferenceSubsets();
		int[] arr = { 1, 2, 3, 4 };
		int result = obj.minSubsetSumDifference(arr, arr.length);
		System.out.println(result);
	}
}