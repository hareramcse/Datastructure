package com.hs.subsequence;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0)
			return false;

		int n = nums.length;
		int target = sum / 2;
		int[][] dp = new int[n][target + 1];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		return solveMemo(nums, n - 1, target, dp);
	}

	private boolean solveMemo(int[] nums, int n, int target, int[][] dp) {
		if (target == 0)
			return true;

		if (n == 0)
			return nums[n] == target;

		if (dp[n][target] != -1)
			return dp[n][target] == 0 ? false : true;

		boolean notTaken = solveMemo(nums, n - 1, target, dp);

		boolean taken = false;
		if (target >= nums[n])
			taken = solveMemo(nums, n - 1, target - nums[n], dp);

		dp[n][target] = notTaken || taken ? 1 : 0;
		return notTaken || taken;
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
		boolean result = obj.canPartition(nums);
		System.out.println(result);
	}
}