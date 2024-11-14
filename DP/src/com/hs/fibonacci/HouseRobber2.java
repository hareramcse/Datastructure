package com.hs.fibonacci;

import java.util.Arrays;

public class HouseRobber2 {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int[] robSkippingLast = new int[nums.length - 1];
		int[] robSkippingFirst = new int[nums.length - 1];

		for (int i = 0; i < nums.length - 1; i++) {
			robSkippingLast[i] = nums[i];
			robSkippingFirst[i] = nums[i + 1];
		}

		int first = houseRob1(robSkippingLast);
		int second = houseRob1(robSkippingFirst);
		return Math.max(first, second);
	}

	private int houseRob1(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return robMemoization(nums, dp, n - 1);
	}

	private int robMemoization(int[] arr, int[] dp, int n) {
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
		HouseRobber2 obj = new HouseRobber2();
		int[] arr = { 2, 3, 2 };
		int result = obj.rob(arr);
		System.out.println(result);
	}
}
