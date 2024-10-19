package com.hs.medium;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            if (num > sum) {
                sum = num;
            }

            max = Math.max(max, sum);
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
