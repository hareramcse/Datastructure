package com.hs.dp.subset;

public class SubsetSumEqualToTarget {
	public boolean isSubsetSumEqualToTarget(int[] arr, int target) {
		int n = arr.length;
		Boolean[][] dp = new Boolean[n][target + 1];
		return solveMemo(n - 1, arr, target, dp);
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
		SubsetSumEqualToTarget obj = new SubsetSumEqualToTarget();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		boolean result = obj.isSubsetSumEqualToTarget(arr, 9);
		System.out.println(result);
	}
}