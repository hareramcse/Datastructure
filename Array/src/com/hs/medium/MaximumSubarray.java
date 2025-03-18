package com.hs.medium;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(nums[i], maxSum + nums[i]);
            max = Math.max(max, maxSum);
        }

        return max;
    }

	public static void main(String[] args) {
		MaximumSubarray obj = new MaximumSubarray();
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int result = obj.maxSubArray(nums);
		System.out.println(result);
	}
}
