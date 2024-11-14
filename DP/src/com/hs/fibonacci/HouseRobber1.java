package com.hs.fibonacci;

import java.util.Arrays;

public class HouseRobber1 {
	public int rob(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return robMemoization(nums, dp, n - 1);
	}

	public int robMemoization(int[] arr, int[] dp, int n) {
		if (n < 0)
			return 0;

		if (n == 0)
			return arr[n];

		if (dp[n] != -1)
			return dp[n];

		int pick = arr[n] + robMemoization(arr, dp, n - 2);
		int nonPick = 0 + robMemoization(arr, dp, n - 1);

		return dp[n] = Math.max(pick, nonPick);
	}

	public static void main(String[] args) {
		HouseRobber1 obj = new HouseRobber1();
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		int result = obj.rob(arr);
		System.out.println(result);
	}
}