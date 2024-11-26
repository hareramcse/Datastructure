package com.hs.dp.subset;

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

		return solveMemo(n - 1, nums, target, dp);
	}

	private boolean solveMemo(int n, int[] nums, int target, Boolean[][] dp) {
		if (target == 0)
			return true;

		if (n < 0 || target < 0)
			return false;

		if (dp[n][target] != null)
			return dp[n][target];

		boolean taken = solveMemo(n - 1, nums, target - nums[n], dp);
		boolean notTaken = solveMemo(n - 1, nums, target, dp);

		dp[n][target] = notTaken || taken;
		return dp[n][target];
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
		boolean result = obj.canPartition(nums);
		System.out.println(result);
	}
}