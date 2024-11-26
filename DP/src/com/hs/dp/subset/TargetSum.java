package com.hs.dp.subset;

import java.util.Arrays;

public class TargetSum {
	public int findTargetSumWays(int[] nums, int target) {
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (sum - target < 0 || (sum - target) % 2 != 0)
			return 0;

		int s2 = (sum - target) / 2;

		int[][] dp = new int[n][s2 + 1];

		for (int row[] : dp)
			Arrays.fill(row, -1);

		return solve(nums, n - 1, s2, dp);
	}

	private int solve(int[] arr, int n, int target, int[][] dp) {
		if (n == 0) {
			if (target == 0 && arr[0] == 0)
				return 2;
			if (target == 0 || target == arr[0])
				return 1;
			return 0;
		}

		if (n < 0 || target < 0)
			return 0;

		if (dp[n][target] != -1)
			return dp[n][target];

		int notTake = solve(arr, n - 1, target, dp);
		int take = solve(arr, n - 1, target - arr[n], dp);
		dp[n][target] = notTake + take;
		
		return dp[n][target];
	}

	public static void main(String[] args) {
		TargetSum obj = new TargetSum();
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		int result = obj.findTargetSumWays(nums, target);
		System.out.println(result);
	}
}