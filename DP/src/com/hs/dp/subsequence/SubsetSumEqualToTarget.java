package com.hs.dp.subsequence;

public class SubsetSumEqualToTarget {
	public boolean isSubsetSumEqualToTarget(int[] arr, int target) {
		int n = arr.length;
		Boolean[][] dp = new Boolean[n][target + 1];
		return solve(arr, n - 1, target, dp);
	}

	private boolean solve(int[] arr, int n, int target, Boolean[][] dp) {
		if (target == 0)
			return true;

		if (n < 0 || target < 0)
			return false;

		if (dp[n][target] != null)
			return dp[n][target];

		boolean take = solve(arr, n - 1, target - arr[n], dp);
		boolean notTake = solve(arr, n - 1, target, dp);

		dp[n][target] = notTake || take;
		return dp[n][target];
	}

	public static void main(String[] args) {
		SubsetSumEqualToTarget obj = new SubsetSumEqualToTarget();
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		boolean result = obj.isSubsetSumEqualToTarget(arr, 9);
		System.out.println(result);
	}
}