package com.hs.dp.knapsack.zeroone;

// 494. Target Sum
public class TargetSum {
	private int targetSum(int[] nums, int target) {
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}

		if (sum < Math.abs(target) || (target + sum) % 2 != 0) {
			return 0;
		} else {
			int newTarget = (sum + target) / 2;
			return subSetSumCount(nums, newTarget, n);
		}
	}

	private int subSetSumCount(int[] arr, int sum, int n) {
		int[][] dp = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					dp[i][j] = 0;
				if (j == 0)
					dp[i][j] = 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			// here starts with 0 so that it will consider 0 in the array
			for (int j = 0; j <= sum; j++) {
				if (arr[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}

	public static void main(String[] args) {
		TargetSum kbu = new TargetSum();
		int[] arr = new int[] { 5, 4, 6, 3 };
		int sum = 10;
		int count = kbu.targetSum(arr, sum);
		System.out.println(count);
	}
}