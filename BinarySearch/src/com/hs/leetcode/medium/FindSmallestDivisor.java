package com.hs.leetcode.medium;

public class FindSmallestDivisor {
	public int smallestDivisor(int[] nums, int threshold) {
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}

		if (threshold == nums.length) {
			return max;
		}

		int low = 1;
		int high = max;
		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isPossible(nums, mid, threshold)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private boolean isPossible(int[] nums, int mid, int threshold) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += (int)Math.ceil(nums[i] * 1.0 / mid);
		}
		return res <= threshold;
	}
}
