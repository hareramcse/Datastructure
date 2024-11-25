package com.hs.fibonacci;

import java.util.Arrays;

public class HouseRobber1 {
	public int rob(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return solveMemo(n - 1, nums, dp);
	}

	private int solveMemo(int n, int[] arr, int[] dp) {
		if (n < 0)
			return 0;

		if (n == 0)
			return arr[n];

		if (dp[n] != -1)
			return dp[n];

		int notPick = solveMemo(n - 1, arr, dp);
		int pick = arr[n] + solveMemo(n - 2, arr, dp);
		dp[n] = Math.max(pick, notPick);
		return dp[n];
	}

	public static void main(String[] args) {
		HouseRobber1 obj = new HouseRobber1();
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		int result = obj.rob(arr);
		System.out.println(result);
	}
}