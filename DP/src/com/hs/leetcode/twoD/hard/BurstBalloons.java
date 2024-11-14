package com.hs.leetcode.twoD.hard;

public class BurstBalloons {
	public int maxCoins(int[] nums) {
		int[][] dp = new int[nums.length][nums.length];
		return maxCoins(nums, 0, nums.length - 1, dp);
	}

	private int maxCoins(int[] nums, int i, int j, int[][] dp) {
		if (i > j) {
			return 0;
		}
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		int max = nums[i];
		for (int ind = i; ind <= j; ind++) {
			int val = get(nums, i - 1) * get(nums, ind) * get(nums, j + 1) + maxCoins(nums, i, ind - 1, dp)
					+ +maxCoins(nums, ind + 1, j, dp);

			max = Math.max(max, val);
		}
		dp[i][j] = max;
		return max;
	}

	public int get(int[] nums, int i) {
		if (i == -1 || i == nums.length) {
			return 1;
		}
		return nums[i];
	}

	public static void main(String[] args) {
		BurstBalloons obj = new BurstBalloons();
		int[] nums = { 3, 1, 5, 8 };
		int result = obj.maxCoins(nums);
		System.out.println(result);
	}
}