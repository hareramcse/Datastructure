package com.hs.dp.subset;

public class MinimumDifferenceSubsets {
	public int minSubsetSumDifference(int[] arr, int n) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}

		Boolean[][] dp = new Boolean[n][sum + 1];
		int target = sum / 2;

		int min = Integer.MAX_VALUE;
		for (int s1 = 0; s1 <= target; s1++) {
			if (solve(n - 1, arr, s1, dp)) {
				min = Math.min(min, Math.abs(sum - 2 * s1));
			}
		}
		return min;
	}

	private boolean solve(int n, int[] nums, int target, Boolean[][] dp) {
		if (target == 0)
			return true;

		if (n < 0 || target < 0)
			return false;

		if (dp[n][target] != null)
			return dp[n][target];

		boolean taken = solve(n - 1, nums, target - nums[n], dp);
		boolean notTaken = solve(n - 1, nums, target, dp);
		dp[n][target] = notTaken || taken;

		return dp[n][target];
	}

	public static void main(String[] args) {
		MinimumDifferenceSubsets obj = new MinimumDifferenceSubsets();
		int[] arr = { 3, 9, 7, 3 };
		int result = obj.minSubsetSumDifference(arr, arr.length);
		System.out.println(result);
	}
}