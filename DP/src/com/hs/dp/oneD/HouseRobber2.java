package com.hs.dp.oneD;

import java.util.Arrays;

public class HouseRobber2 {
	public int rob(int[] nums) {
		int[] arr1 = new int[nums.length - 1];
		int[] arr2 = new int[nums.length - 1];

		arr1 = Arrays.copyOfRange(nums, 1, nums.length);
		arr2 = Arrays.copyOfRange(nums, 0, nums.length - 1);

		if (nums.length == 1) {
			return nums[0];
		}

		int first = solve(arr1, arr1.length);
		int second = solve(arr2, arr2.length);
		return Math.max(first, second);
	}

	private int solve(int[] arr, int n) {
		int[] dp = new int[n];
		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			int pick = arr[i];
			if (i > 1)
				pick += dp[i - 2];
			int nonPick = 0 + dp[i - 1];

			dp[i] = Math.max(pick, nonPick);
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		HouseRobber2 obj = new HouseRobber2();
		int[] arr = { 1, 2, 3, 1 };
		int result = obj.rob(arr);
		System.out.println(result);
	}
}
