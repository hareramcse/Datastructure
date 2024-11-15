package com.hs.dp.subsequence;

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
		Boolean[][] dp = new Boolean[n][target + 1];

		return solve(nums, n - 1, target, dp);
	}

	private boolean solve(int[] nums, int n, int target, Boolean[][] dp) {
		if (target == 0)
			return true;

		if (n < 0 || target < 0)
			return false;

		if (dp[n][target] != null)
			return dp[n][target];

		boolean taken = solve(nums, n - 1, target - nums[n], dp);
		boolean notTaken = solve(nums, n - 1, target, dp);

		dp[n][target] = notTaken || taken;
		return notTaken || taken;
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
		boolean result = obj.canPartition(nums);
		System.out.println(result);
	}
}