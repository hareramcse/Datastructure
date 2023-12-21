package com.hs.greedy;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int ans = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum < nums[i]) {
				sum = nums[i];
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	public static void main(String[] args) {
		MaximumSubarray obj = new MaximumSubarray();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = obj.maxSubArray(nums);
		System.out.println(result);
	}
}
