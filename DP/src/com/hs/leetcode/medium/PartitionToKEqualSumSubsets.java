package com.hs.leetcode.medium;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		Arrays.sort(nums);

		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum % k != 0) {
			return false;
		}

		if (nums.length < k)
			return false;

		int target = sum / k;
		boolean[] visited = new boolean[nums.length];
		return canPartition(nums, k, visited, 0, 0, target);
	}

	private boolean canPartition(int[] nums, int k, boolean[] visited, int start, int curSum, int target) {
		if (k == 0)
			return true;

		if (curSum == target) {
			return canPartition(nums, k - 1, visited, 0, 0, target);
		}

		for (int i = start; i < nums.length; i++) {
			if (visited[i] || (curSum + nums[i] > target) || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
				continue;
			visited[i] = true;
			if (canPartition(nums, k, visited, i + 1, curSum + nums[i], target))
				return true;
			visited[i] = false;
		}
		return false;
	}

	public static void main(String[] args) {
		PartitionToKEqualSumSubsets obj = new PartitionToKEqualSumSubsets();
		int[] nums = { 2, 2, 2, 2, 3, 4, 5 };
		int k = 4;
		boolean result = obj.canPartitionKSubsets(nums, k);
		System.out.println(result);
	}
}