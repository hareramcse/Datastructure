package com.hs.leetcode.medium;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		int n = nums.length;
		int sum = 0;
		int i, j;

		// Calculate sum of all elements
		for (i = 0; i < n; i++)
			sum += nums[i];

		if (sum % 2 != 0)
			return false;

		boolean part[][] = new boolean[sum / 2 + 1][n + 1];

		// initialize top row as true
		for (i = 0; i <= n; i++)
			part[0][i] = true;

		// initialize leftmost column, except part[0][0], as 0
		for (i = 1; i <= sum / 2; i++)
			part[i][0] = false;

		// Fill the partition table in bottom up manner
		for (i = 1; i <= sum / 2; i++) {
			for (j = 1; j <= n; j++) {
				part[i][j] = part[i][j - 1];
				if (i >= nums[j - 1])
					part[i][j] = part[i][j] || part[i - nums[j - 1]][j - 1];
			}
		}
		return part[sum / 2][n];
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
		int[] nums = { 1, 5, 11, 5 };
		boolean result = obj.canPartition(nums);
		System.out.println(result);
	}
}