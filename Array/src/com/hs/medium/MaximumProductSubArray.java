package com.hs.medium;

public class MaximumProductSubArray {
	public int maxProduct(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];

		for (int i = 1; i < nums.length; i++) {

			// On multiplying with negative number max will become min and min
			// will become max, when we encounter negative element, swap min, max
			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}

			max = Math.max(nums[i], max * nums[i]);
			min = Math.min(nums[i], min * nums[i]);

			result = Math.max(result, max);
		}
		return result;
	}

	public static void main(String[] args) {
		MaximumProductSubArray obj = new MaximumProductSubArray();
		int[] nums = { 2,3,-2,4 };
		System.out.println("Maximum Sub array product is " + obj.maxProduct(nums));
	}
}