package com.hs.dp.fibonacci;

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

	public int houseRob1(int[] nums) {
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
		HouseRobber2 obj = new HouseRobber2();
		int[] arr = { 2, 3, 2 };
		int result = obj.rob(arr);
		System.out.println(result);
	}
}
