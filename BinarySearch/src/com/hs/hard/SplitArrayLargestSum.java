package com.hs.hard;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int m) {
		int low = 0;
		int high = 0;

		for (int num : nums) {
			low = Math.max(low, num);
			high += num;
		}

		if (m == nums.length) {
			return low;
		}

		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canSplit(nums, m, mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private boolean canSplit(int[] nums, int m, int maxSum) {
		int count = 1; // Number of subarrays
		int currentSum = 0;
		for (int num : nums) {
			if (currentSum + num > maxSum) {
				count++; // Need a new subarray
				currentSum = num; // Start the new subarray
				if (count > m) {
					return false;
				}
			} else {
				currentSum += num;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SplitArrayLargestSum obj = new SplitArrayLargestSum();
		int[] nums = { 7, 2, 5, 10, 8 };
		int k = 2;
		int result = obj.splitArray(nums, k);
		System.out.println(result);
	}
}