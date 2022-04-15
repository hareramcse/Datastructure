package com.hs.dp.knapsack.zeroone;

public class EqualSumSubset {
	private boolean canPartition(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];
		}

		if (sum % 2 != 0) {
			return false;
		} else {
			return subSetSum(nums, n, sum / 2);
		}
	}

	private boolean subSetSum(int[] nums, int n, int sum) {
		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					dp[i][j] = false;
				if (j == 0)
					dp[i][j] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}

			}
		}
		return dp[n][sum];
	}

	public static void main(String[] args) {
		EqualSumSubset kbu = new EqualSumSubset();
		int[] arr = new int[] { 5, 4, 6, 3 };
		boolean found = kbu.canPartition(arr);
		System.out.println(found);
	}
}